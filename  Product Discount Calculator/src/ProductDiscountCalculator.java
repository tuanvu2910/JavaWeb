import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Product Discount Calculator", urlPatterns = "/display-discount")
public class ProductDiscountCalculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter Writer = response.getWriter();
        String ProductDescription = request.getParameter("Product Description");
        double ListPrice = Double.parseDouble(request.getParameter("List Price"));
        double DiscountPercent = Double.parseDouble(request.getParameter("Discount Percent"));
        double DiscountAmount = ListPrice * DiscountPercent * 0.1;
        double DiscountPrice = ListPrice - DiscountAmount;
        Writer.println("<html>");
        Writer.println("<head>" +
                "    <title></title>" +
                "  </head>" +
                "  <body>");
        Writer.println("<fieldset><legend style=\"margin: auto\"> Product Discount Calculator</legend>");
        Writer.println("ProductDescription:");
        Writer.println(ProductDescription );
        Writer.println("DiscountPrice = " +DiscountPrice);
        Writer.println("</fieldset>");
        Writer.println(
                  "</body>");
        Writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
