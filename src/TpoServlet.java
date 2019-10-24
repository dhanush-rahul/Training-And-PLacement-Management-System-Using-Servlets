

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DiscussionsBean;
import bean.DrivesBean;
import bean.LoginBean;
import bean.PlacedStudentsBean;
import bean.StudentComplaints;
import bean.StudentDetailsBean;
import dao.TpoDao;

/**
 * Servlet implementation class TpoServlet
 */
@WebServlet("/TpoServlet")
public class TpoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TpoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		RequestDispatcher requestDispatcher;
		LoginBean loginbean = new LoginBean();
		TpoDao tpoDao = new TpoDao();
		
		if(request.getParameter("varname").equals("ViewUpDrives"))
		{
			ArrayList<DrivesBean> upDrives = new ArrayList<DrivesBean>();
			upDrives = tpoDao.getUpDrives();
			requestDispatcher = request.getRequestDispatcher("viewDrives.jsp");
			request.setAttribute("Drives",upDrives);
			requestDispatcher.forward(request, response);
		}
		else if(request.getParameter("varname").equals("ViewAllDrives"))
		{
			ArrayList<DrivesBean> drives = new ArrayList<DrivesBean>();
			drives = tpoDao.getAllDrives();
			requestDispatcher = request.getRequestDispatcher("viewDrives.jsp");
			request.setAttribute("Drives",drives);
			requestDispatcher.forward(request, response);
		}
		else if(request.getParameter("varname").equals("ViewStudents"))
		{
			ArrayList<StudentDetailsBean> students = new ArrayList<StudentDetailsBean>();
			students = tpoDao.getAllStudents();
			System.out.println(students);
			request.setAttribute("students", students);
			requestDispatcher = request.getRequestDispatcher("viewStudentsTpo.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(request.getParameter("varname").equals("ViewPlaced"))
		{
			ArrayList<PlacedStudentsBean> students = new ArrayList<PlacedStudentsBean>();
			students = tpoDao.getPlacedStudents();
			requestDispatcher = request.getRequestDispatcher("viewPlacedStudents.jsp");
			request.setAttribute("students", students);
			requestDispatcher.forward(request, response);
		}
		else if(request.getParameter("varname").equals("scheduleDrive"))
		{
			DrivesBean drivesBean = new DrivesBean();
			drivesBean.setCompanyName(request.getParameter("companyName"));
			drivesBean.setContract(Integer.parseInt(request.getParameter("contract")));
			drivesBean.setEligibility(request.getParameter("eligibility"));
			drivesBean.setPay(Integer.parseInt(request.getParameter("pay")));
			drivesBean.setRole(request.getParameter("role"));
			drivesBean.setScheduleDate(request.getParameter("scheduleDate"));
			drivesBean.setState(request.getParameter("state"));
			drivesBean.setTypeOfJob(request.getParameter("typeOfJob"));
			drivesBean.setStream(request.getParameter("stream"));
			tpoDao.scheduleDrive(drivesBean);
			requestDispatcher = request.getRequestDispatcher("tpo.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(request.getParameter("varname").equals("PostActivities"))
		{
			DiscussionsBean discussion = new DiscussionsBean();
			discussion.setFaculty("Tpo");
			discussion.setActivity(request.getParameter("activity"));
			tpoDao.postActivity(discussion);
		}
		else if(request.getParameter("varname").equals("ViewComplaints"))
		{
			ArrayList<StudentComplaints> complaints = new ArrayList<>();
			complaints = tpoDao.getComplaints();
			System.out.println(complaints);
			request.setAttribute("complaints", complaints);
			requestDispatcher = request.getRequestDispatcher("viewComplaints.jsp");
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
