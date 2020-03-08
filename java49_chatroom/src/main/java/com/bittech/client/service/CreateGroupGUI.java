package com.bittech.client.service;

import com.bittech.util.CommUtil;
import com.bittech.vo.MessageVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CreateGroupGUI {
    private JPanel createGroupPanel;
    private JPanel checkBoxPanel;
    private JTextField groupNameText;
    private JButton conformBtn;

    private Set<String> friends;
    private String myName;
    private Connect2Server connect2Server;
    private FriendList friendList;

    public CreateGroupGUI(Set<String> friends,
                          String myName,//自己姓名
                          Connect2Server connect2Server,
                          FriendList friendList){//连接服务器
        this.friends = friends;
        this.myName = myName;
        this.connect2Server = connect2Server;
        this.friendList = friendList;
        JFrame frame = new JFrame("创建群组");//标题
        frame.setContentPane(createGroupPanel);//内容
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);//剧中显示
        frame.setVisible(true);
        //1、动态的添加checkBox
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel,
                BoxLayout.Y_AXIS));//设置垂直显示
        Iterator<String> iterator = friends.iterator();
        while(iterator.hasNext()){
            String friendName = iterator.next();
            JCheckBox checkBox = new JCheckBox(friendName);
            checkBoxPanel.add(checkBox);
        }
        checkBoxPanel.revalidate();
        //2、提交信息按键
        conformBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  1、获取群名
                String groupName = groupNameText.getText();
                //2、获取选中的好友名称
                Set<String> selectedFriends = new HashSet<>();
                //3、获取checkBoxPanel下的所有组件
                Component[] components = checkBoxPanel.getComponents();
                for (Component component : components){
                    //向下转型
                    JCheckBox checkBox = (JCheckBox) component;
                    if(checkBox.isSelected()){
                        selectedFriends.add(checkBox.getText());
                    }
                }
                selectedFriends.add(myName);//不要忘记加上自己
                //4、将群名和选择的好友发送到服务端
                //  type:3
                //content:groupname
                //to:[]
                MessageVO messageVO = new MessageVO();
                messageVO.setType(3);
                messageVO.setContent(groupName);
                messageVO.setTo(CommUtil.object2Json(selectedFriends));
                try{
                    PrintStream out =new PrintStream(connect2Server.getOut(),
                            true,"UTF-8");
                    out.println(CommUtil.object2Json(messageVO));
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
                frame.setVisible(false);
                friendList.addGroupInfo(groupName,selectedFriends);
                friendList.reloadGroupList();
            }
        });
    }
}
