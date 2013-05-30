package com.socer.mp3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.google.code.mp3fenge.Mp3Fenge;
import com.google.code.mp3fenge.util.FileUtil;

public class Mp3split {
	//cut mp3 from the original one
	public void test1(){
		Mp3Fenge helper = new Mp3Fenge(new File(""));
		helper.generateNewMp3ByTime(new File("res/Ke$ha - Die Young.mp3"), 307000, 315000);
		// get mp3 data by time interval
		byte[] e2 = helper.getDataByTime(70000, 76000);
		List<byte[]> mp3datas = new ArrayList<byte[]>();
		mp3datas.add(e2);
		FileUtil.generateFile(new File("res/Ke$ha - Die Young.mp3"), mp3datas);

	}
	
	
}
