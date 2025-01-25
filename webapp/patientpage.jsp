<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page</title>
<link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
	body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 90%;
            width: 400px;
        }
        h1 {
            color: #4CAF50;
            margin-bottom: 20px;
        }
        p {
            margin: 10px 0;
        }
        strong {
            font-weight: bold;
            color: #333;
        }
        @media (max-width: 768px) {
            .container {
                width: 90%;
                padding: 20px;
            }
        }
</style>
</head>
<body>
	<div class="container">
		<h4>PatientPage</h4>
		<a href="index.jsp"><button  class="btn btn-primary">Add Another Patient</button></a><br><br>
		<form action="viewPatient" method="post">
			<h4>View All the Patients Details</h4>
			<button type="submit" class="btn btn-success">Patients List</button>
		</form>
	</div>
</body>
</html>