<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Appointment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --primary-color: #1e88e5;
            --secondary-color: #43a047;
            --background-color: #f0f4f8;
            --form-background: #ffffff;
            --text-color: #333333;
            --input-border: #cccccc;
            --backdrop-color: #0ef;
        }

        body {
            font-family: 'Arial', sans-serif;
            background-color: var(--background-color);
            color: var(--text-color);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            position: relative;
            overflow: hidden;
        }

        body::before {
            content: '';
            position: absolute;
            top: -50%;
            left: -50%;
            width: 200%;
            height: 200%;
            background: radial-gradient(circle, var(--backdrop-color) 0%, transparent 70%);
            opacity: 0.3;
            z-index: -1;
            animation: pulse 10s infinite;
        }

        @keyframes pulse {
            0% { transform: scale(1); }
            50% { transform: scale(1.1); }
            100% { transform: scale(1); }
        }

        .form-container {
            background-color: var(--form-background);
            border-radius: 8px;
            box-shadow: 0 4px 20px rgba(0, 238, 255, 0.2);
            padding: 2rem;
            width: 100%;
            max-width: 400px;
            position: relative;
            z-index: 1;
        }

        h2 {
            color: var(--primary-color);
            margin-bottom: 1.5rem;
            text-align: center;
        }

        .form-label {
            font-weight: 600;
            color: var(--text-color);
        }

        .form-control {
            border: 1px solid var(--input-border);
            border-radius: 4px;
            padding: 0.5rem;
            margin-bottom: 1rem;
        }

        .btn-primary {
            background-color: var(--primary-color);
            border: none;
            width: 100%;
            padding: 0.75rem;
            font-weight: 600;
            text-transform: uppercase;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .btn-primary:hover {
            background-color: var(--secondary-color);
            transform: translateY(-2px);
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Add Appointment</h2>
        <form action="addAppointment" method="post">
            <div class="mb-3">
                <label for="AppointmentId" class="form-label">Appointment ID:</label>
                <input type="text" class="form-control" id="AppointmentId" name="aid" required>
            </div>
            <div class="mb-3">
                <label for="patientId" class="form-label">Patient ID:</label>
                <input type="text" class="form-control" id="patientId" name="pid" required>
            </div>
            <div class="mb-3">
                <label for="doctorId" class="form-label">Doctor ID:</label>
                <input type="text" class="form-control" id="doctorId" name="did" required>
            </div>
            <div class="mb-3">
                <label for="appointmentDate" class="form-label">Appointment Date:</label>
                <input type="date" class="form-control" id="appointmentDate" name="adate" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Appointment</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
