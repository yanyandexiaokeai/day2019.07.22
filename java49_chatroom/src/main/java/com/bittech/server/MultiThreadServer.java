//服务端
package com.bittech.server;

import com.bittech.util.CommUtil;
import com.bittech.vo.MessageVO;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {
    private static final Integer PORT;
    static {
        Properties pros = CommUtil.loadProperties("socket.properties");
        PORT = Integer.valueOf(pros.getProperty("PORT"));
    }
    // 服务端缓存所有连接的客户端对象
    private static Map<String, Socket> clients
            = new ConcurrentHashMap<>();
    // 服务端具体处理客户端请求的任务
    private static class ExecuteClient implements Runnable {
        private Socket client;
        private Scanner in;
        private PrintStream out;
        public ExecuteClient(Socket client) {
            this.client = client;
            try {
                this.in = new Scanner(client.getInputStream());
                this.out = new PrintStream(client.getOutputStream(),
                        true,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            while (true) {
                if (in.hasNextLine()) {
                    String strFromClient = in.nextLine();
                    MessageVO msgFromClient = (MessageVO) CommUtil.json2Object(strFromClient,
                            MessageVO.class);
                    if (msgFromClient.getType().equals(1)) {
                        // 新用户注册
                        String userName = msgFromClient.getContent();
                        // 将当前聊天室在线好友信息发回给新用户
                        Set<String> names = clients.keySet();
                        MessageVO msg2Client = new MessageVO();
                        msg2Client.setType(1);
                        msg2Client.setContent(CommUtil.object2Json(names));
                        out.println(CommUtil.object2Json(msg2Client));
                        // 将新用户上线信息发给其他在线用户
                        String loginMsg = "newLogin:"+userName;
                        for (Socket socket : clients.values()) {
                            try {
                                PrintStream out = new PrintStream(socket.getOutputStream(),
                                        true,"UTF-8");
                                out.println(loginMsg);
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        // 将新用户信息保存到当前服务端缓存
                        System.out.println(userName+"上线了!");
                        clients.put(userName,client);
                        System.out.println("当前聊天室在线人数为:"+clients.size());
                    }
                    else if (msgFromClient.getType().equals(2)){
                        //私聊信息
                        String friendName = msgFromClient.getTo();
                        Socket socket = clients.get(friendName);
                        try {
                            PrintStream out = new PrintStream(socket.getOutputStream(),
                                    true,"UTF-8");
                            MessageVO msg2Client = new MessageVO();
                            msg2Client.setType(2);
                            msg2Client.setContent(msgFromClient.getContent());
                            out.println(CommUtil.object2Json(msg2Client));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 1.建立基站
        ServerSocket server = new ServerSocket(PORT);
        ExecutorService executors = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            System.out.println("等待客户端连接...");
            Socket client = server.accept();
            System.out.println("有新的连接..端口号为:"+client.getPort());
            executors.submit(new ExecuteClient(client));
        }
    }
}
