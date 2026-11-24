package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("==============客户端启动==============");
        DatagramSocket socket = new DatagramSocket();

        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("请说：");
            String msg=sc.nextLine();

            if("exit".equals(msg)){
                System.out.println("==============客户端退出==============");
                break;
            }
            byte[]bytes=msg.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet=new DatagramPacket(bytes,bytes.length,
                    InetAddress.getLocalHost(),8080);

            socket.send(packet);

        }
        socket.close();
        sc.close();

    }
}


















