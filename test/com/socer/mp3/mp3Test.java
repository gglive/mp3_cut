package com.socer.mp3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

import com.google.code.mp3fenge.Mp3Fenge;
import com.google.code.mp3fenge.util.FileUtil;
import com.socer.utils.ReadSelectedLine;
import com.socer.utils.TimeConverter;

public class mp3Test {
	/**
	 * correct understanding of the path and audio should add 4 libraries including log 
	 */
	@Test
	public void test1(){
		// test path 
		
		File file=new File("res/Die Young.mp3");
		
		Mp3Fenge helper = new Mp3Fenge(file);
		helper.generateNewMp3ByTime(new File("res/Die Young1.mp3"), 1000, 5000);
		// get mp3 data by time interval
		byte[] e2 = helper.getDataByTime(70000, 76000);
		List<byte[]> mp3datas = new ArrayList<byte[]>();
		mp3datas.add(e2);
		FileUtil.generateFile(new File("res/11.mp3"), mp3datas);
	}
	/**
	 * test the file io path
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException{
		File file=new File("res/a1.txt"); 
		BufferedReader reader=null;
		try {
			
			reader = new BufferedReader(new FileReader(file));
			 String tempString = null;
			 int line = 1;
			 //一次读入一行，直到读入null为文件结束
			 while ((tempString = reader.readLine()) != null){
			     //显示行号
			     System.out.println("line " + line + ": " + tempString);
			     line++;
//			reader = new InputStreamReader(new FileInputStream(file));
			 }
			 reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * test time converter
	 */
	@Test
	public void test3(){
//		System.out.println(TimeConverter.time2ms("00:02:52,184"));
		
		System.out.println(TimeConverter.time2ms("00:17.20"));
	}
	/**
	 * test read selected file
	 */
	@Test
	public void test4(){
		try {
			System.out.println(ReadSelectedLine.getTotalLines("res/alli-lesmiserables-xvid.cd1.chs&eng.srt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void test5(){
//		String regex1="\\d{1,5}";;
//		System.out.println(Pattern.matches(regex1,"56777"));
		String regex2="\\[\\d\\d:\\d\\d.\\d\\d\\]";;
		System.out.println(Pattern.matches(regex2,"[03:09.42]"));
		
	}
	@Test
	public void test6(){
//		ReadFile rf=new ReadFile();
//		int a=rf.read("res/alli-lesmiserables-xvid.cd1.chs&eng.srt", 1);
//		System.out.println(a);
		ReadFile rf=new ReadFile();
		int a=rf.read("res/羽泉 - 大中国-6181d366ecdd21c39a901cf14b0ed838.lrc", 2);
		System.out.println(a);
	}
	/**
	 * test the encoding
	 * @throws IOException 
	 */
	@Test
	public void test7() throws IOException{
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream("res/alli-lesmiserables-xvid.cd1.chs&eng.srt"),"GB2312"));
		String line;
		while((line=reader.readLine())!=null){
			System.out.println(line);
		}
	}
	/**
	 * test the mp3 cutter
	 * 
	 */
	@Test
	public void test8(){
		Mp3Cutter mc=new Mp3Cutter();
		String mp3Path="res/羽泉 - 大中国.mp3";
		String textPath="res/羽泉 - 大中国-6181d366ecdd21c39a901cf14b0ed838.lrc";
		mc.cut(mp3Path, textPath);
	}
	@Test
	public void test9(){
		Mp3Cutter mc=new Mp3Cutter();
		String mp3Path="res/target.mp3";
		String textPath="res/alli-lesmiserables-xvid.cd1.chs&eng.srt";
		mc.cut(mp3Path, textPath);
	}
}
