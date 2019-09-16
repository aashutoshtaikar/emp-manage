package com.continuum.crmapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.continuum.crmapp.dao.CustomerDAO;

/**
 * Servlet implementation class DeleteAlienServlet
 */
@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get stuff from html
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		//retrieve data from db correspoding to aid
		CustomerDAO dao = new CustomerDAO();
		boolean isCustomerDeleted = dao.deleteCustomer(cid);
		if (isCustomerDeleted) {
			request.setAttribute("servletmessage", "Updation success");
		}else {
			request.setAttribute("servletmessage", "Updation failure");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/ShowCustomers");
		rd.forward(request, response);
	}

}
