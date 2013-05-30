package com.socer.basic;

import org.junit.Test;

public class StrTest {
	@Test
	public void test1(){
		//check whether a string is in a string
		String a="sbsb.t,xt";
//		System.out.println(a.indexOf("."));
		System.out.println(a.lastIndexOf(","));
		System.out.println(a.substring(a.lastIndexOf(",")+1));
//		System.out.println(a.indexOf("a"));
//		String[] b=a.split("\\.");
//		for(String b1:b){
//			System.out.println(b1);
//		}
	}
}
