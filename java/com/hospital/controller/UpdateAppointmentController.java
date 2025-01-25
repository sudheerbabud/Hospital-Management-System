package com.hospital.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hospital.utility.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/updateAppointment")
public class UpdateAppointmentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int aid = Integer.parseInt(request.getParameter("aid"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        int did = Integer.parseInt(request.getParameter("did"));
        String adate = request.getParameter("adate");

        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE appointments SET patientid=?, doctorid=?, appointmentdate=? WHERE appointmentid=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, pid);
            ps.setInt(2, did);
            ps.setString(3, adate);
            ps.setInt(4, aid);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                request.setAttribute("message", "Details successfully updated.");
            } else {
                request.setAttribute("message", "Update failed. Please try again.");
            }
            request.getRequestDispatcher("appointmentupdated.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
