<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hospital.model.PatModel"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patient List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fc;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1000px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #4CAF50;
            text-align: center;
            margin-bottom: 20px;
        }

        .card {
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 10px;
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        td {
            background-color: #f9f9f9;
        }

        .btn {
            padding: 5px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn-primary {
            background-color: #007bff;
            color: white;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .btn-danger {
            background-color: #dc3545;
            color: white;
        }

        .btn-danger:hover {
            background-color: #c82333;
        }

        .alert {
            margin-top: 20px;
            padding: 10px;
            background-color: #f8d7da;
            color: #721c24;
            border-radius: 5px;
            text-align: center;
        }

    </style>
</head>
<body>
    <div class="container">
        <h2>Patients List</h2>

        <div class="card">
            <%
                List<PatModel> list = (List<PatModel>) request.getAttribute("patients");
            %>

            <table>
                <thead>
                    <tr>
                        <th>Patient id</th>
                        <th>patient Name</th>
                        <th>patient Age</th>
                        <th>Patient gender</th>
                        <th colspan="2">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (list != null && !list.isEmpty()) {
                            for (PatModel mp : list) {
                    %>
                    <tr>
                        <td><%=mp.getPid()%></td>
                        <td><%=mp.getPname()%></td>
                        <td><%=mp.getPage()%></td>
                        <td><%=mp.getPgender()%></td>
                        <td>
                            <form action="beforepatientupdate.jsp" method="post" style="display: inline;">
                                <input type="hidden" name="pid" value="<%=mp.getPid()%>">
                                <input type="hidden" name="pname" value="<%=mp.getPname()%>">
                                <input type="hidden" name="page" value="<%=mp.getPage()%>">
                                <input type="hidden" name="pgender" value="<%=mp.getPgender()%>">
                                <button type="submit" class="btn btn-primary">Edit</button>
                            </form>
                        </td>

                        <td>
                            <form action="deletePatient" method="post" style="display: inline;">
                                <input type="hidden" name="pid" value="<%=mp.getPid()%>">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="6">No Patients available.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

        <% if (request.getAttribute("errorMessage") != null) { %>
        <div class="alert">
            <%= request.getAttribute("errorMessage") %>
        </div>
        <% } %>
    </div>
</body>
</html>
