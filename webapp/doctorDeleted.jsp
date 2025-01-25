<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Deleted</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
          rel="stylesheet" 
          integrity="sha384-qm5j8aXpdmSbI3TfwtMdPlwu7V2l6J3bGpysWeY9jZOULzZCEAsXvy6iVoXTQdFQ" 
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
            integrity="sha384-Yd8a4G3Zb9/bBhvRmUyPq3KwJRSrUnrh8eGlxPBbFqyQ6LjTuVnA9luJUR9j+MJs" 
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .box {
            background: #ffffff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
            text-align: center;
        }
        .box h2 {
            color: #dc3545; /* Red color for "Patient Deleted" message */
            font-weight: bold;
        }
        .btn {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="box">
        <h2>Doctor Deleted</h2>
        <p>The Doctor record has been successfully removed.</p>
        <!-- Button to add another patient -->
        <a href="index.jsp">
            <button class="btn btn-primary">Add Another Doctor</button>
        </a>
        <!-- Form to view all patient details -->
        <form action="viewDoctorController" method="post" style="margin-top: 20px;">
            <h4>Want to see all the doctor details?</h4>
            <button type="submit" class="btn btn-success">View Doctor List</button>
        </form>
    </div>
</body>
</html>
