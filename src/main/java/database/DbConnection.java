package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection getConnectionMySql() throws SQLException {
        //Altere a linha abaixo com as informações do seu banco de dados
        return DriverManager.getConnection("jdbc:mysql://localhost/NOME_BANCO", "USUARIO","SENHA");

    }
}
