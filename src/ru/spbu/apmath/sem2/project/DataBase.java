package ru.spbu.apmath.sem2.project;

import java.sql.*;
import java.util.Scanner;

public class DataBase {
    Connection connection;
    String score;
    String name;
    String decr;
    String genre1;
    String genre2;
    String query = "INSERT INTO films (name, score, genre1, genre2, decr)" +
            "VALUES('"+ name +"','"+ score +"'"+ genre1 +"', '"+ genre2 + "'"+ decr +"');";
    String filmsRequest = "select * from films;";
    String booksRequest = "SELECT * FROM books";
    String gamesRequest = "SELECT * FROM games";

    public void open() {

    }


    public void getConect()throws Exception{
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\khodo\\proj.db");
            System.out.println("connected");
        } catch (Exception e) {
            throw new Exception("something went wrong");
        }

    }
// Метод выдаёт ошибку, но он так-то и не нужен)))
    public final void insert() throws Exception {
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
            decr = scanner.nextLine();
        } catch (Exception e) {
            throw new Exception("некоректные данные");
        }
        String query = "INSERT INTO films (name, score, genre1, genre2, descr)" +
                    "VALUES('"+ name +"','"+ score +"'"+ genre1 +"', '"+ genre2 + "'"+ decr +"');";

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("insertion is done");
        statement.close();
        }


    // какая-то лажа(((


    public final void selectFromFilms() throws Exception{
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(filmsRequest);
            while (rs.next()){
                String name = rs.getString("name");
                double score = rs.getDouble("score");
                String genre1 = rs.getString("genre1");
                String genre2 = rs.getString("genre2");
                String decr = rs.getString("decr");
                System.out.println(name + "\t|" + score + "\t|" + genre1 + "\t|" + genre2 + "\t|" + decr);
                rs.close();
                statement.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
        public void close () {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

