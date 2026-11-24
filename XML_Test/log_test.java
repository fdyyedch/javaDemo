package XML_Test;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class log_test {
    public static final Logger LOGGER= LoggerFactory.getLogger("LogBackTest");
    public static void main(String[] args) {
        try {
            LOGGER.info("-------chu start-------");
            chu(10,0);
            LOGGER.info("-------------chu success-------------");
        }catch (Exception e){
            LOGGER.error("chu has bug!!!");
        }
    }

    public static void chu(int a,int b){
        LOGGER.debug("参数a:"+a);
        LOGGER.debug("参数b:"+b);
        int c=a/b;
        LOGGER.info("结果是："+c);
    }
}

















