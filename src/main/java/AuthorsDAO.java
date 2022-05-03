import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorsDAO implements Authors{

    private Connection connection;

    public AuthorsDAO(){

        try {

            Config config = new Config();

            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());

        } catch (SQLException sqle) {

            sqle.printStackTrace();

        }

    }

    @Override
    public List<Author> all() {
        List<Author> authors = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM codeup_test_db.authors");

            while (rs.next()){
                Author author = new Author(
                        rs.getLong("id"),
                        rs.getString("author_name")
                );
                authors.add(author);
            }

        } catch (SQLException sqle) {

            throw new RuntimeException("error connecting to db", sqle);

        }

        return authors;
    }

    @Override
    public long insert(Author author) {
        String author_name = author.getAuthor_name();
        String query = "INSERT INTO codeup_test_db.authors (author_name) VALUES ('" + author_name + "')";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            long key = rs.getLong(1);
        } catch (SQLException sqle){
            throw new RuntimeException("error accessing database", sqle);
        }

    }

}
