package org.Nize.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final static String URL = "jdbc:mysql://shinkansen.proxy.rlwy.net:19447/";
    private final static String DB_NAME = "railway";
    private final static String USER = "root";
    private final static String PASS = "GyfQLZCHyJOrRYVKQXIwsGXCnndgLYSw";


    public static Connection getConexion(){

        try {
            return DriverManager.getConnection(URL + DB_NAME + "?useSSL=false&ServerTimezone=UTC", USER,PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
