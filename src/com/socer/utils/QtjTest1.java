package com.socer.utils;

import com.socer.ui.Ui_MainWindow;
import com.socer.ui.Ui_showWindow;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QWidget;

public class QtjTest1 extends QWidget
{


    public static void main(String args[])
    {
        QApplication.initialize(args);
        QWidget widget = new QWidget();
        QDialog dialog= new QDialog();
        
//        Ui_showWindow ui=new Ui_showWindow();
        QMainWindow mainWindow=new QMainWindow();
        Ui_MainWindow ui=new Ui_MainWindow();
        ui.setupUi(mainWindow);
//        a.setupUi(new QDialog());
//       s a.
//        a.
//        dialog.show();
        mainWindow.show();
        
        QApplication.exec();
    }
}

