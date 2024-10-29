package fr.formation.demo;

import java.sql.*;

/**
 * Singleton : Design pattern pour une instance unique
 */
public class ConnectionManager {

    private final static String URL = "jdbc:mysql://localhost:3306/example";
    private final static String USER = "root";
    private final static String PASSWORD = "";

    private static Connection S_CONNECTION;

    private ConnectionManager(){}

    public static Connection getConnection(){
        loadDriver();

        if(S_CONNECTION == null) {
            try {
                S_CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Connexion impossible");
            }
        }
        return S_CONNECTION;
    }

    private static void loadDriver(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Driver MySQL introuvable");
        }
    }

//    public static boolean closeConnection(){
//            try {
//                if(connection != null && connection.isClosed()) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                System.err.println("Fermeture connexion impossible");
//            }
//    }


}
