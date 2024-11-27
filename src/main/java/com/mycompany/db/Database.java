package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    protected Connection conexion;
    
    // Cambiar el driver JDBC y URL para PostgreSQL
    private final String JDBC_DRIVER = "org.postgresql.Driver";
    private final String DB_URL = "jdbc:postgresql://localhost:5433/inventario";
    
    // Para credenciales de acceso a PostgreSQL
    private final String USER = "postgres";  // Cambia este usuario si es necesario
    private final String PASS = "123456";  // Cambia esta contraseña si es necesario
    
    public void Conectar() throws ClassNotFoundException {
        try {
            // Cargar el driver de PostgreSQL
            Class.forName(JDBC_DRIVER);
            // Establecer la conexión con la base de datos
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Cerrar la conexión
    public void Cerrar() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
}
