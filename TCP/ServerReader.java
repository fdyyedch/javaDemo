package TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerReader extends Thread {
    private Socket socket;
    public ServerReader(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run(){

        try {
            InputStream is=socket.getInputStream();
            DataInputStream dis=new DataInputStream(is);
            String msg=dis.readUTF();
            System.out.println("收到客户端msg="+msg);
            System.out.println("客户端ip="+socket.getInetAddress().getHostAddress());
            System.out.println("客户端的端口="+socket.getPort());
            System.out.println("================================");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("一个客户端下线了:"+socket.getInetAddress().getHostAddress());
        }
    }
}
