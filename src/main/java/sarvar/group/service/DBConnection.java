package sarvar.group.service;

import sarvar.group.modelDao.User;
import sarvar.group.service.util.Result;

import java.sql.*;

public class DBConnection {
    private static String url = "jdbc:postgresql://localhost:5432/myUserDB";
    private static String dbUserName = "postgres";
    private static String dbPassword = null;

    public static Result register(User user) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
        String query = "{call register(?,?,?,?,?,?,?,?,?)}";

        CallableStatement statement = connection.prepareCall(query);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getBirthDate());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPhoneNumber());
        statement.setString(6, user.getPassword());
        statement.setString(7, user.getPrePassword());
        statement.registerOutParameter(8, Types.VARCHAR);
        statement.registerOutParameter(9, Types.BOOLEAN);
        statement.executeUpdate();

        String message = statement.getString(8);
        boolean success = statement.getBoolean(9);

        return new Result(message, success);
    }

    public static Result login(String email, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
        String query = "{call login(?,?,?,?)}";

        CallableStatement statement = connection.prepareCall(query);
        statement.setString(1, email);
        statement.setString(2, password);
        statement.registerOutParameter(3, Types.VARCHAR);
        statement.registerOutParameter(4, Types.BOOLEAN);
        statement.executeUpdate();

        String message = statement.getString(3);
        boolean success = statement.getBoolean(4);

        return new Result(message, success);
    }
}
