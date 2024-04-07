package Scholarship_application.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginBean {
    private String username;
    private String password;
    private String jdbcDriver;
    private String dbURL;
    private String dbUserName;
    private String dbPassword;

    // Default constructor
    public loginBean(String jdbcDriver, String dbURL, String dbUserName, String dbPassword) {
        this.jdbcDriver = jdbcDriver;
        this.dbURL = dbURL;
        this.dbUserName = dbUserName;
        this.dbPassword = dbPassword;
    }

    // Getter and setter methods for username and password
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Setter methods for JDBC driver and database connection parameters
    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    // Method to check user login
    public boolean checkLogin(String jdbcDriver, String dbURL, String dbUserName, String dbPassword) {
        boolean isValidUser = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false; // 加载驱动程序失败，直接返回 false
        }

        try (Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
             Statement stmt = conn.createStatement()) {

            String query = "SELECT * FROM account_information WHERE username = '" + this.username + "' AND password = '" + this.password + "'";
            ResultSet rs = stmt.executeQuery(query);

            isValidUser = rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValidUser;
    }
}