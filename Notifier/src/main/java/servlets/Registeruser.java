package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.ConnectionPool;

/**
 * Servlet implementation class Registeruser
 */
public class Registeruser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registeruser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String user=request.getParameter("uname");
				String pd=request.getParameter("password");
				String cpd=request.getParameter("confirmpassword");
				String mblno=request.getParameter("mobileno");
				if(pd.equals(cpd) && !Validate(user) && !pd.equals("") && !user.equals("")) {
				adduser(user,pd,mblno);
				request.getRequestDispatcher("/login.jsp").forward(request, response);}
				else {
					if(Validate(user)) {request.getRequestDispatcher("/userexists.jsp").forward(request, response);}
					else if(!pd.equals(cpd)) {request.getRequestDispatcher("/nopasswordmatch.jsp").forward(request, response);}
					
					
					}
				
	}
	private boolean Validate(String u) {
		try(Connection con=ConnectionPool.getInstance().getConnection()){
			PreparedStatement stmt=con.prepareStatement("select * from logindetails where username=?");
			stmt.setString(1, u);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
					return true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	private void adduser(String u,String pd,String mblno) {
		try(Connection con=ConnectionPool.getInstance().getConnection()){
			PreparedStatement stmt=con.prepareStatement("insert into logindetails values(?,?,?,?)");
			stmt.setString(1, u);
			stmt.setString(2, pd);
			stmt.setString(3, mblno);
			stmt.setInt(4, 0);
			stmt.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}


}
