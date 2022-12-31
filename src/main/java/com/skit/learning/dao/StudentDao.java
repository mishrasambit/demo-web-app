package com.skit.learning.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skit.learning.model.Student;
import com.skit.learning.util.DBUtil;

public class StudentDao {
	
	public void save(Student st) {
		Statement statement = DBUtil.getStatement();
		String query = "INSERT INTO STUDENT values ("+st.getId()+", '"+st.getName()+"', '"+st.getEmail()+"', '"+st.getCourse()+"', '"+st.getCity()+"')";
		
			try {
				int rows = statement.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<>();
		Statement statement = DBUtil.getStatement();
		String query = "SELECT * FROM STUDENT";
		try {
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String course = rs.getString(4);
				String city = rs.getString(5);
				System.out.println(id+", "+name+", "+email+", "+course+", "+city);
				
				//Student student = new Student(id, name, email, course, city);
				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setEmail(email);
				student.setCourse(course);
				student.setCity(city);
				students.add(student);
			}
			
			//DBUtil.closeConnection(null, statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
		
	}

}
