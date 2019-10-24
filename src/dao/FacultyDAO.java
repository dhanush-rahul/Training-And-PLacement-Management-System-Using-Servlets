package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DiscussionsBean;
import bean.LoginBean;
import bean.PlacedStudentsBean;
import bean.StudentDetailsBean;
import connection.ConnectionProvider;

public class FacultyDAO {

	Connection connection = ConnectionProvider.getCon();
	PreparedStatement preparedStatement;
	
	public ArrayList<StudentDetailsBean> getStudents(LoginBean loginBean) {
		// TODO Auto-generated method stub
		try {
			ArrayList<StudentDetailsBean> students = new ArrayList<>();
			preparedStatement = connection.prepareStatement("select * from StudentDetails where Stream=?");
			preparedStatement.setString(1, loginBean.getStream());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				StudentDetailsBean studentBean = new StudentDetailsBean();
				studentBean.setStudentUsername(resultSet.getString(1));
				studentBean.setStudentId(resultSet.getString(2));
				studentBean.setPassword(resultSet.getString(3));
				studentBean.setStream(resultSet.getString(4));
				studentBean.setAvgGpa(resultSet.getFloat(5));
				studentBean.setCurrentStatus(resultSet.getString(6));
				students.add(studentBean);
			}
			return students;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public ArrayList<PlacedStudentsBean> getPlacedStudents(LoginBean loginBean) {
		// TODO Auto-generated method stub
		try {
			ArrayList<PlacedStudentsBean> students = new ArrayList<>();
			preparedStatement = connection.prepareStatement("select * from PlacedStudents where Stream=?");
			preparedStatement.setString(1, loginBean.getStream());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				PlacedStudentsBean studentBean = new PlacedStudentsBean();
				studentBean.setStudentUsername(resultSet.getString(1));
				studentBean.setStudentId(resultSet.getString(2));
				studentBean.setStream(resultSet.getString(3));
				studentBean.setGpa(resultSet.getFloat(4));
				studentBean.setCompanyName(resultSet.getString(5));
				studentBean.setRole(resultSet.getString(6));
				
				students.add(studentBean);
			}
			return students;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void editStudent(StudentDetailsBean student) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("update StudentDetails set StudentId=?,AvgGPA=?,CurrentStatus=? where StudentUsername=?");
			preparedStatement.setString(1, student.getStudentId());
			preparedStatement.setFloat(2, student.getAvgGpa());
			preparedStatement.setString(3, student.getCurrentStatus());
			preparedStatement.setString(4, student.getStudentUsername());
			preparedStatement.execute();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void insertPlaced(PlacedStudentsBean placed) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("insert into PlacedStudents values(?,?,?,?,?,?)");
			preparedStatement.setString(1, placed.getStudentUsername());
			preparedStatement.setString(2, placed.getStudentId());
			preparedStatement.setString(3, placed.getStream());
			preparedStatement.setFloat(4, placed.getGpa());
			preparedStatement.setString(5, placed.getCompanyName());
			preparedStatement.setString(6, placed.getRole());
			preparedStatement.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public StudentDetailsBean getParticularStudent(StudentDetailsBean student) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("select * from StudentDetails where StudentUsername=?");
			preparedStatement.setString(1, student.getStudentUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			StudentDetailsBean student1 = new StudentDetailsBean();
			student1.setStudentUsername(resultSet.getString(1));
			student1.setStudentId(resultSet.getString(2));
			student1.setPassword(resultSet.getString(3));
			student1.setStream(resultSet.getString(4));
			student1.setAvgGpa(resultSet.getFloat(5));
			student1.setCurrentStatus(resultSet.getString(6));
			return student1;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	public void postActivity(DiscussionsBean discussions) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("insert into Discussions values(?,?)");
			preparedStatement.setString(1, discussions.getFaculty());
			preparedStatement.setString(2, discussions.getActivity());
			preparedStatement.execute();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	

}
