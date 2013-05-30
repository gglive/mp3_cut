package com.socer.utils;

public class TimeConverter {
	//[00:17.20]
	//00:02:52,184 --> 00:02:53,617
	public static int time2ms(String s){
		// ?shall we make a judge here, or just write 2 funs
		int[] index=new int[2];
		index[0]=s.indexOf(".");
		index[1]=s.indexOf(",");
//		index[2]=s.indexOf(",");
		int digits=0;
		String symbol="";
		if(index[0]>-1){
			//lrc
			digits=2;
			symbol="\\.";
		}else if(index[1]>-1){
			digits=3;
			symbol=",";
		}
		String[] ss=s.split(":", digits);
		String[] sec_str=ss[digits-1].split(symbol,2);
		ss[digits-1]=Integer.parseInt(sec_str[0])*1000+Integer.parseInt(sec_str[1])+"";	// already *1000 here if delete this point
		int[] time_num=new int[digits];
		for(int i=0;i<digits;i++){
			time_num[i]=Integer.parseInt(ss[i]);
		}
		int total_ms=0;
		for(int i=digits-1;i>0;i--){
			total_ms+=time_num[digits-1-i]*1000*60^(i-1);
		}
		total_ms+=time_num[digits-1];
		return total_ms;
		// sth wrong happened, just return -1
//		return -1;
		
	}
}
