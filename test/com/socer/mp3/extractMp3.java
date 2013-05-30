package com.socer.mp3;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.VideoAttributes;

import java.io.File;

import org.junit.Test;

public class extractMp3 {
	@Test
	public void test1() throws IllegalArgumentException, InputFormatException, EncoderException{
//		String filename="C:/Users/Sizuo/Videos/Full 2012 First U.S. Presidential Debate.mp4";
		File source = new File("F:/video/Les.Miserables.2012.DVDRip.XviD-ALLiANCE/alli-lesmiserables-xvid.cd1.avi");
//		File source = new File(filename);
		File target = new File("res/target.mp3");
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(128000));
		audio.setChannels(new Integer(2));
		audio.setSamplingRate(new Integer(44100));
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);
		Encoder encoder = new Encoder();
		encoder.encode(source, target, attrs);
	}
	@Test
	public void test() throws IllegalArgumentException, InputFormatException, EncoderException{
		File source = new File("F:/video/Les.Miserables.2012.DVDRip.XviD-ALLiANCE/alli-lesmiserables-xvid.cd1.avi");
		File target = new File("res/target1.mp3");
		
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(56000));
		audio.setChannels(new Integer(1));
		audio.setSamplingRate(new Integer(22050));
		VideoAttributes video = new VideoAttributes();
		video.setCodec(VideoAttributes.DIRECT_STREAM_COPY);
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("avi");
		attrs.setAudioAttributes(audio);
		attrs.setVideoAttributes(video);
		Encoder encoder = new Encoder();
		encoder.encode(source, target, attrs);
	}

}
