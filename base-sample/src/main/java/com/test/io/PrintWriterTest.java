package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class PrintWriterTest {
	/**
	 * 获取 PrintStream 单例
	 * @return
	 */
	private synchronized static PrintStream getErrFileIO(){
		String logDirectory = "d:\\";
		PrintStream output = null;
		//判断路径是否存在，不存在创建
		if (output==null) {
			File f = new File(logDirectory);
			if (!f.exists()) {
				f.mkdirs();
			}
			//文件不存在创建
			f = new File(logDirectory+"\\details.log");
			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				output = new PrintStream(new FileOutputStream(f, true));
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		return output;
	}
	
	
	public static void main(String[] args) {
        try {
        // read file content from file
        StringBuffer sb= new StringBuffer("");
        FileReader reader = new FileReader("d://aa.txt"); 
        BufferedReader br = new BufferedReader(reader);
        FileWriter writer = new FileWriter("d://test3.txt"); 
        BufferedWriter bw = new BufferedWriter(writer);
        
        String str = null; 
        while((str = br.readLine()) != null) {
            String[] strs = str.split(",");
			String[] photos = strs[1].split("\\|");
			for (String string : photos) {
				if (string!=null && !"".equals(string)) {
					String tmpstr = "insert into photo_list(thirdid, photo_url) values ('"+strs[0]+"', '"+string+"');";
//	              sb.append(tmpstr+"/n");
	              System.out.println(tmpstr);
	              bw.write(tmpstr);
	              bw.newLine();
				}
			}
        } 
        br.close();
        reader.close();
        
        bw.close();
        writer.close();
  }
        catch(FileNotFoundException e) {
              e.printStackTrace();
        }
        catch(IOException e) {
              e.printStackTrace();
        }
  }
}
