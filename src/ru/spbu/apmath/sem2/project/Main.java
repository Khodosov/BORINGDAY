package ru.spbu.apmath.sem2.project;

public class Main {
    public static void main(String[] args) throws Exception {

        DataBase dataBase = new DataBase();
        dataBase.getConect();
        //dataBase.insertIntoFilms();
        //dataBase.insertIntoGames();
        StartGUI app =  new StartGUI();
        app.setVisible(true);
    }
}
