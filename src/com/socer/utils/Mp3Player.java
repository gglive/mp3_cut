package com.socer.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


/**
 * fuck, threads will stop suddenly!!! it did not finish but quit the thread,
 * @author Sizuo
 *
 */

public class Mp3Player implements Runnable {
	
//	public Player player;
	public String filenPath;
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("sbsb");
			Player player=new Player(new FileInputStream(filenPath));
			player.play();
			System.out.println("sbsbaa");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public Mp3Player(String filenPath) {
		super();
		this.filenPath = filenPath;
	}

}
