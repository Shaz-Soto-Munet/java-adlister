import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PizzaOrder")
public class PizzaOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pizza-order.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String crust = request.getParameter("crust");
        String sauce = request.getParameter("sauce");
        String size = request.getParameter("size");
        ArrayList<String> toppings = new ArrayList<>();

        String topping1 = request.getParameter("toppings1");
        String topping2 = request.getParameter("toppings2");
        String topping3 = request.getParameter("toppings3");
        String topping4 = request.getParameter("toppings4");
        String topping5 = request.getParameter("toppings5");

        if (topping1 != null) {
            toppings.add(topping1);
        }
        if (topping2 != null) {
            toppings.add(topping2);
        }
        if (topping3 != null) {
            toppings.add(topping3);
        }
        if (topping4 != null) {
            toppings.add(topping4);
        }
        if (topping5 != null) {
            toppings.add(topping5);
        }


        String address = request.getParameter("address");


        System.out.println("Incoming order:");
        System.out.println("Crust: " + crust);
        System.out.println("sauce: " + sauce);
        System.out.println("size: " + size);
        System.out.println("toppings: " + toppings);
        System.out.println("address: " + address);

        if (crust != null && sauce != null && size != null && toppings != null && address != null) {
            request.getRequestDispatcher("/pizza-order-successful.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/pizza-order-unsuccessful.jsp").forward(request, response);
        }

    }
}
