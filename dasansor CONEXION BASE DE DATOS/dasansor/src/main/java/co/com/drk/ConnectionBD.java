package co.com.drk;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBD {

    public static final String URL = "jdbc:mysql://localhost:3307/dasansor";
    public static final String USER = "root";
    public static final String CLAVE = "1234";

    public Connection conectarBd() {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return con;
    }

}


