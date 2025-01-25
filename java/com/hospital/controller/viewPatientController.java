package com.hospital.controller;

import java.io.IOException;
import java.util.List;

import com.hospital.DAO.PatDAO;
import com.hospital.model.PatModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/viewPatient")
public class viewPatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatDAO md = new PatDAO();
        List<PatModel> li = md.SelectPatientDetails();
        
        for(PatModel cl:li) {
        	System.out.println("MyviewPatientController....");
        	System.out.println(cl.getPid());
        	System.out.println(cl.getPname());
        	System.out.println(cl.getPage());
        	System.out.println(cl.getPgender());
        }

        if (li != null) {
            for (PatModel cl : li) {
                System.out.println(cl.getPid() + " " + cl.getPname() + " " + cl.getPage()+ " "+ cl.getPgender());
            }
        }
        
      
        if (li != null) {
            request.setAttribute("patients", li);
        } else {
            request.setAttribute("patients", null);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewPatients.jsp");
        
        dispatcher.forward(request, response);
        
	}

}
