package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Notification {
	public void notifier(String user, HttpServletRequest request, HttpServletResponse response){
		String todate=LocalDate.now().toString();
		ArrayList<Note> arr=new ArrayList<Note>();
		try(Connection con=ConnectionPool.getInstance().getConnection()){
			PreparedStatement stmt=con.prepareStatement("select * from notes_table where user=? and date=?");
			stmt.setString(1, user);
			stmt.setString(2, todate);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				arr.add(new Note(rs.getInt(2),rs.getString(4),rs.getString(3),rs.getString(5)));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		request.getSession().setAttribute("today", arr);
	}

}
