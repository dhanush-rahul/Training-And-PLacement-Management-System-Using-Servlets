package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.DiscussionsBean;
import bean.LoginBean;
import bean.StudentDetailsBean;
import connection.ConnectionProvider;

public class LoginDAO {
	Connection connection = ConnectionProvider.getCon();
	PreparedStatement preparedStatement;
	
	public String validate(LoginBean loginBean) throws SQLException {
		
		try {
			preparedStatement = connection.prepareStatement("select Role from login where AdminUsername=? and AdminPassword=?");
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2,loginBean.getPassword());
			ResultSet resultset = preparedStatement.executeQuery();
			resultset.next();
			return resultset.getString(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}

	public String getStream(LoginBean loginBean) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("select Stream from login where AdminUsername=?");
			preparedStatement.setString(1, loginBean.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			return resultSet.getString(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	public boolean validateStudent(LoginBean loginBean) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("select * from StudentLogin where StudentUsername=? and StudentPassword=?");
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());
			ResultSet resultset = preparedStatement.executeQuery();
			resultset.next();
			if(resultset.wasNull())
			return false;
			return true;
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	public StudentDetailsBean getStudentDetails(LoginBean loginBean) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("select * from StudentDetails where StudentUsername=?");
			preparedStatement.setString(1, loginBean.getUsername());
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

	public LoginBean getLogin(LoginBean loginBean) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement("select * from login where AdminUsername=? and AdminPassword=?");
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2,loginBean.getPassword());
			ResultSet resultset = preparedStatement.executeQuery();
			resultset.next();
			if(resultset.wasNull())
				return null;
			LoginBean loginBean1 = new LoginBean();
			loginBean1.setUsername(resultset.getString(1));
			loginBean1.setPassword(resultset.getString(2));
			loginBean1.setStream(resultset.getString(3));
			loginBean1.setRole(resultset.getString(4));
			return loginBean1;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public ArrayList<DiscussionsBean> getDiscussions() {
		// TODO Auto-generated method stub
		try {
			ArrayList<DiscussionsBean> discussions = new ArrayList<>();
			preparedStatement = connection.prepareStatement("select * from Discussions");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				DiscussionsBean discussion = new DiscussionsBean();
				discussion.setFaculty(resultSet.getString(1));
				discussion.setActivity(resultSet.getString(2));
				discussions.add(discussion);
			}
			return discussions;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

}
