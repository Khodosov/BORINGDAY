package ru.spbu.apmath.sem2.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{
    public static void main(){
        Connection conn = null:
        try {
            String url = "jdbc:sqlite:C:\Users\khodo\boring_day.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQlite has been established!);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (conn != null){
                    conn.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        public static void main(String[] args) {
            main();
    }
}
}
