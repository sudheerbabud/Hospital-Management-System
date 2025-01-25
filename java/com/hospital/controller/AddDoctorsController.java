package com.hospital.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.hospital.DAO.DocDAO;
import com.hospital.model.DocModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/addDoctor")
public class AddDoctorsController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int did = Integer.parseInt(request.getParameter("did"));
		String dname = request.getParameter("dname");
		String dspecialization = request.getParameter("dspecialization");
		String dgender = request.getParameter("dgender");
		System.out.println("AddDoctorController");
		System.out.println(did);
		System.out.println(dname);
		System.out.println(dspecialization);
		System.out.println(dgender);
		
		DocModel am = new DocModel();
		am.setDid(did);
		am.setDname(dname);
		am.setDspecialization(dspecialization);
		am.setDgender(dgender);
		
		DocDAO dd = new DocDAO();
		boolean status = dd.InsertDoctorDetails(am);
		if(status== true) {
			RequestDispatcher rd = request.getRequestDispatcher("doctorpage.jsp");
			rd.forward(request, response);
			out.println("<html><body><h1>Details Inserted</h1><br></body></html>");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("addPatients.jsp");
			rd.forward(request, response);
			out.println("<html><body><h1>Occured problem</h1><br></body></html>");
		}
	}
}
