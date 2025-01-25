package com.hospital.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.hospital.DAO.PatDAO;
import com.hospital.model.PatModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/addPatient")
public class addPatientController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		int page = Integer.parseInt(request.getParameter("page"));
		String pgender = request.getParameter("pgender");
		System.out.println("AddPatientController");
		System.out.println(pid);
		System.out.println(pname);
		System.out.println(page);
		System.out.println(pgender);
		
		PatModel am = new PatModel();
		am.setPid(pid);
		am.setPname(pname);
		am.setPage(page);
		am.setPgender(pgender);
		
		PatDAO md = new PatDAO();
		boolean status = md.InsertPatientDetails(am);
		if(status== true) {
			RequestDispatcher rd = request.getRequestDispatcher("patientpage.jsp");
			rd.forward(request, response);
			out.println("<html><body><h1>Details Inserted</h1><br></body></html>");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("addPatients.jsp");
			rd.forward(request, response);
			out.println("<html><body><h1>Occured problem</h1><br></body></html>");
		}
	}
}
