package ru.spbu.apmath.sem2.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestGUI extends JFrame{
    private JButton button = new JButton("NEXT");
    //private JTextField input = new JTextField("", 5);
    //private JLabel label = new JLabel("input");
    //private JRadioButton radio1 = new JRadioButton("фильм");
    //private JRadioButton radio2 = new JRadioButton("игра");
    //private JRadioButton radio3 = new JRadioButton("книга");
    //private JCheckBox check = new JCheckBox("check", false);

    public TestGUI(){
        super("BORING DAY");
        this.setBounds(100, 100, 500, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1,4));

        //container.add(label);
        //container.add(input);
        //ButtonGroup group = new ButtonGroup();
        //group.add(radio1);
        //group.add(radio2);
        //group.add(radio3);


        Choice choice1 = new Choice();
        choice1.add("Фильм");
        choice1.add("Книга");
        choice1.add("Игра");
        container.add(choice1);


        //container.add(radio1);
        //radio1.setSelected(true);
        //container.add(radio2);
        //container.add(radio3);
        //container.add(check);

        button.addActionListener(new ButtonEventListener());
        container.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Programming language Selected: " + choice1.getItem(choice1.getSelectedIndex());
                //label.setText(data);
                JOptionPane.showMessageDialog(null, data, "Output", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String message = "";
            //message += "Button was pressed \n";
            //message += "Text is " + input.getText() + "\n";
            //message += (radio1.isSelected() ? "Radio 1" : "Radio 2") + "is selected \n";
            //if (choice1.getSelectedItem() == "фильм"){}
            //if (radio1.isSelected()){ message += "film" + " is selected \n";}
            //else if (radio2.isSelected()){ message += "game" + " is selected \n";}
            //else if (radio3.isSelected()){ message += "book" + " is selected \n";}
            //message += "Checkbox is " + (check.isSelected() ? "checked" : "unchecked" );
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);

        }

    }



}
