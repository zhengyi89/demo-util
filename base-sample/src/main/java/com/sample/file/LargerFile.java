package com.sample.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargerFile {
	public void largeFileIO(String inputFile, String outputFile) {
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(inputFile)));
			BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"), 10 * 1024 * 1024);// 10M缓存
			FileWriter fw = new FileWriter(outputFile);
			while (in.ready()) {
				String line = in.readLine();
				System.out.println("read line :"+line);
				fw.append(line + " ");
			}
			in.close();
			fw.flush();
			fw.close();
			System.out.println("copy over---");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		String inputFile = "/Users/zhengy/Downloads/【6v电影www.dy131.com】雏菊BD中字1280高清.rmvb";
		String outputFile = "/Users/zhengy/Documents/aa.rmvb";
		new LargerFile().largeFileIO(inputFile, outputFile);
	}
}