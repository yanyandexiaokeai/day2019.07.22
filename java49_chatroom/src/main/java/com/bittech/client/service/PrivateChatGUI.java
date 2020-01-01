//私聊请求端
package com.bittech.client.service;

import com.bittech.util.CommUtil;
import com.bittech.vo.MessageVO;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class PrivateChatGUI {
    private JPanel privateChatPanel;
    private JTextArea readFromServer;
    private JTextField send2Server;
    private JFrame frame;
    private String friendName;
    private String myName;
    private Connect2Server connect2Server;

    public PrivateChatGUI(String friendName,
                          String myName,
                          Connect2Server connect2Server) {
        this.friendName = friendName;
        this.myName = myName;
        this.connect2Server = connect2Server;//连接
        frame = new JFrame("与" + friendName + "私聊中……");
        frame.setContentPane(privateChatPanel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//让窗口不可见 //EXIT_ON_CLOSE 直接退出
        frame.setSize(400, 400);//设置大小
        frame.setVisible(true);

        //添加一个输入框的事件，敲回车发送消息
            send2Server.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    StringBuilder sb = new StringBuilder();//记录按键
                    sb.append(send2Server.getText());//拼接按键
                    //当按下回车键时，发送信息
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        String str = sb.toString();
                        MessageVO messageVO = new MessageVO();//拼接MessageVO
                        messageVO.setType(2);
                        messageVO.setContent(myName + "-" + str);
                        messageVO.setTo(friendName);
                        try {
                            PrintStream out = new PrintStream(connect2Server.getOut(),
                                    true, "UTF-8");
                            out.println(CommUtil.object2Json(messageVO));
                            //刷新自己的信息读取框
                            readFromServer.append(myName + "说：" + str + "\n");
                            //清空输入框
                            send2Server.setText("");
                        } catch (UnsupportedEncodingException e1) {
                            e1.printStackTrace();
                        }

                    }
                }
            });
        }
       public void readFromServer(String msg){
        readFromServer.append(msg+"/n");
       }

       public JFrame getFrame(){
        return frame;
       }
}