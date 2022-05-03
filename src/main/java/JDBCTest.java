import java.sql.*;

import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
//    JDBC = Java Database Connectivity
//    In need of Connection obj, Statement obj, and ResultSet obj

    private static List<String> getAuthorNames(){
        List<String> authorNames = new ArrayList<>();

        try {

            Config config = new Config();

//            Get the drive into our app
            DriverManager.registerDriver(new Driver());
//            Create the connection obj
            Connection connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
//            Create the Statement obj
            Statement statement = connection.createStatement();
//            Execute statement and get results
            ResultSet rs = statement.executeQuery("SELECT author_name FROM codeup_test_db.authors");

//            Loop thru rs to populate authorNames string list
            while (rs.next()) {
                authorNames.add(rs.getString("author_name"));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return authorNames;
    }

    public static void main(String[] args) {
        List<String> authorNames = getAuthorNames();
        for(String name : authorNames){
            System.out.println(name);
        }
    }

}
