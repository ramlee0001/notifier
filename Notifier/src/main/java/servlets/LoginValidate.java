package servlets;
import java.util.*;
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
import data.Note;
import data.Notification;
import data.Retrivenotes;

/**
 * Servlet implementation class LoginValidate
 */
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String furl="";
		String opt=request.getParameter("option");
		System.out.println(opt);
		if(opt.equals("register"))
			furl="/register.jsp";
		else {
			String user=request.getParameter("uname");
			String pd=request.getParameter("password");
			boolean check=Validate(user,pd);
			if(check) {
				HttpSession session=request.getSession();
			    session.setAttribute("username", user);
			    ArrayList<Note> list=getNotes(user);
			    session.setAttribute("notes", list);
			    System.out.println(list);
				furl="/welcome.jsp";
				Notification not=new Notification();
				not.notifier(user, request, response);
			}			
			else
				furl="/error.jsp";
		}
		request.getRequestDispatcher(furl).forward(request,response);
	}
	
	private boolean Validate(String u,String p) {
		try(Connection con=ConnectionPool.getInstance().getConnection()){
			PreparedStatement stmt=con.prepareStatement("select * from logindetails where username=?");
			stmt.setString(1, u);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				if(rs.getString(2).equals(p))
					return true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	private ArrayList<Note> getNotes(String u){
		Retrivenotes r=new Retrivenotes();
		ArrayList<Note> arr=r.getnotes(u);
		return arr;
	}

}
