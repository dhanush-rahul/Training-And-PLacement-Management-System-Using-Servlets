package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.LoginBean;
import bean.StudentDetailsBean;
import connection.ConnectionProvider;

public class RegisterDAO {
	Connection connection = ConnectionProvider.getCon();
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	public void addFaculty(LoginBean loginbean) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("insert into login values(?,?,?,?)");
			preparedStatement.setString(1, loginbean.getUsername());
			preparedStatement.setString(2, loginbean.getPassword());
			preparedStatement.setString(3, loginbean.getStream());
			preparedStatement.setString(4, loginbean.getRole());
			preparedStatement.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public void addStudentLogin(StudentDetailsBean studentsBean) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("insert into StudentLogin values(?,?,?,?)");
			preparedStatement.setString(1, studentsBean.getStudentUsername());
			preparedStatement.setString(2, studentsBean.getPassword());
			preparedStatement.setString(3, studentsBean.getStudentId());
			preparedStatement.setString(4, studentsBean.getStream());
			preparedStatement.execute();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void addStudent(StudentDetailsBean studentsBean) throws SQLException {
		// TODO Auto-generated method stub
		try
		{
		preparedStatement = connection.prepareStatement("insert into StudentDetails values(?,?,?,?,?,?)");
		preparedStatement.setString(1, studentsBean.getStudentUsername());
		preparedStatement.setString(2, studentsBean.getStudentId());
		preparedStatement.setString(3, studentsBean.getPassword());
		preparedStatement.setString(4, studentsBean.getStream());
		preparedStatement.setFloat(5, studentsBean.getAvgGpa());
		preparedStatement.setString(6, studentsBean.getCurrentStatus());
		preparedStatement.execute();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
