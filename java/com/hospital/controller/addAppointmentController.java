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
@WebServlet("/addAppointment")
public class addAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		int aid = Integer.parseInt(request.getParameter("aid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		int did = Integer.parseInt(request.getParameter("did"));
		String adate = request.getParameter("adate");
		
		AppModel a = new AppModel();
		a.setAid(aid);
		a.setPid(pid);
		a.setDid(did);
		a.setAdate(adate);
		AppDAO ad = new AppDAO();
		boolean status = ad.InsertAppointment(a);
		if(status==true) {
			RequestDispatcher rd = request.getRequestDispatcher("appointmentpage.jsp");
			rd.forward(request, response);
		}else {
			out.println("<html><body><h1>Problem Occured</h1><br></body></html>");
		}
	}

}
