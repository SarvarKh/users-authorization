package sarvar.group.controllerServlet;

import lombok.SneakyThrows;
import sarvar.group.controllerServlet.util.Response;
import sarvar.group.service.DBConnection;
import sarvar.group.service.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Register</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div>\n" +
                "        <form action=\"/login\" method=\"post\">\n" +
                "            <input type=\"email\" name=\"email\" placeholder=\"Please enter your email\">\n" +
                "            <br><br>\n" +
                "            <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Please enter your password\">\n" +
                "            <br><br>\n" +
                "            <button type=\"submit\" id=\"button\" onclick=\"checkPassword()\">Login</button>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>");

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        DBConnection dbConnection = new DBConnection();
        Result result = dbConnection.login(email, password);

        Response.respond(printWriter, result);
    }
}
