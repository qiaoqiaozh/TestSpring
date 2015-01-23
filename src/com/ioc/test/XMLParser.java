package com.ioc.test;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;

import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Created by mouse on 15/1/23.
 */
public class XMLParser {
    private HashMap<String,Object> properties ;
    private NodeList nl;
    public XMLParser(String xmlFileName)
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File(xmlFileName));
            Element root = document.getDocumentElement();
            if(root == null) return ;
            nl = root.getChildNodes();
            if(nl == null) return;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Class<?> getBean(String className)
    {
        Class<?> clazz = null;

        if(nl == null) return clazz;

        for(int i = 0 ;i!=nl.getLength(); i++){
            Node e = nl.item(i);

            if(e.hasAttributes()&&e.getAttributes().getNamedItem("id").getTextContent().equals(className))
            {
                String s = e.getAttributes().getNamedItem("class").getNodeValue();
                try {
                    clazz = Class.forName(s);
                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
                return clazz;
            }
        }
        return clazz;
    }
}
