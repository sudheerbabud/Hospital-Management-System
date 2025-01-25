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
@WebServlet("/deletePatient")
public class DeletePatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		System.out.println(pid);
		PatModel pm = new PatModel();
		pm.setPid(pid);
		PatDAO pd = new PatDAO();
		boolean status = pd.DeletePatientDetails(pm);
		if(status==true) {
			RequestDispatcher rd = request.getRequestDispatcher("patientDeleted.jsp");
			rd.forward(request, response);
		}else {
			out.println("<html><body><h1>Problem Occured</h1><br></body></html>");
		}
	}

}
