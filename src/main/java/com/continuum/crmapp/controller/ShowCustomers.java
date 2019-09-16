package com.continuum.crmapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.continuum.crmapp.dao.CustomerDAO;
import com.continuum.crmapp.model.Customer;

/**
 * Servlet implementation class ListAllAliensServlet
 */
@WebServlet("/ShowCustomers")
public class ShowCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDAO dao = new CustomerDAO();
		List<Customer> customers = dao.getCustomers();
		if (customers==null) {
			request.setAttribute("servletmessage", "customers not found");
		}
		request.setAttribute("customers", customers);
		RequestDispatcher rd = request.getRequestDispatcher("list-customers.jsp");
		rd.forward(request, response);
	}

}
