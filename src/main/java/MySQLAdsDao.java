import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{

    private Connection connection;

    public MySQLAdsDao(){

        try {

            Config config = new Config();

            DriverManager.registerDriver(new Driver());

            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );

        } catch (SQLException sqle) {

            sqle.printStackTrace();

        }

    }

    @Override
    public List<Ad> all(){

        List<Ad> ads = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM adlister_db.ads");

            while (rs.next()){

                Ad ad = new Ad(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                );

                ads.add(ad);

            }

        } catch (SQLException sqle){
            throw new RuntimeException("error connecting to db", sqle);
        }

        return ads;
    }

    @Override
    public void insert(Ad ad) {

        String query = "INSERT INTO adlister_db.ads (user_id, title, description) VALUES (" + ad.getUserId() + ",'" + ad.getTitle() + "', '" + ad.getDescription() + "')";


        try {

            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

        } catch (SQLException sqle){
            throw new RuntimeException("error connecting to db", sqle);
        }

    }




}