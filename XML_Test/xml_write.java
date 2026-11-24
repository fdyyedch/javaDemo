package XML_Test;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class xml_write {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
        sb.append("<book>\r\n");
        sb.append("\t<name>从入门到跑路</name>\r\n");
        sb.append("\t<author>dlei</author>\r\n");
        sb.append("\t<price>9999</price>\r\n");
        sb.append("</book>");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("/home/honor/IdeaProjects/untitled1/src/XML_Test/text1.xml"))){
            bw.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
