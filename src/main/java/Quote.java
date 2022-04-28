import java.io.Serializable;

public class Quote implements Serializable {
    private long id;
    private String content;
    private Author author_id;

    public Quote(long id, String content, Author author_id) {
        this.id = id;
        this.content = content;
        this.author_id = author_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Author author_id) {
        this.author_id = author_id;
    }
}
