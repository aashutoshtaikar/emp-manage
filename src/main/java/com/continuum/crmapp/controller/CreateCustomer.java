package com.continuum.crmapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.continuum.crmapp.dao.CustomerDAO;


@WebServlet("/CreateCustomer")
public class CreateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get stuff from html
		int cid = Integer.parseInt(request.getParameter("cid"));
		String cfname = request.getParameter("cfname");
		String clname = request.getParameter("clname"); 
		String email = request.getParameter("email"); 
		
		//store in database
		CustomerDAO dao = new CustomerDAO();
		boolean isCustomerCreated = dao.createCustomer(cid,cfname,clname,email);
		if (isCustomerCreated) {
			request.setAttribute("isCustomerCreated", "Creation success");
		}else {
			request.setAttribute("isCustomerCreated", "Creation failure");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/ShowCustomers");
		rd.forward(request, response);
	}

}
