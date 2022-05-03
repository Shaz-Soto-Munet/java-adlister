import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDAO implements Ads{

    private Connection connection = null;

    public MySQLAdsDAO(){

        try {

            Config config = new Config();

            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());

        } catch (SQLException sqle) {

            sqle.printStackTrace();

        }

    }

    @Override
    public List<Ad> all(){

        List<Ad> ads = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM codeup_test_db.quotes");

            while (rs.next()){
                long author_id = rs.getLong("author_id");

                Author quoteAuthor = null;

                Statement statement1 = connection.createStatement();
                ResultSet rs2 = statement1.executeQuery("SELECT * FROM codeup_test_db.authors WHERE id=" + author_id);

                while (rs2.next()) {

                    quoteAuthor = new Author(
                            rs2.getLong("id"),
                            rs2.getString("author_name")
                    );

                }

                Quote quote = new Quote(
                        rs.getLong("id"),
                        rs.getString("content"),
                        quoteAuthor
                );


                quotes.add(quote);


            }

        } catch (SQLException sqle){
            throw new RuntimeException("error connecting to db", sqle);
        }

        return quotes;
    }

    @Override
    public Long insert(Ad ad) {
        return null;
    }
}
