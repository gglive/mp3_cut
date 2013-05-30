package com.socer.basic;

import org.junit.Test;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QLabel;

public class qtTest {
	
	@Test
	public void test1(){
		String[] s = null;
		 QApplication.initialize(s); //这句话不用管,每个主类第一个必须是这个  
		  
	        QLabel 标签 = new QLabel("Qt Jambi 我来了!");  //新建一个标签  
	        标签.show(); //显示标签  
	  
	          
	        QApplication.exec();  //这句话是最后一句,也不用管,也是每个主类必须有  
	}
	
}
