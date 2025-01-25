package com.hospital.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hospital.utility.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/updateDoctor")
public class UpdateDoctorController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int did = Integer.parseInt(request.getParameter("did"));
        String dname = request.getParameter("dname");
        String dspecialization = request.getParameter("dspecialization");
        String dgender = request.getParameter("dgender");

        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE doctors SET dname=?, dspecialization=?, dgender=? WHERE did=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, dname);
            ps.setString(2, dspecialization);
            ps.setString(3, dgender);
            ps.setInt(4, did);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                request.setAttribute("message", "Details successfully updated.");
            } else {
                request.setAttribute("message", "Update failed. Please try again.");
            }
            request.getRequestDispatcher("doctorupdated.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
