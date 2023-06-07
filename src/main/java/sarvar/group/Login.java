package sarvar.group;

import sarvar.group.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
                "            <button type=\"submit\" id=\"button\" onclick=\"checkPassword()\">Register</button>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (checkUserCredentials(email, password)) {
            printWriter.write("" +
                    "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "  <div>\n" +
                    "    <h2>Welcome!</h2>\n" +
                    "      <h3>You successfully loged in!</h3>\n" +
                    "  </div>\n" +
                    "</body>\n" +
                    "</html>");
        } else {
            printWriter.write("" +
                    "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "  <div>\n" +
                    "    <h2>Sorry!</h2>\n" +
                    "      <h3>Such user doesn't exist.</h3>\n" +
                    "      <div>try to <a href=\"http://localhost:8080/login\">login</a> once again</div>\n" +
                    "  </div>\n" +
                    "</body>\n" +
                    "</html>");
        }
    }

    private boolean checkUserCredentials(String email, String password) {
        List<User> registeredUsers = Register.users;
        for (User user : registeredUsers) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
