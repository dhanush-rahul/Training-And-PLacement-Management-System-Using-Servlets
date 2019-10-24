package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DiscussionsBean;
import bean.DrivesBean;
import bean.LoginBean;
import bean.PlacedStudentsBean;
import bean.StudentComplaints;
import bean.StudentDetailsBean;
import connection.ConnectionProvider;

public class TpoDao {

	Connection connection = ConnectionProvider.getCon();
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	
	public ArrayList<DrivesBean> getUpDrives() {
		// TODO Auto-generated method stub
		ArrayList<DrivesBean> upDrives = new ArrayList<DrivesBean>();
		try {
			preparedStatement = connection.prepareStatement("select * from CompanyDetails where CurrentStatus=?");
			preparedStatement.setString(1,"Upcoming");
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
				upDrives.add(drivesBean);
			}
			return upDrives;
		} catch (Exception e) {

			System.out.println(e);
		}
		return null;
	}

	public ArrayList<DrivesBean> getAllDrives() {
		// TODO Auto-generated method stub
		ArrayList<DrivesBean> drives = new ArrayList<DrivesBean>();
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

	public ArrayList<StudentDetailsBean> getAllStudents() {
		// TODO Auto-generated method stub
		ArrayList<StudentDetailsBean> students = new ArrayList<StudentDetailsBean>();
		try {
			preparedStatement = connection.prepareStatement("select * from StudentDetails");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				StudentDetailsBean studentDetails = new StudentDetailsBean();
				
				studentDetails.setStudentUsername(resultSet.getString(1));
				studentDetails.setStudentId(resultSet.getString(2));
				studentDetails.setStream(resultSet.getString(4));
				
				studentDetails.setAvgGpa(resultSet.getFloat(5));
				studentDetails.setCurrentStatus(resultSet.getString(6));
				System.out.println(studentDetails);
				students.add(studentDetails);
			}
			System.out.println(students);
			return students;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<PlacedStudentsBean> getPlacedStudents() {
		// TODO Auto-generated method stub
		ArrayList<PlacedStudentsBean> students = new ArrayList<PlacedStudentsBean>();
		try {
			preparedStatement = connection.prepareStatement("select * from PlacedStudents");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PlacedStudentsBean studentDetails = new PlacedStudentsBean();
				studentDetails.setStudentUsername(resultSet.getString(1));
				studentDetails.setStudentId(resultSet.getString(2));
				studentDetails.setStream(resultSet.getString(3));
				studentDetails.setGpa(resultSet.getFloat(4));
				studentDetails.setCompanyName(resultSet.getString(5));
				studentDetails.setRole(resultSet.getString(6));
				students.add(studentDetails);
			}
			return students;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void scheduleDrive(DrivesBean drivesBean) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("insert into CompanyDetails values(?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, drivesBean.getCompanyName());
			preparedStatement.setString(2, drivesBean.getStream());
			preparedStatement.setString(3, drivesBean.getEligibility());
			preparedStatement.setString(4, drivesBean.getRole());
			preparedStatement.setInt(5, drivesBean.getPay());
			preparedStatement.setInt(6, drivesBean.getContract());
			preparedStatement.setString(7, drivesBean.getTypeOfJob());
			preparedStatement.setString(8, drivesBean.getScheduleDate());
			preparedStatement.setString(9, drivesBean.getState());
			preparedStatement.setString(10, "Upcoming");
			preparedStatement.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void postActivity(DiscussionsBean discussion) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("insert into Discussions values(?,?)");
			preparedStatement.setString(1, discussion.getFaculty());
			preparedStatement.setString(2, discussion.getActivity());
			preparedStatement.execute();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public ArrayList<StudentComplaints> getComplaints() {
		// TODO Auto-generated method stub
		try {
			ArrayList<StudentComplaints> complaints = new ArrayList<>();
			preparedStatement = connection.prepareStatement("select * from StudentComplaints");
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next())
			{
				StudentComplaints complaint = new StudentComplaints();
				complaint.setStudentId(resultset.getString(1));
				complaint.setStream(resultset.getString(2));
				complaint.setComplaint(resultset.getString(3));
				complaints.add(complaint);
			}
			return complaints;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
