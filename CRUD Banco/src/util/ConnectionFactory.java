package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private ConnectionFactory() {
    }

    public static Connection recuperarConexao() throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "postgres", "caio2002");
        return connection;
    }
}
