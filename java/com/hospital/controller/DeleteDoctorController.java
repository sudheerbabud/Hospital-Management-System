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
@WebServlet("/deleteDoctor")
public class DeleteDoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int did = Integer.parseInt(request.getParameter("did"));
		System.out.println(did);
		DocModel dm = new DocModel();
		dm.setDid(did);
		DocDAO pd = new DocDAO();
		boolean status = pd.DeleteDoctorDetails(dm);
		if(status==true) {
			RequestDispatcher rd = request.getRequestDispatcher("doctorDeleted.jsp");
			rd.forward(request, response);
		}else {
			out.println("<html><body><h1>Problem Occured</h1><br></body></html>");
		}
	}

}
