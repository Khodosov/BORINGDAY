package ru.spbu.apmath.sem2.project;

public class Main {
    public static void main(String[] args) throws Exception {

        TestDataBase dataBase = new TestDataBase();
        dataBase.getConect();
        dataBase.selectFromFilms();

        //PrimeGUI app =  new PrimeGUI();
        //app.setVisible(true);
    }
}
