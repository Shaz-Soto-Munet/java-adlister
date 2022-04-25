import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/hello")
public class HelloWorldServlet extends HttpServlet {
    private int count = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");

        if (name==null) {
            res.getWriter().println("<h1>Hello World!</h1>");
        } else {
            res.getWriter().println("<h1>Hello, " + name + "!</h1>");
        }

        res.getWriter().println("This page has been visited " + count + " times.");
        count += 1;

        if (req.getParameter("reset") != null){
            count = 0;
        }


    }
}
