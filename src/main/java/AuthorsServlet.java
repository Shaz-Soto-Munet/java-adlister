import javax.security.auth.login.FailedLoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet ("/authors")
public class AuthorsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Authors authorsDAO = new AuthorsDAO();

        List<Author> authors = authorsDAO.all();

        req.setAttribute("authors", authors);
        req.getRequestDispatcher("/WEB-INF/quotes/authors.jsp").forward(req, resp);

    }
}
