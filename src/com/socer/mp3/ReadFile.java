package com.socer.mp3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import com.socer.utils.ReadSelectedLine;
import com.socer.utils.TimeConverter;

public class ReadFile {
	public int[][] getTime() {
		return time;
	}

	public void setTime(int[][] time) {
		this.time = time;
	}

	public String[] getSents() {
		return sents;
	}

	public void setSents(String[] sents) {
		this.sents = sents;
	}

	public int[] getFlags() {
		return flags;
	}

	public void setFlags(int[] flags) {
		this.flags = flags;
	}

	public int getTotal_sents() {
		return total_sents;
	}

	public void setTotal_sents(int total_sents) {
		this.total_sents = total_sents;
	}

	private int[][] time;
	private String[] sents;
	private int[] flags;
	private int total_sents;
	//read line from file
	
	// construct a matirx: int time[][]
	// construct sting: String sent[]
	
	public int read(String fileName, int type) {
		total_sents=-1;
		if (type == 1) {
			try {
				

				int line_num = ReadSelectedLine.getTotalLines(fileName);
				flags = new int[line_num]; // generate flags list
															// all are zero
				time=new int[line_num][2];
				sents= new String[line_num];
				
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(new FileInputStream(fileName),"GB2312"));
				String line;
				String regex = "\\d\\d:\\d\\d:\\d\\d,\\d\\d\\d --> \\d\\d:\\d\\d:\\d\\d,\\d\\d\\d";
				String regex1 = "\\d{1,5}";
				int line_flag=0;	//locate the distriction the sentence
//				int total_sents=-1;	//define the index
				while ((line = reader.readLine()) != null) {
					
					if(line.length()<10 && line_flag==0){
						continue;
					}
					
					if (Pattern.matches(regex1, line)) { // 使用静态方法进行正则式的匹配。
					// pw.println(line); //如果读到的不是时间描述字符行，则原样写入新文件
						line_flag=0;
						continue; // 提早结束本次循环继续读取下一行
					}else if (Pattern.matches(regex, line)) {
						String start_time = line.substring(0, 12);
						String end_time = line.substring(17, 29);
						int start = TimeConverter.time2ms(start_time);
						int end = TimeConverter.time2ms(end_time);
						line_flag=1;
						total_sents++;
						time[total_sents][0]=start;
						time[total_sents][1]=end;
						sents[total_sents]="";
					}else if(line_flag==1){
						//apnend the string to the sents
						sents[total_sents]+=" "+line;
					}
				}
				// time=new int[line_num][2];
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// deal with the lyc
		if (type == 2) {
			try {

				int line_num = ReadSelectedLine.getTotalLines(fileName);
				flags = new int[line_num]; // generate flags list
															// all are zero
				time=new int[line_num][2];
				sents= new String[line_num];
				
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(new FileInputStream(fileName),"GB2312"));
				String line;
				
				String regex2="\\[\\d\\d:\\d\\d.\\d\\d\\]";
				int line_flag=0;	//locate the distriction the sentence
//				int total_sents=-1;	//define the index
				while ((line = reader.readLine()) != null) {
					if(line.length()<10){
						continue;
					}
					if (Pattern.matches(regex2, line.substring(0, 10))) { // 使用静态方法进行正则式的匹配。
					// pw.println(line); //如果读到的不是时间描述字符行，则原样写入新文件
						String start_time = line.substring(1,9);
						int current = TimeConverter.time2ms(start_time);
						if(line_flag==1){
							total_sents++;
							time[total_sents-1][1]=current;
							time[total_sents][0]=current;	//should give the 
//							line_flag=0;
						}else if(line_flag==0){
							// first one needs to be considered, do not need to handle the former one
							total_sents++;
							time[total_sents][0]=current;
							line_flag=1;
						}
						sents[total_sents]=line.substring(10);
						
//						continue; // 提早结束本次循环继续读取下一行
					}
				}
				//this should handle the problem if the last point no result
				
				//time[total_sents][2]=time[total_sents][1]+1000*
				// time=new int[line_num][2];
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return total_sents;
	}
	


}
