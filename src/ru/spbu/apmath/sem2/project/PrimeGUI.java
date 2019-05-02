package ru.spbu.apmath.sem2.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrimeGUI extends JFrame {
    PrimeGUI() {
        super("BORING DAY");
        Button button1 = new Button("Show");
        this.setBounds(100, 100, 500, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 4));
// types of activities ================================================================================================
        Choice choice1 = new Choice();
        choice1.add("Фильм");
        choice1.add("Книга");
        choice1.add("Игра");
        container.add(choice1);
//=====================================================================================================================
// genres =============================================================================================================
        Choice choice2 = new Choice();
        choice2.add("драма");
        choice2.add("криминал");
        choice2.add("");
        choice2.add("");
        choice2.add("");
        choice2.add("");
        choice2.add("");
        choice2.add("");
        container.add(choice2);
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

