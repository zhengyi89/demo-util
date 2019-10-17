package com.demo.parse;

import java.io.File;   
import java.io.FileWriter;   
import java.io.IOException;   
import java.io.Writer;   
import java.util.Iterator;   

import org.dom4j.Document;   
import org.dom4j.DocumentException;   
import org.dom4j.DocumentHelper;   
import org.dom4j.Element;   
import org.dom4j.io.SAXReader;   
import org.dom4j.io.XMLWriter;   
/**  
*   
* @author hongliang.dinghl  
* Dom4j ����XML�ĵ������XML�ĵ�  
*/  
public class Dom4jDemo {   

	public void createXml(String fileName) {   
		Document document = DocumentHelper.createDocument();   
		Element employees=document.addElement("employees");   
		Element employee=employees.addElement("employee");   
		Element name= employee.addElement("name");   
		name.setText("ddvip");   
		Element sex=employee.addElement("sex");   
		sex.setText("m");   
		Element age=employee.addElement("age");   
		age.setText("29");   
		try {   
			Writer fileWriter=new FileWriter(fileName);   
			XMLWriter xmlWriter=new XMLWriter(fileWriter);   
			xmlWriter.write(document);   
			xmlWriter.close();   
		} catch (IOException e) {   
		
			System.out.println(e.getMessage());   
		}   
	
	
	}   
	
	
	public void parserXml(String fileName) {   
		File inputXml=new File(fileName);   
		SAXReader saxReader = new SAXReader();   
		try {   
			Document document = saxReader.read(inputXml);   
			Element employees=document.getRootElement();   
			for(Iterator i = employees.elementIterator(); i.hasNext();){   
				Element employee = (Element) i.next();   
//				System.out.println("1:"+employee.attributeValue("name")+" ");
				System.out.println("INSERT into category VALUES ('1', '"+employee.attributeValue("name")+"', '', 1);");
				Iterator m = employee.elementIterator(); 
				Element employee1 = (Element)m.next(); 
				int i1 = 1;
				int i2 = 42;
				for(Iterator j = employee1.elementIterator(); j.hasNext();){   
					Element node=(Element) j.next();   
//					System.out.println("---"+(++i1)+":1:"+node.attributeValue("name")+" ");   
					System.out.println("INSERT into category VALUES ("+(++i1)+", '"+node.attributeValue("name")+"', 1, 1);");
					Iterator m2 = node.elementIterator(); 
					
					if (m2.hasNext()) {
						Element employee2 = (Element)m2.next();
						for(Iterator j1 = employee2.elementIterator(); j1.hasNext();){   
							Element node1=(Element) j1.next();   
//							System.out.println("------"+i2+++":"+i1+":"+node1.attributeValue("name")+" ");   
							System.out.println("INSERT into category VALUES ("+i2+++", '"+node1.attributeValue("name")+"', "+i1+", 1);");
						} 
					}
				} 
				
				System.out.println();
			}   
		} catch (DocumentException e) {   
			System.out.println(e.getMessage());   
		}   
	}   
	
	
	public static void main(String[] args) {
		new Dom4jDemo().parserXml("e:/cc.txt");
	}
}   
