package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.ConnectionPool;

/**
 * Servlet implementation class Edituservalidate
 */
public class Edituservalidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edituservalidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opt = request.getParameter("option");
		System.out.println(opt);
		if (opt.equals("update")) {
			String username = request.getParameter("uname");
			String mblno = request.getParameter("mobilenumber");
			String newpassword = request.getParameter("newpassword");
			System.out.println("reached");
			if (Validate(username,mblno,newpassword)) {
				request.getRequestDispatcher("/welcome.jsp").forward(request, response);
			} 
			else {
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}
	}
	private boolean Validate(String username, String mblno, String password) {
		try(Connection con=ConnectionPool.getInstance().getConnection()){
			PreparedStatement stmt=con.prepareStatement("update logindetails set password=? , mobile=? where username=?");
			stmt.setString(1, password);
			stmt.setString(2, mblno);
			stmt.setString(3, username);
			int i=stmt.executeUpdate();
			if(i==0){return false;}
			else return true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
