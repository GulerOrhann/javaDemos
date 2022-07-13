import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        DBHelper helper = new DBHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {

            connection = helper.getConnection();
            statement = connection.prepareStatement(
                    "insert into city(name,countrycode,district,population) values('Düzce','TUR','Düzce',50000)");
            int result=statement.executeUpdate();
            System.out.println("Kayit eklendi");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            helper.showErrorMessage(exception);

        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void selectDemo() {
        Connection connection = null;
        DBHelper helper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {

            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select code,name,continent,region from country");
            ArrayList<Country> countries = new ArrayList<Country>();
            while (resultSet.next()) {
                countries.add(new Country(
                        resultSet.getString("code"),
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString("region")));
            }
            System.out.println(countries.size());
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            helper.showErrorMessage(exception);

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
