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
%>
    <div class="container">
        <h1>Welcome to Address page</h1>
        <form action="country" method="post" class="border border-primary-subtle p-2 mb-6">
            <h3>Country form</h3>
            <div class="mb-3">
                <label for="country" class="form-label">Country name</label>
                <input type="text" class="form-control" id="country" name="name" required>
            </div>
            <button type="submit" class="btn btn-primary">Add country</button>
        </form>


        <form action="region" method="post" class="border border-primary-subtle p-2 mb-6">
            <h3>Region form</h3>
            <label class="form-label">Select country</label>
            <select name="country_id" class="form-select" aria-label="Default select example">
                <option selected>Open this select menu</option>
                <%
                    List<Country> countryList = dbConnection.getCountryList();
                    for (int i = 0; i < countryList.size(); i++) {
                        out.println(
                                "<option value=\"" +
                                        +countryList.get(i).getId()+
                                        "\">" +
                                        countryList.get(i).getName()+
                                        "</option>"
                        );
                    }
                %>
            </select>

            <div class="mb-3">
                <label for="region" class="form-label">Region name</label>
                <input type="text" class="form-control" id="region" name="region">
            </div>

            <button type="submit" class="btn btn-primary">Add region</button>
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
                for (int i = 0; i < countryList.size(); i++) {
                    Country country = countryList.get(i);
                    
                    out.println(
                            "<tr>\n" +
                                    "<th scope=\"row\">"+(i+1)+"</th>\n" +
                                    "<td>"+country.getName()+"</td>\n" +
                                    "<td>" +
                                    "<button type=\"button\" class=\"btn btn-outline-danger\">Delete</button>\n" +
                                    "<button type=\"button\" class=\"btn btn-outline-warning\">Edit</button>" +
                                    "</td>\n" +
                                    "</tr>"
                    );
                }
            %>
            </tbody>
        </table>
    </div>
<%--    <script src="assets/bootstrap-5.3.0-dist/js/bootstrap.js"></script>--%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
