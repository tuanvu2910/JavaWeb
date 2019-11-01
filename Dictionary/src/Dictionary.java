import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Dictionary", urlPatterns = "/translate")
public class Dictionary extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EngLish_to_VietNamese EngtoVN = new EngLish_to_VietNamese();
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("Hello",EngtoVN.vietNamese[0]);
        dictionary.put("Book",EngtoVN.vietNamese[1]);
        dictionary.put("how",EngtoVN.vietNamese[2]);
        dictionary.put("computer",EngtoVN.vietNamese[3]);
        String search = request.getParameter("txtSearch");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        String result = dictionary.get(search);
        if(search.equals("Hello") ||search.equals("Book")||search.equals("how")||search.equals("computer")){
            writer.println("Word:"+ search);
            writer.println("Result:"+result);}
         else if (search.equals("")){
                writer.println("Enter your words!!!");
        } else {
            writer.println("Not Found!!!");
        }

            writer.println("</html>");

        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

