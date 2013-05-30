/********************************************************************************
 ** Form generated from reading ui file 'mainWindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.7.1
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.socer.ui;
import java.io.File;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction action;
    public QWidget centralwidget;
    public QVBoxLayout verticalLayout;
    public QGridLayout gridLayout;
    public QLabel lable_textPath;
    public QLineEdit textPath;
    public QLabel lable_mp3Path;
    public QLineEdit mp3Path;
    public QGridLayout gridLayout_2;
    public QPushButton btn_confirm;
    public QPushButton btn_quit;
    public QPushButton btn_submit;
    public QMenuBar menubar;
    public QMenu menu;
    public QStatusBar statusbar;
    
    public static String text_path;
    public static String mp3_path;

    public Ui_MainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(508, 240).expandedTo(MainWindow.minimumSizeHint()));
        action = new QAction(MainWindow);
        action.setObjectName("action");
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        verticalLayout = new QVBoxLayout(centralwidget);
        verticalLayout.setObjectName("verticalLayout");
        gridLayout = new QGridLayout();
        gridLayout.setObjectName("gridLayout");
        lable_textPath = new QLabel(centralwidget);
        lable_textPath.setObjectName("lable_textPath");

        gridLayout.addWidget(lable_textPath, 0, 0, 1, 1);

        textPath = new QLineEdit(centralwidget);
        textPath.setObjectName("textPath");
        textPath.setText("res/target.srt");
        gridLayout.addWidget(textPath, 0, 1, 1, 1);

        lable_mp3Path = new QLabel(centralwidget);
        lable_mp3Path.setObjectName("lable_mp3Path");

        gridLayout.addWidget(lable_mp3Path, 1, 0, 1, 1);

        mp3Path = new QLineEdit(centralwidget);
        mp3Path.setObjectName("mp3Path");
        mp3Path.setText("res/target.mp3");
        gridLayout.addWidget(mp3Path, 1, 1, 1, 1);


        verticalLayout.addLayout(gridLayout);

        gridLayout_2 = new QGridLayout();
        gridLayout_2.setObjectName("gridLayout_2");
        btn_confirm = new QPushButton(centralwidget);
        btn_confirm.setObjectName("btn_confirm");

        gridLayout_2.addWidget(btn_confirm, 0, 0, 1, 1);

        btn_quit = new QPushButton(centralwidget);
        btn_quit.setObjectName("btn_quit");

        gridLayout_2.addWidget(btn_quit, 0, 1, 1, 1);
        
        btn_submit= new QPushButton(centralwidget);
        btn_submit.setVisible(false);

        verticalLayout.addLayout(gridLayout_2);

        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 508, 23));
        menu = new QMenu(menubar);
        menu.setObjectName("menu");
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);
        lable_textPath.setBuddy(textPath);
        lable_mp3Path.setBuddy(mp3Path);

        menubar.addAction(menu.menuAction());
        menu.addAction(action);
        retranslateUi(MainWindow);
//        btn_confirm.clicked.connect(textPath, "cut()");
//        btn_confirm.clicked.connect(mp3Path, "cut()");
        btn_confirm.clicked.connect(this, "checkValue()");
        btn_quit.clicked.connect(MainWindow, "close()");

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
        action.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u6253\u5f00\u6587\u4ef6", null));
        lable_textPath.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u6587\u672c\u8def\u5f84\uff1a", null));
        lable_mp3Path.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MP3\u8def\u5f84\uff1a", null));
        btn_confirm.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u786e\u5b9a", null));
        btn_quit.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u9000\u51fa", null));
        menu.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u6587\u4ef6", null));
    } // retranslateUi
    
    void checkValue(){
//    	System.out.println("OK");
    	int flag=1;
    	if(textPath.text().isEmpty()){
    		textPath.setText("文件路径不正确");
    		flag=0;
    	}
    	if(mp3Path.text().isEmpty()){
    		mp3Path.setText("文件路径不正确");
    		flag=0;
    	}
    	File file1=new File(textPath.text());
    	File file2=new File(mp3Path.text());
    	
    	if(!file1.exists()){
    		textPath.setText("文件不存在或已销毁");
    		flag=0;
    	}
    	if(!file2.exists()){
    		mp3Path.setText("文件不存在或已销毁");
    		flag=0;
    	}
    	if(flag==1){
//    		QDialog dialog= new QDialog();
//    		 Ui_showWindow ui_show=new Ui_showWindow();
//    		 ui_show.setupUi(dialog);
//    		 dialog.show();
//    		System.out.println(mp3Path.text());
    		mp3_path=mp3Path.text();
    		text_path=textPath.text();
    		btn_submit.clicked.emit(true);
    	
//    		 this.action.setDisabled(true);
    		 
    	}
    }

}

