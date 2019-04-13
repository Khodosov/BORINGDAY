package ru.spbu.apmath.sem2.project;

import java.sql.*;
import java.util.Scanner;

public class DataBase {
    Connection connection;
    int id;
    float score;
    String name;
    String description;
    String genre;
    String query = "INSERT INTO films (id, name, score, genre, description) " +
            "VALUES('"+ id +"','"+ name +"','"+ score +"'"+ genre +"', '"+ description +"');";
    String filmsRequest = "SELECT * FROM films;";
    String booksRequest = "SELECT * FROM books;";
    String gamesRequest = "SELECT * FROM games;";

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
        for (int i = 0; i < 5; i++) {
            System.out.println("enter the ID");
            try {
                id = scanner.nextInt();
            } catch (Exception e) {
                throw new Exception("некоректные данные");
            }
            System.out.println("enter the NAME");
            try {
                name = scanner.next();
            } catch (Exception e) {
                throw new Exception("некоректные данные");
            }
            System.out.println("enter the SCORE");
            try {
                score = scanner.nextFloat();

            } catch (Exception e) {
                throw new Exception("некоректные данные");
            }
            System.out.println("enter the GENRE");
            try {
                genre = scanner.next();
            } catch (Exception e) {
                throw new Exception("некоректные данные");
            }
            System.out.println("enter the DESCRIPTION");
            try {
                description = scanner.next();
            } catch (Exception e) {
                throw new Exception("некоректные данные");
            }
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("insertion is done");
            statement.close();
        }

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

