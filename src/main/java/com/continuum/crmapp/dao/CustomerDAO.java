package com.continuum.crmapp.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


import com.continuum.crmapp.model.Customer;

public class CustomerDAO {

	private Connection con = null;
	
	public CustomerDAO() {
		DBConnection dbCon = DBConnection.INSTANCE;
		con = dbCon.getConnection();
	}

	public boolean createCustomer(int cid, String cfname, String clname, String email) {
		boolean isCustomerCreated = false;

		try {
			PreparedStatement pst = con.prepareStatement("INSERT INTO customer VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE cfname=?,clname=?,email=?");
			pst.setInt(1, cid);
			pst.setString(2, cfname);
			pst.setString(3, clname);
			pst.setString(4, email);
		
			pst.setString(5, cfname);
			pst.setString(6, clname);
			pst.setString(7, email);
			
			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				isCustomerCreated = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCustomerCreated;
	}

	public Customer getCustomer(int cid) {
		Customer c = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from customer where cid =" + cid);
			if (rs.next()) {
				c = new Customer();
				c.setCid(rs.getInt("cid"));
				c.setCfname(rs.getString("cfname"));
				c.setClname(rs.getString("clname"));
				c.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from customer");
			while (rs.next()) {
				Customer c = new Customer();
				c.setCid(rs.getInt("cid"));
				c.setCfname(rs.getString("cfname"));
				c.setClname(rs.getString("clname"));
				c.setEmail(rs.getString("email"));
				customers.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customers;
	}


	public boolean deleteCustomer(int cid) {
		boolean isCustomerDeleted = false;
		try {
			Statement pst = con.createStatement();
			int rowsAffected = pst.executeUpdate("DELETE from customer WHERE cid=" + cid);

			if (rowsAffected > 0) {
				isCustomerDeleted = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isCustomerDeleted;
	}
	
	public List<Customer> searchCustomers(String theSearchName) throws SQLException{
		List<Customer> customers = new ArrayList<Customer>();
		
		StringTokenizer st = new StringTokenizer(theSearchName, " ");
		List<String> fullName = new ArrayList<String>();
		while (st.hasMoreElements()) {
			fullName.add((String)st.nextElement());
		}
		PreparedStatement pst = null;
		if (theSearchName!=null && theSearchName.length()>0) {
			//for searching first name only
			if(fullName.size()==1) {
				pst = con.prepareStatement("SELECT * from customer WHERE lower(cfname) like ? or lower(clname) like ?");
				pst.setString(1, "%" + theSearchName.trim().toLowerCase() + "%");
				pst.setString(2, "%" + theSearchName.trim().toLowerCase() + "%");
			}
			//for searching firstname lastname
			else if(fullName.size()==2){
				pst = con.prepareStatement("SELECT * from Customer where lower(cfname) like ? and lower(clname) like ?");
				pst.setString(1, "%" + fullName.get(0).toLowerCase()  + "%");
				pst.setString(2, "%" + fullName.get(1).toLowerCase()  + "%");
			}
			//for searching firstname (middlename) lastname
			else if (fullName.size()>2) {
				pst = con.prepareStatement("SELECT * from Customer where lower(cfname) like ? and lower(clname) like ?");
				pst.setString(1, "%" + fullName.get(0).toLowerCase()  + "%");
				pst.setString(2, "%" + fullName.get(2).toLowerCase()  + "%");
			}
		}else {
			pst = con.prepareStatement("SELECT * FROM customer");
		}
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Customer c = new Customer();
			c.setCid(rs.getInt("cid"));
			c.setCfname(rs.getString("cfname"));
			c.setClname(rs.getString("clname"));
			c.setEmail(rs.getString("email"));
			customers.add(c);
		}
		
		return customers;
	}

}
