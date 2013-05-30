package com.socer.mp3;

import java.io.File;

import com.google.code.mp3fenge.Mp3Fenge;

public class Mp3Cutter {
	public int total_sents;
	public String[] sents;
	
	public int adj_ms_begin=0;
	public int adj_ms_end=0;
//	public Stri
	//using path to generate the 
	public boolean cut(String mp3Path,String textPath){
		String type_name=textPath.trim().substring(textPath.lastIndexOf(".")+1).toLowerCase();
		int type;
		if(type_name.equals("srt")){
			type=1;
		}else if(type_name.equals("lrc")){
			type=2;
		}else{
			System.out.println("Mp3Cutter::no type fitted");
			type=1;
		}
		ReadFile rf=new ReadFile();
		int sum_sents=rf.read(textPath, type);
		total_sents=sum_sents;
		sents=rf.getSents();
		//begin mp3 part

		File file = new File(mp3Path);
		String absPath=file.getAbsolutePath();
		absPath=absPath.substring(0, absPath.lastIndexOf("."));
		if (sum_sents > 0) {
			File tempFile=new File(absPath);
			// if exist file  and no adjustment
			if(tempFile.exists() && tempFile.isDirectory() && tempFile.length()>0 && adj_ms_begin==0 && adj_ms_end==0){
				return true;
			}
			boolean success=tempFile.mkdirs();
			if(!success){
				if(!tempFile.exists()){
					return false;
				}else{
					//exist
				}
				
			}
		}
		Mp3Fenge mp3 = new Mp3Fenge(file);
		int[][] time=rf.getTime();
		String[] sents=rf.getSents();
		for(int i=0;i<sum_sents;i++){
			// just ingore the last element " sum_sents " for in lrc, it is hard to determine the last time
			if(time[i][1]!=0 && time[i][1]>time[i][0]){
				mp3.generateNewMp3ByTime(new File(absPath+"/"+i+".mp3"), time[i][0]+adj_ms_begin, time[i][1]+adj_ms_end);
		}else{
				System.out.println("Mp3Cutter:Sth Wrong with the time seq"+" start time : "+ time[i][0]);
			}
			
		}
		return true;
	
}
}
