package sarvar.group.controllerServlet;

import lombok.SneakyThrows;
import sarvar.group.service.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/region")
public class RegionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConnection dbConnection = new DBConnection();
        dbConnection.addRegion(
                req.getParameter("country_id"),
                req.getParameter("region")
        );
        RequestDispatcher reqd = req.getRequestDispatcher("country.jsp");
        reqd.forward(req, resp);
    }
}
