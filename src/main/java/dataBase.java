import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Stack;

public class dataBase {

    static Dotenv dotenv = Dotenv.load();

    private static final String dbUrl = dotenv.get("DB_URL");
    private static final String dbUsername = dotenv.get("DB_USERNAME");
    private static final String dbPassword = dotenv.get("DB_PASSWORD");

    public static Connection getConnection() {
        Connection connect = null;
        Statement statement = null;

        try {

            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Connection Established!");
            statement = connect.createStatement();


        } catch (Exception e) {
            System.out.print(e);
        }

        return connect;
    }

    public static void main(String[] args) {
        getConnection();
    }


}
