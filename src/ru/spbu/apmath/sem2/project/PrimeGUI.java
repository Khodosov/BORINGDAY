package ru.spbu.apmath.sem2.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrimeGUI extends JFrame {
    PrimeGUI() {
        super("BORING DAY");
        Button button1 = new Button("Результат");
        this.setBounds(100, 100, 1260, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 4));


// types of activities ================================================================================================
        Choice choice1 = new Choice();
        Label label1 = new Label(" Что вы хотите?");
        choice1.add("");
        choice1.add("Фильм");
        choice1.add("Книга");
        choice1.add("Игра");
        container.add(label1);
        container.add(choice1);

//=====================================================================================================================
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
        container.add(label2);
        container.add(choice2);
//=====================================================================================================================
// genres 2============================================================================================================
        Choice choice3 = new Choice();
        choice3.add("");
        container.add(choice3);
//=====================================================================================================================
// score =============================================================================================================
        Choice choice4 = new Choice();
        Label label3 = new Label(" Какая оценка должнабыть?");
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
                String data = "" + choice1.getItem(choice1.getSelectedIndex()) + "\n" +
                        choice2.getItem(choice2.getSelectedIndex());
                //label.setText(data);
                JOptionPane.showMessageDialog(null, data, "Output", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }
}

