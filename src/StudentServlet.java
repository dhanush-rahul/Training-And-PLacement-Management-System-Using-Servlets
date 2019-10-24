

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DrivesBean;
import bean.LoginBean;
import bean.PlacedStudentsBean;
import bean.StudentComplaints;
import bean.StudentDetailsBean;
import dao.StudentDAO;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher requestDispatcher;
		StudentDAO studentDao = new StudentDAO();
		HttpSession session = request.getSession();
		StudentDetailsBean student =(StudentDetailsBean) session.getAttribute("student");
		System.out.println(student);
		if(request.getParameter("operation").equals("ViewDrives"))
		{
			ArrayList<DrivesBean> drives = new ArrayList<DrivesBean>();
			drives = studentDao.getAllDrives();
			requestDispatcher = request.getRequestDispatcher("viewDrives.jsp");
			request.setAttribute("Drives",drives);
			requestDispatcher.forward(request, response);
		}
		else if(request.getParameter("operation").equals("UpdateDetails"))
		{
			StudentDetailsBean studentDetails = new StudentDetailsBean();
			studentDetails = studentDao.getStudent(student);
			requestDispatcher = request.getRequestDispatcher("EditParticularStudent.jsp");
			request.setAttribute("student", studentDetails);
			requestDispatcher.forward(request, response);
		}
		else if(request.getParameter("operation").equals("UpdateProfile"))
		{
			StudentDetailsBean student1 = new StudentDetailsBean();
			student1.setStudentUsername(request.getParameter("username"));
			student1.setStudentId(request.getParameter("id"));
			student1.setAvgGpa(Float.parseFloat(request.getParameter("gpa")));
			student1.setCurrentStatus(request.getParameter("status"));
			student1.setStream(request.getParameter("stream"));
			System.out.println(student1);
			studentDao.editStudent(student1);
			
			if(student1.getCurrentStatus().equals("Placed")) {
				request.setAttribute("student", student1);
				requestDispatcher = request.getRequestDispatcher("PlaceStudentDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if(student1.getCurrentStatus().equals("Not-Placed"))
			{
				studentDao.deletePlaced(student1);
				requestDispatcher = request.getRequestDispatcher("student.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		else if(request.getParameter("operation").equals("InsertIntoPlaced"))
		{
			PlacedStudentsBean placed = new PlacedStudentsBean();
			placed.setCompanyName(request.getParameter("company"));
			placed.setGpa(Float.parseFloat(request.getParameter("gpa")));
			placed.setRole(request.getParameter("role"));
			placed.setStream(request.getParameter("stream"));
			placed.setStudentId(request.getParameter("id"));
			placed.setStudentUsername(request.getParameter("username"));
			studentDao.insertPlaced(placed);
			requestDispatcher = request.getRequestDispatcher("student.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(request.getParameter("operation").equals("Complaint"))
		{
			StudentComplaints complaint = new StudentComplaints();
			complaint.setStudentId(request.getParameter("id"));
			complaint.setComplaint(request.getParameter("complaint"));
			complaint.setStream(request.getParameter("stream"));
			studentDao.raiseComplaint(complaint);
			requestDispatcher = request.getRequestDispatcher("student.jsp");
			requestDispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
