package ru.spbu.apmath.sem2.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilmGUI extends JFrame {
    FilmGUI() {
        super("BORING DAY");
        Button button1 = new Button("Далее");
        this.setBounds(100, 100, 700, 180);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 4));
// genres =============================================================================================================
        Choice choice2 = new Choice();
        Label label2 = new Label(" Выбирайте жанры!");
        choice2.add("");
        choice2.add("история");
        choice2.add("драма");
        choice2.add("хоррор");
        choice2.add("боевик");
        choice2.add("мелодрама");
        choice2.add("биография");
        choice2.add("комедия");
        choice2.add("триллер");
        choice2.add("фантастика");
        choice2.add("мультфильм");
        choice2.add("приключения");
        choice2.add("документалистика");

        Choice choice3 = new Choice();
        choice3.add("");
        choice3.add("история");
        choice3.add("драма");
        choice3.add("хоррор");
        choice3.add("боевик");
        choice3.add("мелодрама");
        choice3.add("биография");
        choice3.add("комедия");
        choice3.add("триллер");
        choice3.add("фантастика");
        choice3.add("мультфильм");
        choice3.add("приключения");
        choice3.add("документалистика");

        container.add(label2);
        container.add(choice2);
        container.add(choice3);
//=====================================================================================================================
// score =============================================================================================================
        Choice choice4 = new Choice();
        Label label3 = new Label(" Оценка");
        choice4.add("");
        choice4.add("я бы ТОЧНО не стал ...");
        choice4.add("я бы не стал ...");
        choice4.add("40+");
        choice4.add("50+");
        choice4.add("60+");
        choice4.add("70+");
        choice4.add("80+");
        choice4.add("90+");
        container.add(label3);
        container.add(choice4);
//=====================================================================================================================
        container.add(button1);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DataBase dataBase = new DataBase();

                double score;
                if (choice4.getItem(choice4.getSelectedIndex()) == "я бы ТОЧНО не стал ..."){ score = 9;}
                else if (choice4.getItem(choice4.getSelectedIndex()) == "я бы не стал ..."){ score = 19;}
                else if (choice4.getItem(choice4.getSelectedIndex()) == "40+"){ score = 39;}
                else if (choice4.getItem(choice4.getSelectedIndex()) == "50+"){ score = 49;}
                else if (choice4.getItem(choice4.getSelectedIndex()) == "60+"){ score = 59;}
                else if (choice4.getItem(choice4.getSelectedIndex()) == "70+"){ score = 69;}
                else if (choice4.getItem(choice4.getSelectedIndex()) == "80+"){ score = 79;}
                else if (choice4.getItem(choice4.getSelectedIndex()) == "90+"){ score = 89;}
                else {score = 0;}

                String genre1 = choice2.getItem(choice2.getSelectedIndex());
                String genre2 = choice3.getItem(choice3.getSelectedIndex());

                String result = "";
                try {
                    result = dataBase.selectFromFilms(score, genre1, genre2);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, result, "ВАШ, ВЫБРАННЫЙ МАГИЧЕСКИМ ОБРАЗОМ " +
                        "РЕЗУЛЬТАТ..." + result , JOptionPane.PLAIN_MESSAGE);
            }
        });


    }
}
