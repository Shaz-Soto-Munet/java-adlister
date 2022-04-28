import java.io.Serializable;
import java.util.Date;

public class Album implements Serializable {
    private long id;
    private String artist;
    private String name;
    private Date release_date;
    private double sales;
    private String genre;

    public Album(){}

    public Album(long id, String artist, String name, Date release_date, double sales, String genre) {
        this.id = id;
        this.artist = artist;
        this.name = name;
        this.release_date = release_date;
        this.sales = sales;
        this.genre = genre;
    }
}
