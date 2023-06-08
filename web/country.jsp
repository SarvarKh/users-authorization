<%@ page import="sarvar.group.service.DBConnection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="sarvar.group.service.util.Result" %>
<%@ page import="java.util.List" %>
<%@ page import="sarvar.group.modelDao.Country" %><%--
  Created by IntelliJ IDEA.
  User: sarvarkhalimov
  Date: 08/06/23
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country List</title>
<%--    <link href="assets/bootstrap-5.3.0-dist/css/bootstrap.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<%
    DBConnection dbConnection = new DBConnection();
    try {
        Result result = dbConnection.addCountry(request.getParameter("name"));
        if (result.isSuccess()) {
            System.out.println(result.getMessage());
        } else {
            System.out.println(result.getMessage());
        }
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
%>
    <h1>Welcome to Country List page!</h1>
    <div class="container">
        <form>
            <div class="mb-3">
                <label for="country" class="form-label">Country name</label>
                <input type="text" class="form-control" id="country">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

        <table class="table table-striped">
            <thead>
            <tr class="table-primary">
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col" colspan="2">Action</th>
            </tr>
            </thead>
            <tbody class="table table-striped">
            <%
                List<Country> countryList = dbConnection.getCountryList();
                for (int i = 0; i < countryList.size(); i++) {
                    out.println(
                            "<tr>\n" +
                                    "<th scope=\"row\">"+(i+1)+"</th>\n" +
                                    "<td>"+countryList.get(i).getName()+"</td>\n" +
                                    "<td>" +
                                    "<button type=\"button\" class=\"btn btn-outline-danger\">Danger</button>\n" +
                                    "<button type=\"button\" class=\"btn btn-outline-warning\">Warning</button>" +
                                    "</td>\n" +
                                    "</tr>"
                    );
                }
            %>
<%--            <tr>--%>
<%--                <th scope="row">2</th>--%>
<%--                <td>Jacob</td>--%>
<%--                <td>Thornton</td>--%>
<%--                <td>@fat</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th scope="row">3</th>--%>
<%--                <td colspan="2">Larry the Bird</td>--%>
<%--                <td>@twitter</td>--%>
<%--            </tr>--%>
            </tbody>
        </table>
    </div>
<%--    <script src="assets/bootstrap-5.3.0-dist/js/bootstrap.js"></script>--%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
