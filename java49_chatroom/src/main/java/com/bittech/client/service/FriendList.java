package com.bittech.client.service;

import com.bittech.util.CommUtil;
import com.bittech.vo.MessageVO;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FriendList {
    private JPanel friendListPanel;
    private JScrollPane friendPanel;
    private JButton createGroupBtn;
    private JScrollPane groupPanel;
    private String myName;
    private Connect2Server connect2Server;
    private Set<String> names;

    //缓存所有的私聊界面
    private Map<String,PrivateChatGUI> privateChatGUIMap = new ConcurrentHashMap<>();

    private class DaemonTask implements Runnable {
        private Scanner scanner = new Scanner(connect2Server.getIn());
        @Override
        public void run() {
            while (true) {
                if (scanner.hasNextLine()) {
                    String strFromServer = scanner.nextLine();
                    if (strFromServer.startsWith("newLogin:")){
                        // 好友上线提醒
                        String newFriend = strFromServer.split(":")[1];
                        JOptionPane.showMessageDialog(null,
                                newFriend+"上线了!","上线提醒",
                                JOptionPane.INFORMATION_MESSAGE);
                        names.add(newFriend);
                        // 再次刷新好友列表
                        reloadFriendList();
                    }
                    if(strFromServer.startsWith("{")){
                        //此时是个json串
                        MessageVO messageVOFromClient = (MessageVO) CommUtil.json2Object(strFromServer,
                                MessageVO.class);
                        if (messageVOFromClient.getType().equals(2)){
                            //私聊信息
                            String senderName = messageVOFromClient.getContent()
                                    .split("-")[0];//发送者的名字
                            String msg = messageVOFromClient.getContent()
                                    .split("-")[1];//发送的内容
                            if (privateChatGUIMap.containsKey(senderName)){
                                PrivateChatGUI privateChatGUI = privateChatGUIMap.get(senderName);
                                privateChatGUI.getFrame().setVisible(true);
                                privateChatGUI.readFromServer(senderName+"说："+msg);
                            }else{
                                PrivateChatGUI privateChatGUI = new PrivateChatGUI(senderName,
                                        myName,connect2Server);
                                privateChatGUIMap.put(senderName,privateChatGUI);
                                privateChatGUI.readFromServer(senderName+"说："+msg);
                            }

                        }
                    }
                }
            }
        }
    }

    private class PrivatelateLabelAction implements MouseListener{
        private String lableName;//传入鼠标名字
        public PrivatelateLabelAction(String lableName){
            this.lableName = lableName;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            //判断缓存中是否有指定的私聊界面
            if (privateChatGUIMap.containsKey(lableName)){
                PrivateChatGUI privateChatGUI = privateChatGUIMap.get(lableName);
                privateChatGUI.getFrame().setVisible(true);
            }else{
                PrivateChatGUI privateChatGUI = new PrivateChatGUI(lableName,
                        myName,connect2Server);
                privateChatGUIMap.put(lableName,privateChatGUI);
            }

        }//鼠标点击

        @Override
        public void mousePressed(MouseEvent e) {

        }//鼠标一直按着

        @Override
        public void mouseReleased(MouseEvent e) {

        }//鼠标按下释放

        @Override
        public void mouseEntered(MouseEvent e) {

        }//鼠标移入

        @Override
        public void mouseExited(MouseEvent e) {

        }//鼠标移出
    }

    public FriendList(String myName,
                      Connect2Server connect2Server,
                      Set<String> names) {
        this.myName = myName;
        this.connect2Server = connect2Server;
        this.names = names;
        JFrame frame = new JFrame(myName);
        frame.setContentPane(friendListPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        reloadFriendList();
        // 新启动一个后台线程不断监听服务器发来的信息
        Thread daemonThread = new Thread(new DaemonTask());
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    public void reloadFriendList() {
        JPanel friendLabelPanel = new JPanel();
        JLabel[] labels = new JLabel [names.size()];
        // 迭代遍历set集合
        Iterator<String> iterator = names.iterator();
        // 设置标签为纵向对其
        friendLabelPanel.setLayout(new BoxLayout(friendLabelPanel,
                BoxLayout.Y_AXIS));
        int i = 0;
        while (iterator.hasNext()) {
            String labelName = iterator.next();
            labels[i] = new JLabel(labelName);
            //给每个标签附加按钮的点击事件
            labels[i].addMouseListener(new PrivatelateLabelAction(labelName));
            friendLabelPanel.add(labels[i]);
            i++;
        }
        this.friendPanel.setViewportView(friendLabelPanel);
        // 设置滚动条为垂直滚动条
        this.friendPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.friendPanel.revalidate();
    }
}
