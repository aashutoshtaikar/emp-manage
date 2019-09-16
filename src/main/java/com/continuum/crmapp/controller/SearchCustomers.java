package com.continuum.crmapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.continuum.crmapp.dao.CustomerDAO;
import com.continuum.crmapp.model.Customer;


@WebServlet("/SearchCustomers")
public class SearchCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theSearchName = request.getParameter("theSearchName");
		CustomerDAO dao = new CustomerDAO();
		List<Customer> customers = null;
		try {
			customers = dao.searchCustomers(theSearchName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("customers", customers);
		RequestDispatcher rd = request.getRequestDispatcher("list-customers.jsp");
		rd.forward(request, response);
	}

}
