package sarvar.group.controllerServlet;

import lombok.SneakyThrows;
import sarvar.group.controllerServlet.util.Response;
import sarvar.group.modelDao.Country;
import sarvar.group.modelDao.User;
import sarvar.group.service.DBConnection;
import sarvar.group.service.util.Result;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/country")
public class CountryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher reqd = req.getRequestDispatcher("country.jsp");
        reqd.forward(req, resp);
//        resp.sendRedirect("country.jsp");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DBConnection dbConnection = new DBConnection();
        dbConnection.addCountry(req.getParameter("name"));
        RequestDispatcher reqd = req.getRequestDispatcher("country.jsp");
        reqd.forward(req, resp);
    }
}
