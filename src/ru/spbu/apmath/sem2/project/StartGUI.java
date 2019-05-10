package ru.spbu.apmath.sem2.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGUI extends JFrame {
    StartGUI(){
        super("BORING DAY");
        Button button1 = new Button("Далее");
        this.setBounds(100, 100, 700, 180);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 4));

        Choice choice1 = new Choice();
        Label label1 = new Label(" Что вы хотите?");
        choice1.add("");
        choice1.add("Фильм");
        choice1.add("Книга");
        choice1.add("Игра");
        container.add(label1);
        container.add(choice1);

        container.add(button1);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (choice1.getSelectedIndex() == 1){
                    FilmGUI app =  new FilmGUI();
                    app.setVisible(true);
                }
                else if (choice1.getSelectedIndex() == 2){
                    BookGUI app = new BookGUI();
                    app.setVisible(true);
                }
                else if (choice1.getSelectedIndex() == 3){
                    GameGUI app =  new GameGUI();
                    app.setVisible(true);
                }
            }
        });
    }

}

