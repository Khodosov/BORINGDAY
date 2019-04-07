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


    public void open() {

    }

    public static void main(String[] args) throws Exception {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\khodo\\project.db");
            System.out.println("connected");
        } catch (Exception e) {
            throw new Exception("something went wrong");
        }

    }

    public void insert() throws Exception {
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

