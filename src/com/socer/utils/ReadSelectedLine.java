package com.socer.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class ReadSelectedLine {
	
	public static void readLineVarFile(String fileName, int lineNumber) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName)));
		String line = reader.readLine();
		if (lineNumber < 0 || lineNumber > getTotalLines(fileName)) {
			System.out.println("不在文件的行数范围之内。");
		}
		int num = 0;
		while (line != null) {
			if (lineNumber == ++num) {
				System.out.println("line   " + lineNumber + ":   " + line);
			}
			line = reader.readLine();
		}
		reader.close();
	}
	

	// 文件内容的总行数。 
	public static int getTotalLines(String fileName) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName)));
		LineNumberReader reader = new LineNumberReader(in);
		String s = reader.readLine();
		int lines = 0;
		while (s != null) {
			lines++;
			s = reader.readLine();
		}
		reader.close();
		in.close();
		return lines;
	}
	
	public static void main(String[] args) throws IOException {
		
        // 读取文件 
		String fileName = "res/a1.txt";
		
        // 获取文件的内容的总行数 
		int totalNo = getTotalLines(fileName);
		System.out.println("There are "+totalNo+ " lines in the text!");
		
		// 指定读取的行号 
		int lineNumber = 2;
		
		//读取指定行的内容
		readLineVarFile("res/a1.txt", lineNumber);	
	}
}
