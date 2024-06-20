import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String DB_URL = "sales-analyse-report.cxawkw4ggdro.eu-north-1.rds.amazonaws.com";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "0987654321";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

}
