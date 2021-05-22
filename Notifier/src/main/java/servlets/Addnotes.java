package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
 * Servlet implementation class Addnotes
 */
public class Addnotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addnotes() {
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
		String furl="";
		String opt=request.getParameter("option");
		if(opt.equals("done")) {
			String title=request.getParameter("title");
			String date=request.getParameter("date");
			String note=request.getParameter("note");
			String user=(String)request.getSession().getAttribute("username");
			addnote(user,title,date,note);
			ArrayList<Note> arr=getNotes(user);
			request.getSession().setAttribute("notes", arr);
			Notification not=new Notification();
			not.notifier(user, request, response);
			request.getRequestDispatcher("/welcome.jsp").forward(request,response);
			
		}
		
	}
	private void addnote(String user,String title,String date, String note) {
		int noteNo=getNoOfNotes(user);
		try(Connection con=ConnectionPool.getInstance().getConnection()){
			PreparedStatement stmt=con.prepareStatement("insert into notes_table values(?,?,?,?,?)");
			stmt.setString(1, user);
			stmt.setInt(2, noteNo+1);
			stmt.setString(4, title);
			stmt.setString(5, date);
			stmt.setString(3, note);
			stmt.executeUpdate();
			increaseNo(user,noteNo+1);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	private int getNoOfNotes(String user) {
		try(Connection con=ConnectionPool.getInstance().getConnection()){
			PreparedStatement stmt=con.prepareStatement("select * from logindetails where username=?");
			stmt.setString(1, user);
			ResultSet rs=stmt.executeQuery();
			rs.next();
			int notes=rs.getInt(4);
			return notes;
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	private void increaseNo(String user,int n) {
		try(Connection con=ConnectionPool.getInstance().getConnection()){
			PreparedStatement stmt=con.prepareStatement("update logindetails set noofnotes=? where username=?");
			stmt.setString(2, user);
			stmt.setInt(1, n);
			stmt.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private ArrayList<Note> getNotes(String u){
		Retrivenotes r=new Retrivenotes();
		ArrayList<Note> arr=r.getnotes(u);
		return arr;
	}

}
