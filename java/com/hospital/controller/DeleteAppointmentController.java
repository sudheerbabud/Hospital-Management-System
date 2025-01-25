package com.hospital.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.hospital.DAO.AppDAO;
import com.hospital.model.AppModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteAppointment")
public class DeleteAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int aid = Integer.parseInt(request.getParameter("aid"));
		System.out.println(aid);
		
		AppModel a = new AppModel();
		a.setAid(aid);
		
		AppDAO ad = new AppDAO();
		boolean status = ad.DeleteAppointment(a);
		if(status==true) {
			RequestDispatcher rd = request.getRequestDispatcher("appointmentDeleted.jsp");
			rd.forward(request, response);
		}else {
			out.println("<html><body><h1>Problem Occured</h1><br></body></html>");
		}
	}

}
