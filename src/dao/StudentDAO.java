package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DrivesBean;
import bean.PlacedStudentsBean;
import bean.StudentComplaints;
import bean.StudentDetailsBean;
import connection.ConnectionProvider;

public class StudentDAO {


Connection connection = ConnectionProvider.getCon();
PreparedStatement preparedStatement;
public ArrayList<DrivesBean> getAllDrives() {
	// TODO Auto-generated method stub
	ArrayList<DrivesBean> drives = new ArrayList<DrivesBean>();
	ResultSet resultSet;
	try {
		preparedStatement = connection.prepareStatement("select * from CompanyDetails");
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			DrivesBean drivesBean = new DrivesBean();
			drivesBean.setCompanyName(resultSet.getString(1));
			drivesBean.setStream(resultSet.getString(2));
			drivesBean.setEligibility(resultSet.getString(3));
			drivesBean.setRole(resultSet.getString(4));
			drivesBean.setPay(resultSet.getInt(5));
			drivesBean.setContract(resultSet.getInt(6));
			drivesBean.setTypeOfJob(resultSet.getString(7));
			drivesBean.setScheduleDate(resultSet.getString(8));
			drivesBean.setState(resultSet.getString(9));
			drivesBean.setCurrentStatus(resultSet.getString(10));
			drives.add(drivesBean);
		}
		return drives;
	} catch (Exception e) {

		System.out.println(e);
	}
	return null;
}
public StudentDetailsBean getStudent(StudentDetailsBean student) {
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
public void raiseComplaint(StudentComplaints complaint) {
	// TODO Auto-generated method stub
	try {
		preparedStatement = connection.prepareStatement("insert into StudentComplaints values(?,?,?)");
		preparedStatement.setString(1, complaint.getStudentId());
		preparedStatement.setString(2, complaint.getStream());
		preparedStatement.setString(3, complaint.getComplaint());
		preparedStatement.execute();
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
public void deletePlaced(StudentDetailsBean student1) {
	// TODO Auto-generated method stub
	try {
		preparedStatement = connection.prepareStatement("select * from PlacedStudents where StudentUsername=?");
		preparedStatement.setString(1, student1.getStudentUsername());
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		if(resultSet.getString(1).equals(student1.getStudentUsername()))
		{
			preparedStatement = connection.prepareStatement("delete from PlacedStudents where StudentUsername=?");
			preparedStatement.setString(1, student1.getStudentUsername());
			preparedStatement.execute();
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
}


}
