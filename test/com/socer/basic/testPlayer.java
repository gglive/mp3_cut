package com.socer.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.JavaSoundAudioDevice;
import javazoom.jl.player.Player;
import javazoom.jl.player.jlp;
import javazoom.jl.player.advanced.PlaybackListener;
import javazoom.jl.player.advanced.jlap;

import org.junit.Test;

import com.socer.utils.Mp3Player;

public class testPlayer {
	@Test
	public void test1() throws InterruptedException{
		String[] args=new String[1];
		args[0]="res/Die Young.mp3";
//		jlp player=jlp.createInstance(args);
	

		//			Player player1=new Player(new FileInputStream(args[0]));
		Mp3Player mp3Player=new Mp3Player(args[0]);
					//mp3Player.player=player1;
		Thread t1=new Thread(mp3Player);
		//			player1.play();
		//			Thread thread=new Thread();
		//			thread.
		//			player1.play();
		//			player1.wait();
					
		t1.start();
		//			System.out.println("OK");
		//			while(!player1.isComplete()){
		//				System.out.println(player1.getPosition());
		//				player1.play();
		//			}
		
//		try {
//			player.play();
//		} catch (JavaLayerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	@Test
	public void test2() throws IOException, UnsupportedAudioFileException, JavaLayerException{
		JavaSoundAudioDevice p1=new JavaSoundAudioDevice();
		//p1.
		FileInputStream mp3in=new FileInputStream("res/Die Young.mp3");
		Bitstream in = new Bitstream(mp3in);
		Header header=in.readFrame();
		System.out.println(header.total_ms(mp3in.available()));
		System.out.println("framesize="+header.calculate_framesize());
		System.out.println("max_number_of_frames="+header.max_number_of_frames(mp3in.available()));

		String[] args=new String[1];
		args[0]="res/Die Young.mp3";
		File file = new File(args[0]);
		//URL file = new URL(props.getProperty("shoutcast"));
		AudioFileFormat aff = AudioSystem.getAudioFileFormat(file);
		
//		if (out != null) out.println("Audio Type : "+aff.getType());
		AudioInputStream ain= AudioSystem.getAudioInputStream(file);
		AudioInputStream din = null;
		AudioFormat baseFormat=ain.getFormat();
		AudioFormat  decodedFormat = new AudioFormat(
				  AudioFormat.Encoding.PCM_SIGNED,
				  baseFormat.getSampleRate(),
				  16,
				  baseFormat.getChannels(),
				  baseFormat.getChannels() * 2,
				  baseFormat.getSampleRate(),
				  false);
		din=AudioSystem.getAudioInputStream(decodedFormat,ain);
		AudioFormat af=din.getFormat();
		
		
		p1.open(af);
	
		System.out.println("ok");
		System.out.println(p1.getPosition());
//		p1.
	}
	@Test
	public void test3() throws IOException, JavaLayerException{
		jlap jpa=new jlap();
		PlaybackListener  pbl=null;
		jpa.playMp3(new File("res/Die Young.mp3"), 10, 3000, pbl);
	}
}
