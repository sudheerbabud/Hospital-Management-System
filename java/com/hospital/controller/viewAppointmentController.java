package com.hospital.controller;

import java.io.IOException;
import java.util.List;

import com.hospital.DAO.AppDAO;
import com.hospital.model.AppModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewAppointment")
public class viewAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		AppDAO ad = new AppDAO();
		List<AppModel> li = ad.viewAppointments();
		for (AppModel a : li) {
			System.out.println("MyviewAppointController");
			System.out.println(a.getAid());
			System.out.println(a.getPid());
			System.out.println(a.getDid());
			System.out.println(a.getAdate());

			if (li != null) {
				for (AppModel am : li) {
					System.out.println(am.getAid() + " " + am.getPid() + " " + am.getDid() + " " + am.getAdate());
				}
			}
			
			if(li != null) {
				request.setAttribute("appointments",li);
			}else {
				request.setAttribute("appointments",null);
			}
			RequestDispatcher rd = request.getRequestDispatcher("viewAppointments.jsp");
	        rd.forward(request, response);
		}

	}

}
