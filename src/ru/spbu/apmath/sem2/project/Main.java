package ru.spbu.apmath.sem2.project;

public class Main {
    public static void main(String[] args) throws Exception {
        DataBase dataBase = new DataBase();
        dataBase.getConect();
        //dataBase.selectFromFilms();
        //dataBase.insert();

        PrimeGUI app =  new PrimeGUI();
        app.setVisible(true);
    }
}
