package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServerDome2 {
    public static void main(String[] args) throws Exception {
        System.out.println("==============服务端启动==============");
        DatagramSocket socket=new DatagramSocket(8080);

        byte[]buf=new byte[1024*64];
        while (true) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            socket.receive(packet);
            int len = packet.getLength();
            String data = new String(buf, 0, len);
            System.out.println("客户端：" + data);


            String ip = packet.getAddress().getHostAddress();
            int port = packet.getPort();
            System.out.println("对方ip:" + ip + "对方端口：" + port);
        }

    }
}
