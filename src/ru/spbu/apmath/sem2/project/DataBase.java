package ru.spbu.apmath.sem2.project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DataBase {
    Connection connection;
    String score;
    String name;
    String descr;
    String genre1;
    String genre2;


    public void getConect() throws Exception {
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
                "VALUES('" + name + "','" + score + "','" + genre1 + "','" + genre2 + "','" + descr + "');";

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
                "VALUES('" + name + "','" + score + "','" + genre1 + "','" + genre2 + "','" + descr + "');";

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
                "VALUES('" + name + "','" + score + "','" + genre1 + "','" + genre2 + "','" + descr + "');";

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("insertion is done");
        statement.close();
    }

//=====================================================================================================================
// SELECT =============================================================================================================
    public final String selectFromFilms(String genre1, String genre2) throws Exception {
        String result = "";
        String filmsRequest_n = "SELECT id FROM films WHERE (genre1 = " +"'"+genre1+"'" + "or genre2 = "
                + "'"+genre1+"')" + "& (genre1 = " + "'"+genre2+"'" + "or genre2 = " +  "'"+genre1+"');";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(filmsRequest_n);
        List<Integer> indexes = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            indexes.add(id);
        }
        if (indexes.isEmpty()) {
            return "По вашему запросу ничего не найдено(((";
        } else {
            Random randomizer = new Random();
            int random = indexes.get(randomizer.nextInt(indexes.size()));
            rs = statement.executeQuery("SELECT * FROM films WHERE id =" + random);
            String name = rs.getString("name");
            double score = rs.getDouble("score");
            String genre10 = rs.getString("genre1");
            String genre20 = rs.getString("genre2");
            String decr = rs.getString("descr");
            result += name + "\t|" + score + "\t|" + genre10 + "\t|" + genre20 + "\t|" + decr + "\n";

        }
        rs.close();
        statement.close();
        return result;
    }

    public final String selectFromBooks(String genre1, String genre2) throws Exception {
        String result = "";
        String filmsRequest_n = "SELECT id FROM books WHERE (genre1 = " +"'"+genre1+"'" + "or genre2 = "
                + "'"+genre1+"')" + "& (genre1 = " + "'"+genre2+"'" + "or genre2 = " +  "'"+genre1+"');";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(filmsRequest_n);
        List<Integer> indexes = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            indexes.add(id);
        }
        if (indexes.isEmpty()) {
            return "По вашему запросу ничего не найдено(((";
        } else {
            Random randomizer = new Random();
            int random = indexes.get(randomizer.nextInt(indexes.size()));
            rs = statement.executeQuery("SELECT * FROM books WHERE id =" + random);
            String name = rs.getString("name");
            double score = rs.getDouble("score");
            String genre10 = rs.getString("genre1");
            String genre20 = rs.getString("genre2");
            String decr = rs.getString("descr");
            result += name + "\t|" + score + "\t|" + genre10 + "\t|" + genre20 + "\t|" + decr + "\n";

        }
        rs.close();
        statement.close();
        return result;
    }

    public final String selectFromGames(String genre1, String genre2) throws Exception {
        String result = "";
        String filmsRequest_n = "SELECT id FROM games WHERE (genre1 = " +"'"+genre1+"'" + "or genre2 = "
                + "'"+genre1+"')" + "or (genre1 = " + "'"+genre2+"'" + "or genre2 = " +  "'"+genre1+"');";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(filmsRequest_n);
        List<Integer> indexes = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            indexes.add(id);
        }
        if (indexes.isEmpty()) {
            return "По вашему запросу ничего не найдено(((";
        } else {
            Random randomizer = new Random();
            int random = indexes.get(randomizer.nextInt(indexes.size()));
            rs = statement.executeQuery("SELECT * FROM games WHERE id =" + random);
            String name = rs.getString("name");
            double score = rs.getDouble("score");
            String genre10 = rs.getString("genre1");
            String genre20 = rs.getString("genre2");
            String decr = rs.getString("descr");
            result += name + "\t|" + score + "\t|" + genre10 + "\t|" + genre20 + "\t|" + decr + "\n";

        }
        rs.close();
        statement.close();
        return result;
    }


//=====================================================================================================================


}
