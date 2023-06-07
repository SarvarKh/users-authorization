package sarvar.group;

import sarvar.group.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Register extends HttpServlet {
    public static List<User> users = new ArrayList<>();

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
                "        <form action=\"/register\" method=\"post\">\n" +
                "            <input type=\"text\" name=\"firstName\" placeholder=\"Please enter your firstName\">\n" +
                "            <br><br>\n" +
                "            <input type=\"text\" name=\"lastName\" placeholder=\"Please enter your lastName\">\n" +
                "            <br><br>\n" +
                "            <input type=\"date\" name=\"birthDate\" placeholder=\"Please enter your birthDate\">\n" +
                "            <br><br>\n" +
                "            <input type=\"email\" name=\"email\" placeholder=\"Please enter your email\">\n" +
                "            <br><br>\n" +
                "            <input type=\"text\" name=\"phoneNumber\" placeholder=\"Please enter your phoneNumber\">\n" +
                "            <br><br>\n" +
                "            <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Please enter your password\">\n" +
                "            <br><br>\n" +
                "            <input type=\"password\" id=\"prePassword\" name=\"prePassword\" placeholder=\"Please enter your prePassword\">\n" +
                "            <br><br>\n" +
                "            <button type=\"button\" id=\"button\" onclick=\"checkPassword()\">Register</button>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "<script type=\"text/javascript\">\n" +
                "    function checkPassword() {\n" +
                "        let password = document.getElementById(\"password\").value;\n" +
                "        let prePassword = document.getElementById(\"prePassword\").value;\n" +
                "        if (password === prePassword) {\n" +
                "            document.getElementById(\"button\").setAttribute(\"type\", \"submit\");\n" +
                "        } else {\n" +
                "            alert(\"Password and prePassword didn't match\");\n" +
                "        }\n" +
                "    }\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        User user = new User();

        if (req.getParameter("password").equals(req.getParameter("prePassword"))) {
            if (checkUserIfExists(req.getParameter("email"))) {
                printWriter.write("" +
                        "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Title</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "  <div>\n" +
                        "    <h2>Entered email already exists, try different email!</h2>\n" +
                        "  </div>\n" +
                        "</body>\n" +
                        "</html>");
            } else {
                user.setFirstName(req.getParameter("firstName"));
                user.setLastName(req.getParameter("lastName"));
                user.setBirthDate(req.getParameter("birthDate"));
                user.setEmail(req.getParameter("email"));
                user.setPhoneNumber(req.getParameter("phoneNumber"));
                user.setPassword(req.getParameter("password"));
                users.add(user);
                printWriter.write("" +
                        "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Title</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "  <div>\n" +
                        "    <h2>You successfully registered!</h2>\n" +
                        "  </div>\n" +
                        "</body>\n" +
                        "</html>");
            }
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
                    "    <h2>Entered password and prePassword didn't match</h2>\n" +
                    "  </div>\n" +
                    "</body>\n" +
                    "</html>");
        }

    }

    private boolean checkUserIfExists(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
