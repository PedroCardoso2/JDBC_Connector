package propets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class add implements forms{

	@Override
	public void insertInfo() {
		Connection conn = null;
		Statement st = null;
		ResultSet rt =  null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			rt = st.executeQuery("select * from department");
			
			while(rt.next()) {
				System.out.println(rt.getInt("Id") + " , " + rt.getString("Name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeConnection();
			DB.closeStatement(st);
			DB.closeResultSet(rt);
		}
		
	}

	@Override
	public void deleteInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"INSERT INTO seller " 
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			
			st.setString(1, "Carl Purple");
			st.setString(2, "carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);
			
			int rows = st.executeUpdate();
			
			if(rows > 0) {
				ResultSet rt = st.getGeneratedKeys();
				while(rt.next()) {
					
				}
			}else {
				System.out.println("No rows affected!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateInfo() {
		
		
	}

	@Override
	public void selectInfo() {
		
		
	}
	
}
