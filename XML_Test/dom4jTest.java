package XML_Test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.swing.text.DefaultStyledDocument;
import javax.xml.parsers.SAXParser;
import java.util.List;

public class dom4jTest {
    public static void main(String[] args) throws Exception {
        SAXReader saxReader=new SAXReader();

        Document document= saxReader.read("/home/honor/IdeaProjects/untitled1/src/XML_Test/text.xml");

        Element root=document.getRootElement();
        System.out.println(root.getName());


        List<Element>elements=root.elements();
        for (Element element : elements) {
            System.out.println(element.getName());
        }

        Element people= root.element("people");
        System.out.println(people.getText());

        Element user=root.element("user");
        System.out.println(user.elementText("name"));


        List<Attribute> attributes = user.attributes();
        for (Attribute attribute : attributes) {
            System.out.println(attribute.getName()+"="+attribute.getValue());
        }

        System.out.println(user.elementText("name"));
        System.out.println(user.elementText("age"));
        System.out.println(user.elementText("password"));


    }
}


































