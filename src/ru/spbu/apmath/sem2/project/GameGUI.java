package ru.spbu.apmath.sem2.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame {
    GameGUI() {
        super("BORING DAY");
        Button button1 = new Button("Далее");
        Button button2 = new Button("Назад");
        this.setBounds(100, 100, 700, 180);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 4));
// genres =============================================================================================================
        Choice choice2 = new Choice();
        Label label2 = new Label(" Выбирайте жанры!");
        //choice2.add("");
        choice2.add("экшн");
        choice2.add("приключение");
        choice2.add("РПГ");
        choice2.add("шутер от третьего лица");
        choice2.add("шутер от первого лица");
        choice2.add("батл рояль");
        choice2.add("стелс");
        choice2.add("гонки");
        choice2.add("спорт");
        choice2.add("здесь могла бы быть ваша реклама");
        choice2.add("Н");
        choice2.add("А");
        choice2.add("В");
        choice2.add("А");
        choice2.add("Л");
        choice2.add("Ь");
        choice2.add("Н");
        choice2.add("Ы");
        choice2.add("Й");
        choice2.add("2");
        choice2.add("0");
        choice2.add("1");
        choice2.add("9");
        choice2.add("!");

        Choice choice3 = new Choice();
        //choice3.add("");
        choice3.add("экшн");
        choice3.add("приключение");
        choice3.add("РПГ");
        choice3.add("шутер от третьего лица");
        choice3.add("шутер от первого лица");
        choice3.add("батл рояль");
        choice3.add("стелс");
        choice3.add("гонки");
        choice3.add("спорт");
        choice3.add("здесь могла бы быть ваша реклама");
        choice3.add("М");
        choice3.add("А");
        choice3.add("Т");
        choice3.add("L");
        choice3.add("A");
        choice3.add("B");
        choice3.add("=");
        choice3.add("Л");
        choice3.add("Ю");
        choice3.add("Б");
        choice3.add("О");
        choice3.add("В");
        choice3.add("Ь");
        choice3.add("!");
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

        container.add(button2);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StartGUI app =  new StartGUI();
                app.setVisible(true);
            }
        });


        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DataBase dataBase = new DataBase();
                try {
                    dataBase.getConect();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
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
                StringBuffer result = new StringBuffer();
                try {
                    result.append(dataBase.selectFromGames(genre1, genre2));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                for (int i=0; i <= result.length(); i+=90){
                    result.insert(i, "\n");
                }
                String finresult = new String(result);
                finresult.replace('|', '\n');
                JOptionPane.showMessageDialog(null, finresult, "Ваш результат:", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }
}
