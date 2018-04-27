package com.test.template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

public class GenXML {  
    public static String readFile(String filePath) {  
        StringBuffer sb = new StringBuffer();  
        File file = new File(filePath);  
        FileReader fr = null;  
        try {  
            fr = new FileReader(file);  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        }  
        BufferedReader br = new BufferedReader(fr);  
  
        String strLine = "";  
        try {  
            while ((strLine = br.readLine()) != null) {  
                sb.append(strLine);  
                sb.append("\n");  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                fr.close();  
                br.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return sb.toString();  
    }  
      
    public static void main(String[] args) {  
        final String  head = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n";  
        final String root_start = "<root>";  
        final String root_end = "</root>";  
        StringBuffer sb = new StringBuffer();  
        sb.append(head);  
        sb.append(root_start+"\n");  
        MessageFormat mf = new MessageFormat(readFile("src/main/resources/template/msg.xml"));  
        sb.append(mf.format(new Object[] { "11", "12", "13", "14"}));  
        sb.append(mf.format(new Object[] { "21", "22", "23", "24"}));  
        sb.append(root_end);  
        System.out.println(sb.toString());  
    }  
}  