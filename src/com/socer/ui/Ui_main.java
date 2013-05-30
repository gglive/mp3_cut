package com.socer.ui;

import java.io.File;

import com.trolltech.qt.core.QObject;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QWidget;

public class Ui_main {
//	String mp3Path;
//	String textPath;
	
    public static void main(String args[])
    {
        
    	QApplication.initialize(args);
        QWidget widget = new QWidget();
        QDialog dialog= new QDialog();
        
        Ui_showWindow ui_show=new Ui_showWindow();
        QMainWindow mainWindow=new QMainWindow();
        Ui_MainWindow ui=new Ui_MainWindow();
        ui.setupUi(mainWindow);
        ui_show.setupUi(dialog);
//        a.setupUi(new QDialog());
//       s a.
//        a.
//        dialog.show();
        mainWindow.show();
        
        ui.btn_submit.clicked.connect(dialog,"show()");
        
        ui.btn_submit.clicked.connect(ui_show,"checkFile()");
//        System.out.println("sb"+dialog.isVisible());
//        mainWindow.close();
//        dialog.show();
//        res/alli-lesmiserables-xvid.cd1.chs&eng.srt
//        res/target.mp3
        
        
//        ui.btn_confirm.clicked.c
        QApplication.exec();
    }
  

}
