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
@WebServlet("/updatePatient")
public class UpdatePatientController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        String pname = request.getParameter("pname");
        int page = Integer.parseInt(request.getParameter("page"));
        String pgender = request.getParameter("pgender");

        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE patients SET pname=?, page=?, pgender=? WHERE pid=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pname);
            ps.setInt(2, page);
            ps.setString(3, pgender);
            ps.setInt(4, pid);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                request.setAttribute("message", "Details successfully updated.");
            } else {
                request.setAttribute("message", "Update failed. Please try again.");
            }
            request.getRequestDispatcher("patientupdated.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
