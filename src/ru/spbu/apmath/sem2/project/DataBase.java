package ru.spbu.apmath.sem2.project;

import java.sql.*;
import java.util.Scanner;

public class DataBase {
    Connection connection;
    String score;
    String name;
    String descr;
    String genre1;
    String genre2;



    public void getConect()throws Exception{
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\khodo\\bd.db");
            System.out.println("connected");
        } catch (Exception e) {
            throw new Exception("something went wrong");
        }

    }
// INSERT =============================================================================================================
    public final void insertIntoFilms() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the NAME");
        try {
            name = scanner.nextLine();
        } catch (Exception e) {
            throw new Exception("некоректные данные");
        }
        System.out.println("Enter the score");
        try {
            score = scanner.nextLine();
        } catch (Exception e) {
            throw new Exception("некоректные данные");
        }
        System.out.println("Enter the genre1");
        try {
            genre1 = scanner.nextLine();
        } catch (Exception e) {
            throw new Exception("некоректные данные");
        }
        System.out.println("Enter the genre2");
        try {
            genre2 = scanner.nextLine();
        } catch (Exception e) {
            throw new Exception("некоректные данные");
        }
        System.out.println("Enter the description");
        try {
            descr = scanner.nextLine();
        } catch (Exception e) {
            throw new Exception("некоректные данные");
        }
        String query = "INSERT INTO films (name, score, genre1, genre2, descr)" +
                "VALUES('"+ name +"','"+ score +"','"+ genre1 +"','"+ genre2 + "','"+ descr +"');";

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("insertion is done");
        statement.close();
    }
//=====================================================================================================================
public final void insertIntoBooks() throws Exception {
    Scanner scanner = new Scanner(System.in);

    System.out.println("enter the NAME");
    try {
        name = scanner.nextLine();
    } catch (Exception e) {
        throw new Exception("некоректные данные");
    }
    System.out.println("Enter the score");
    try {
        score = scanner.nextLine();
    } catch (Exception e) {
        throw new Exception("некоректные данные");
    }
    System.out.println("Enter the genre1");
    try {
        genre1 = scanner.nextLine();
    } catch (Exception e) {
        throw new Exception("некоректные данные");
    }
    System.out.println("Enter the genre2");
    try {
        genre2 = scanner.nextLine();
    } catch (Exception e) {
        throw new Exception("некоректные данные");
    }
    System.out.println("Enter the description");
    try {
        descr = scanner.nextLine();
    } catch (Exception e) {
        throw new Exception("некоректные данные");
    }
    String query = "INSERT INTO books (name, score, genre1, genre2, descr)" +
            "VALUES('"+ name +"','"+ score +"','"+ genre1 +"','"+ genre2 + "','"+ descr +"');";

    Statement statement = connection.createStatement();
    statement.executeUpdate(query);
    System.out.println("insertion is done");
    statement.close();
}
//=====================================================================================================================
public final void insertIntoGames() throws Exception {
    Scanner scanner = new Scanner(System.in);

    System.out.println("enter the NAME");
    try {
        name = scanner.nextLine();
    } catch (Exception e) {
        throw new Exception("некоректные данные");
    }
    System.out.println("Enter the score");
    try {
        score = scanner.nextLine();
    } catch (Exception e) {
        throw new Exception("некоректные данные");
    }
    System.out.println("Enter the genre1");
    try {
        genre1 = scanner.nextLine();
    } catch (Exception e) {
        throw new Exception("некоректные данные");
    }
    System.out.println("Enter the genre2");
    try {
        genre2 = scanner.nextLine();
    } catch (Exception e) {
        throw new Exception("некоректные данные");
    }
    System.out.println("Enter the description");
    try {
        descr = scanner.nextLine();
    } catch (Exception e) {
        throw new Exception("некоректные данные");
    }
    String query = "INSERT INTO games (name, score, genre1, genre2, descr)" +
            "VALUES('"+ name +"','"+ score +"','"+ genre1 +"','"+ genre2 + "','"+ descr +"');";

    Statement statement = connection.createStatement();
    statement.executeUpdate(query);
    System.out.println("insertion is done");
    statement.close();
}
//=====================================================================================================================
// SELECT =============================================================================================================
    public final String selectFromFilms(double score, String genre1, String genre2) throws Exception{
        String result = "";
        String filmsRequest = "SELECT * FROM FILMS WHERE genre1 =" + genre1 + "OR genre2 =" + genre1 + "OR genre2="
                + genre2 + "OR genre1=" + genre2 + "AND score>" + String.valueOf(score);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(filmsRequest);
        while (rs.next()){
            String nameo = rs.getString("name");
            double scoreo = rs.getDouble("score");
            String genre1o = rs.getString("genre1");
            String genre2o = rs.getString("genre2");
            String decsr = rs.getString("descr");
            result = nameo + "\t|" + scoreo + "\t|" + genre1o + "\t|" + genre2o + "\t|" + decsr;
            }
        rs.close();
        statement.close();
        return result;
    }
//=====================================================================================================================
// СДЕЛАТЬ ДЛЯ КНИГ И ИГОООООР

}
