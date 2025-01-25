<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
<style>
	body {
            background-color: #f4f4f9;
            font-family: 'Arial', sans-serif;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            padding: 30px;
            text-align: center;
            width: 100%;
            max-width: 500px;
        }

        h2 {
            font-size: 2rem;
            color: #28a745;
            margin-bottom: 20px;
        }

        p {
            font-size: 1rem;
            color: #555;
            margin-bottom: 30px;
        }

        .btn-primary {
            background-color: #007bff;
            border: none;
            font-size: 1.1rem;
            padding: 10px 30px;
            border-radius: 7px;
            transition: background-color 0.3s;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .btn {
            cursor: pointer;
        }

    </style>
</head>
<body>
<!-- 	<form action="viewPatientController" method="post"> -->
    	<div class="container mt-5">
        <h2 class="text-center text-success">Error Occured</h2>
        <p class="text-center"><%= request.getAttribute("message") %></p>
<!--         <div class="text-center mt-4"> -->
<!--             <button type="submit" class="btn btn-primary">Back to List</button> -->
<!--         </div> -->
    </div>
    </form>
</body>
</html>