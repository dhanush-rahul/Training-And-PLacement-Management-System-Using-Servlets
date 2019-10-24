

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DiscussionsBean;
import bean.LoginBean;
import bean.PlacedStudentsBean;
import bean.StudentDetailsBean;
import dao.FacultyDAO;

/**
 * Servlet implementation class FacultyServlet
 */
@WebServlet("/FacultyServlet")
public class FacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		LoginBean loginBean = (LoginBean)session.getAttribute("login");
		FacultyDAO facultyDao = new FacultyDAO();
		RequestDispatcher requestDispatch;
		if(request.getParameter("operation").equals("viewStudents"))
		{
			ArrayList<StudentDetailsBean> students = new ArrayList<>();
			students = facultyDao.getStudents(loginBean);
			request.setAttribute("students", students);
			requestDispatch = request.getRequestDispatcher("viewStudents.jsp");
			requestDispatch.forward(request, response);
		}
	
		else if(request.getParameter("operation").equals("viewPlaced"))
		{
			ArrayList<PlacedStudentsBean> students = new ArrayList<>();
			students = facultyDao.getPlacedStudents(loginBean);
			request.setAttribute("students", students);
			requestDispatch = request.getRequestDispatcher("viewPlacedStudents.jsp");
			requestDispatch.forward(request, response);
		}
		else if(request.getParameter("operation").equals("ActivitiesHOD"))
		{
			if(loginBean.getRole().equals("HOD"))
			{
				requestDispatch = request.getRequestDispatcher("Activities.jsp");
				requestDispatch.forward(request, response);
			}
			else
			{
				out.println("Only HOD can post Academic Activities");
			}
		}
		else if(request.getParameter("operation").equals("HODActivities"))
		{
			DiscussionsBean discussions = new DiscussionsBean();
			discussions.setFaculty(loginBean.getRole());
			discussions.setActivity(request.getParameter("activity"));
			facultyDao.postActivity(discussions);
			requestDispatch = request.getRequestDispatcher("faculty.jsp");
			requestDispatch.forward(request, response);
		}
		else if(request.getParameter("operation").equals("Logout"))
		{
			session.removeAttribute("login");
			requestDispatch = request.getRequestDispatcher("Logout.jsp");
			requestDispatch.forward(request, response);
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
