package sarvar.group.model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div>\n" +
                "    <h2>HOME PAGE</h2>\n" +
                "      <br>\n" +
                "      <a href=\"http://localhost:8080/login\">Login</a>\n" +
                "      <br>\n" +
                "      <br>\n" +
                "      <a href=\"http://localhost:8080/register\">Register</a>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>");
    }
}
