package ru.spbu.apmath.sem2.project;

public class MainP {
    public static void main(String[] args) throws Exception {
        DataBase dataBase = new DataBase();
        dataBase.getConect();
        //dataBase.insertIntoFilms();
        //dataBase.insertIntoGames();
        //dataBase.insertIntoBooks();
        StartGUI app =  new StartGUI();
        app.setVisible(true);


    }
}
