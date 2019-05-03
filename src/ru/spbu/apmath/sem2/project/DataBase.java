package ru.spbu.apmath.sem2.project;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;


public class DataBase {


    private static final String CON_STR = "jdbc:sqlite:C:\\Users\\khodo\\proj.db";
    private static DataBase instance = null;

    public static synchronized DataBase getInstance() throws SQLException {
        if (instance == null)
            instance = new DataBase();
        return instance;
    }

    private Connection connection;

    public DataBase() throws SQLException {

        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public List<Product> getAllProducts() {

        try (Statement statement = this.connection.createStatement()) {
            List<Product> products = new ArrayList<Product>();
            ResultSet resultSet = statement.executeQuery("SELECT  name, score, genre1, genre2, descr FROM films");
            // Проходимся по нашему resultSet и заносим данные в products
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getString("name"),
                        resultSet.getDouble("score"),
                        resultSet.getString("genre1"),
                        resultSet.getString("genre2"),
                        resultSet.getString("descr")));

            }
            return products;

        } catch (SQLException e) {
            e.printStackTrace();

            return Collections.emptyList();
        }
    }
}