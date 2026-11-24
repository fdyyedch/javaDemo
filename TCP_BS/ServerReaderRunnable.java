package TCP_BS;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerReaderRunnable implements Runnable {
    private Socket socket;

    public ServerReaderRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // ✅第一步：读取浏览器HTTP请求（解决Firefox一直加载！）
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                //读到空行 = 请求头结束，退出循环
                if (line.isEmpty()) {
                    break;
                }
            }

            // ✅准备输出HTTP响应
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os, true); //true开启自动flush

            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=utf-8");
            ps.println();

            ps.println("<html>");
            ps.println("<head>");
            ps.println("<meta charset='utf-8'>");
            ps.println("<title>HELLO!!!</title>");
            ps.println("</head>");
            ps.println("<body>");
            ps.println("<h1 style='color:red;font-size:20px'>java is the best LaGrange</h1>");
            ps.println("</body>");
            ps.println("</html>");

            ps.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("一个客户端下线了:" + socket.getInetAddress().getHostAddress());
            } catch (Exception ex) {
                System.out.println("连接异常断开");
            }
        }
    }
}

