package com.dh.clinica_odontologica.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private static final Logger LOGGER = Logger.getLogger(DB.class);

    private static final String DROP_CREATE_ODONTOLOGOS = "DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS(" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "APELLIDO VARCHAR(100) NOT NULL," +
            "MATRICULA VARCHAR(100) NOT NULL)";

    // Crear las tablas necesarias
    public static void createTable() {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(DROP_CREATE_ODONTOLOGOS);
            LOGGER.info("Estamos creando la tabla odontologos");
            // Ejecutar las sentencias que crean las tablas
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }


}
