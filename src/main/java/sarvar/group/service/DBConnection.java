package sarvar.group.service;

import sarvar.group.modelDao.Country;
import sarvar.group.modelDao.Region;
import sarvar.group.modelDao.User;
import sarvar.group.service.util.Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static String url = "jdbc:postgresql://localhost:5432/myUserDB";
    private static String dbUserName = "postgres";
    private static String dbPassword = null;

    public static Result addCountry(String name) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
        String query = "{call add_country(?,?,?)}";

        CallableStatement statement = connection.prepareCall(query);
        statement.setString(1, name);
        statement.registerOutParameter(2, Types.VARCHAR);
        statement.registerOutParameter(3, Types.BOOLEAN);
        statement.executeUpdate();

        String message = statement.getString(2);
        boolean success = statement.getBoolean(3);

        return new Result(message, success);
    }

    public static List<Country> getCountryList() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from country");
        List<Country> countryList = new ArrayList<>();
        while (resultSet.next()) {
            Country country = new Country(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            );
            countryList.add(country);
        }
        return countryList;
    }

    public static List<Region> getRegionList(String country_id) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from region where country_id=" + country_id);

        List<Region> regionList = new ArrayList<>();
        while (resultSet.next()) {
            Region region = new Region(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("country_id")
            );
            regionList.add(region);
        }
        return regionList;
    }


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

    public static Result addRegion(String countryId, String name) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
        String query = "{call add_region(?,?,?,?)}";

        CallableStatement statement = connection.prepareCall(query);
        statement.setString(1, name);
        statement.setInt(2, Integer.parseInt(countryId));
        statement.registerOutParameter(3, Types.VARCHAR);
        statement.registerOutParameter(4, Types.BOOLEAN);
        statement.executeUpdate();

        String message = statement.getString(3);
        boolean success = statement.getBoolean(4);
        Result result = new Result(message, success);
        return result;
    }
}
