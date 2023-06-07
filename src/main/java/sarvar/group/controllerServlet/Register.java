package sarvar.group.controllerServlet;

import lombok.SneakyThrows;
import sarvar.group.modelDao.User;
import sarvar.group.service.DBConnection;
import sarvar.group.service.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class Register extends HttpServlet {

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

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        User user = new User(
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                req.getParameter("birthDate"),
                req.getParameter("email"),
                req.getParameter("phoneNumber"),
                req.getParameter("password"),
                req.getParameter("prePassword")
        );

        DBConnection dbConnection = new DBConnection();
        Result result = dbConnection.register(user);
        if (result.isSuccess()) {
            printWriter.write(
                    "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>Title</title>\n" +
                            "    <style type=\"text/css\">\n" +
                            "        @import url('//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css');\n" +
                            "\n" +
                            "        .success-msg{\n" +
                            "            margin: 10px 0;\n" +
                            "            padding: 10px;\n" +
                            "            border-radius: 3px 3px 3px 3px;\n" +
                            "        }\n" +
                            "        .success-msg {\n" +
                            "            color: #270;\n" +
                            "            background-color: #DFF2BF;\n" +
                            "        }\n" +
                            "    </style>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <div class=\"success-msg\">\n" +
                            "        <i class=\"fa fa-check\"></i>\n" +
                            result.getMessage() +
                            "    </div>\n" +
                            "</body>\n" +
                            "</html>"
            );
        } else {
            printWriter.write(
                    "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>Title</title>\n" +
                            "    <style type=\"text/css\">\n" +
                            "        @import url('//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css');\n" +
                            "\n" +
                            "        .warning-msg {\n" +
                            "            margin: 10px 0;\n" +
                            "            padding: 10px;\n" +
                            "            border-radius: 3px 3px 3px 3px;\n" +
                            "        }\n" +
                            "        .warning-msg {\n" +
                            "            color: #9F6000;\n" +
                            "            background-color: #FEEFB3;\n" +
                            "        }\n" +
                            "    </style>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <div class=\"warning-msg\">\n" +
                            "        <i class=\"fa fa-warning\"></i>\n" +
                            result.getMessage() +
                            "    </div>\n" +
                            "</body>\n" +
                            "</html>"
            );
        }
    }
}
