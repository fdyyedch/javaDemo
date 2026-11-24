package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class jdbc {

    public static void main(String[] args) throws Exception {

        //1.注册驱动（Connector/J 8.x/26.x 也可省略这一行，jar 内有 SPI 会自动注册）
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接：主机和端口写全，不依赖“省略主机=本机默认端口”的隐含行为；
        //  allowPublicKeyRetrieval 在服务重启、认证缓存为空时是必需的，否则会报
        //  Public Key Retrieval is not allowed
        String url = "jdbc:mysql://127.0.0.1:3306/test"
                + "?useSSL=false&serverTimeZone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "123456";

        //3.定义sql
        //String sql = "update emp set age=65 where id=4";   // 执行 DML 用 executeUpdate
        String sql = "select * from emp";


        List<Account> list=new ArrayList<>();
        //4.连接、语句、结果集统一交给 try-with-resources，按声明逆序自动关闭，
        //  中途抛异常也不会泄漏连接
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //5.处理结果，遍历 rs 中的所有数据。
            while (rs.next()) {
                Account account=new Account();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                account.setId(id);
                account.setName(name);
                account.setAge(age);

                list.add(account);

               /* System.out.println(id);
                System.out.println(name);
                System.out.println(age);
                System.out.println("------------------------");

                */
            }
        }
        System.out.println(list);
    }
}
