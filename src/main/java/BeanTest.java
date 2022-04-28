import java.util.ArrayList;

public class BeanTest {
    public static void main(String[] args) {
        ArrayList<Quote> quotes = new ArrayList<>();

        Author neilGeiman = new Author(1L,"Neil Geiman");
        Author marcelProust = new Author(2L,"Marcel Proust");

        Quote quote1 = new Quote(1L, "The real voyage...", marcelProust);
        Quote quote2 = new Quote(1L, "I hope that...", neilGeiman);

        quotes.add(quote1);
        quotes.add(quote2);

        for (Quote quote : quotes){
            System.out.println(quote.getAuthor_id().getAuthor() + " said: " + quote.getContent());
        }
    }
}
