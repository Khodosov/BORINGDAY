package ru.spbu.apmath.sem2.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookGUI extends JFrame {
    BookGUI() {
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
        choice2.add("повесть");
        choice2.add("роман");
        choice2.add("поезия");
        choice2.add("стихотворение");
        choice2.add("поэма");
        choice2.add("публицистика");
        choice2.add("научная публикация");

        Choice choice3 = new Choice();
        //choice3.add("");
        choice3.add("история");
        choice3.add("драматургия");
        choice3.add("хоррор");
        choice3.add("биография");
        choice3.add("фантастика");
        choice3.add("приключения");
        choice3.add("антиутопия");
        choice3.add("фентези");

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
                    result.append(dataBase.selectFromBooks(genre1, genre2));
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
