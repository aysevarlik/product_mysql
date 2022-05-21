package aysevarlik;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.sql.*;


public class DatabaseConnection extends DatabaseInformation {

    private String url = this.getUrl();
    private String userName = this.getUserName();
    private String userPassword = this.getUserPassword();
    private String forNameData = this.getForNameData();
    private Connection connection;


    private static DatabaseConnection instance;

    private DatabaseConnection() {
        try {
            Class.forName(this.getForNameData());
            System.out.println("Driver Success");
            connection = DriverManager.getConnection(url, userName, userPassword);
            System.out.println("Connection Success");

        }catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        try {
            if (instance == null || instance.connection.isClosed()) {
                instance = new DatabaseConnection();
            }
        } catch (SQLException sql) {
            System.out.println("sql is not working");
            sql.printStackTrace();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public DatabaseConnection setConnection(Connection connection) {
        this.connection = connection;
        return this;
    }

    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection();
    }
}



