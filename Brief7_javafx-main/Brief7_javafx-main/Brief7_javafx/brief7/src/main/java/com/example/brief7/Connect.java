package com.example.brief7;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    public Connect(){}

    public Connection getConnection() {

        Connection cn = null;

        try {

            cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Brief5", "postgres", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cn;
    }
}
