package com.hospital.controller;

import java.io.IOException;
import java.util.List;

import com.hospital.DAO.DocDAO;
import com.hospital.model.DocModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/viewDoctor")
public class viewDoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DocDAO md = new DocDAO();
        List<DocModel> li = md.SelectDoctorsDetails();
        
        for(DocModel cl:li) {
        	System.out.println("MyviewDoctorController....");
        	System.out.println(cl.getDid());
        	System.out.println(cl.getDname());
        	System.out.println(cl.getDspecialization());
        	System.out.println(cl.getDgender());
        }

        if (li != null) {
            for (DocModel cl : li) {
                System.out.println(cl.getDid() + " " + cl.getDname() + " " + cl.getDspecialization()+ " "+ cl.getDgender());
            }
        }
        
      
        if (li != null) {
            request.setAttribute("doctors", li);
        } else {
            request.setAttribute("doctors", null);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewDoctors.jsp");
        
        dispatcher.forward(request, response);
        
	}

}
