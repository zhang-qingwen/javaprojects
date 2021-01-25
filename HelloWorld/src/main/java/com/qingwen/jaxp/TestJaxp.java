package com.qingwen.jaxp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestJaxp {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        selectAll();
    }

    private static Document getDocument() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        return documentBuilder.parse("src\\main\\resources\\person.xml");
    }

    private static void selectOne() throws ParserConfigurationException, SAXException, IOException{
        Document document = getDocument();
        NodeList nodeList = document.getElementsByTagName("name");

    }

    private static void selectAll() throws ParserConfigurationException, SAXException, IOException {
        //查询所有Name元素的值
        /**
         * Step 1:创建解析器工厂
         * Step 2:根据解析器工厂创建解析器
         * Step 3:解析XML返回Document
         * Step 4:是得到所有的Name元素
         * Step 5:遍历集合
         **/
        Document document = getDocument();

        NodeList nodeList = document.getElementsByTagName("name");

        for (int i=0;i<nodeList.getLength();i++) {
            Node name1 = nodeList.item(i);

            System.out.println(name1.getTextContent());
        }
    }
}
