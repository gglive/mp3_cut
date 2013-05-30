/********************************************************************************
 ** Form generated from reading ui file 'output.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.7.1
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.socer.ui;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.jlp;

import com.socer.mp3.Mp3Cutter;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_showWindow implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout;
    public QLabel texts;
//    public QLabel mp3Path;
//    public QLabel textPath;
    public QRadioButton rBtn_out;
    public QRadioButton rBtn_in;
    public QTextEdit content;
    public QPushButton btn_pre;
    public QPushButton btn_current;
    public QPushButton btn_next;
    public QSlider horizontalSlider;
    public QRadioButton rBtn_g;
    public QRadioButton rBtn_b;
    
    public String[] sents;
    public int total_sents;
    public String dir_path;
   
    public int step_num=1;
    public int pre_num;
    public int current_num;

    public Ui_showWindow() { super(); }

    public void setupUi(QDialog showWindow)
    {
        showWindow.setObjectName("showWindow");
        showWindow.resize(new QSize(456, 339).expandedTo(showWindow.minimumSizeHint()));
        gridLayout = new QGridLayout(showWindow);
        gridLayout.setObjectName("gridLayout");
        texts = new QLabel(showWindow);
        texts.setObjectName("texts");

        gridLayout.addWidget(texts, 0, 0, 1, 1);
        
//        mp3Path = new QLabel(showWindow);
//        mp3Path.setVisible(false);
//        textPath = new QLabel(showWindow);
//        textPath.setVisible(false);
        
        

        rBtn_out = new QRadioButton(showWindow);
        rBtn_out.setObjectName("rBtn_out");

        gridLayout.addWidget(rBtn_out, 0, 1, 1, 1);

        rBtn_in = new QRadioButton(showWindow);
        rBtn_in.setObjectName("rBtn_in");

        gridLayout.addWidget(rBtn_in, 0, 2, 1, 1);

        content = new QTextEdit(showWindow);
        content.setObjectName("content");

        gridLayout.addWidget(content, 1, 0, 1, 3);

        btn_pre = new QPushButton(showWindow);
        btn_pre.setObjectName("btn_pre");
        btn_pre.setDisabled(true);

        gridLayout.addWidget(btn_pre, 5, 0, 1, 1);

        
        btn_current = new QPushButton(showWindow);
        btn_current.setObjectName("btn_current");
        
        btn_current.clicked.connect(this, "currentSent()");
        
        gridLayout.addWidget(btn_current, 5, 1, 1, 1);
        
        btn_next = new QPushButton(showWindow);
        btn_next.setObjectName("btn_next");
        
        btn_next.clicked.connect(this, "nextSent()");
        
        gridLayout.addWidget(btn_next, 5, 2, 1, 1);

        horizontalSlider = new QSlider(showWindow);
        horizontalSlider.setObjectName("horizontalSlider");
        horizontalSlider.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);

        gridLayout.addWidget(horizontalSlider, 3, 0, 1, 3);
        rBtn_g = new QRadioButton(showWindow);
       rBtn_g.setObjectName("rBtn_g");

        gridLayout.addWidget(rBtn_g, 4, 0, 1, 1);

        rBtn_b = new QRadioButton(showWindow);
        rBtn_b.setObjectName("rBtn_b");

        gridLayout.addWidget(rBtn_b, 4, 1, 1, 1);

        texts.setBuddy(content);
        retranslateUi(showWindow);

        showWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog showWindow)
   {
        showWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("showWindow", "Sentences", null));
        texts.setText(com.trolltech.qt.core.QCoreApplication.translate("showWindow", "\u6587\u672c\uff1a", null));
       rBtn_out.setText(com.trolltech.qt.core.QCoreApplication.translate("showWindow", "\u663e\u793a\u6b4c\u8bcd", null));
        rBtn_in.setText(com.trolltech.qt.core.QCoreApplication.translate("showWindow", "\u9690\u85cf\u6587\u672c", null));
        btn_pre.setText(com.trolltech.qt.core.QCoreApplication.translate("showWindow", "\u4e0a\u4e00\u53e5", null));
        btn_current.setText(com.trolltech.qt.core.QCoreApplication.translate("showWindow", "\u672C\u53e5", null));
        btn_next.setText(com.trolltech.qt.core.QCoreApplication.translate("showWindow", "\u4e0b\u4e00\u53e5", null));
        rBtn_g.setText(com.trolltech.qt.core.QCoreApplication.translate("showWindow", "\u6709\u7528", null));
        rBtn_b.setText(com.trolltech.qt.core.QCoreApplication.translate("showWindow", "\u65e0\u7528", null));
    } // retranslateUi
    
    void checkFile(){
    	Mp3Cutter mc=new Mp3Cutter();
    	// for president debate, adj
//    	mc.adj_ms_begin=70;
//    	mc.adj_ms_end=120;
    	System.out.println("this place "+Ui_MainWindow.mp3_path);
//    	System.out.println(textPath.text());
    	String mp3Path=Ui_MainWindow.mp3_path;
    	
    	if(mc.cut(Ui_MainWindow.mp3_path,Ui_MainWindow.text_path)){
    		int num= (int) Math.floor((mc.total_sents*Math.random()));
    		pre_num=num;
    		current_num=num;
    		total_sents=mc.total_sents;
    		sents=mc.sents;
    		// get the sents
    		
    		// get the mp3
    		dir_path=mp3Path.substring(0,mp3Path.lastIndexOf(".")); 
    		
    		updateShow(num,step_num);
    		// 
    	}
    	
    }
    
    void nextSent(){
   	int num= (int) Math.floor((total_sents*Math.random()));
    	if(current_num==pre_num){
    		current_num=num;
    	}else{
    		pre_num=current_num;
   		current_num=num;
    	}
    	updateShow(num,step_num);
    	btn_pre.setEnabled(true);
    }
    void prevSent(){
    	updateShow(pre_num,step_num);
    }
    void currentSent(){
    	updateShow(current_num,step_num);
    }
    void updateShow(int num,int step){
    	String s="";
    	int flag=0;
    	if(num<total_sents-1-step){
    		flag=1;
    	}else{
    		flag=-1;
    	}
    	for(int i=0;i<step;i++){
			s+=sents[num+i*flag];
			try {
//				Player player = new Player(new FileInputStream(dir_path+"/"+(num+i*flag)+".mp3"));
				jlp player=new jlp(dir_path+"/"+(num+i*flag)+".mp3");
				player.play();
//			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
    	content.setText(s);
    	content.update();
    	
    }

}

