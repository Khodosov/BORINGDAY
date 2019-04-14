package ru.spbu.apmath.sem2.project;

import javax.swing.JFrame;

public class MyWindowApp extends JFrame { //Наследуя от JFrame мы получаем всю функциональность окна

    public MyWindowApp(){
        super("BoringDay");
        setBounds(100, 100, 1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при
    }

    public static void main(String[] args) {
        MyWindowApp app = new MyWindowApp();
        app.setVisible(true);
    }
}