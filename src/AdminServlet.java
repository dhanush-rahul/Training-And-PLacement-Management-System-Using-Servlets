

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoginBean;
import bean.StudentDetailsBean;
import dao.RegisterDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RegisterDAO registerDao = new RegisterDAO();
		PrintWriter out = response.getWriter();
		if(request.getParameter("operation").equals("FacultyRegister"))
		{
			LoginBean loginBean = new LoginBean();
			loginBean.setUsername(request.getParameter("username"));
			loginBean.setPassword(request.getParameter("password"));
			loginBean.setStream(request.getParameter("stream"));
			loginBean.setRole(request.getParameter("role"));
			registerDao.addFaculty(loginBean);
			out.println("alert(Faculty Added!)");
		}
		if(request.getParameter("operation").equals("StudentRegister"))
		{
			StudentDetailsBean studentsBean = new StudentDetailsBean();
			studentsBean.setStudentUsername(request.getParameter("username"));
			studentsBean.setPassword(request.getParameter("password"));
			studentsBean.setStudentId(request.getParameter("studentId"));
			studentsBean.setStream(request.getParameter("stream"));
			
			float sum = Float.parseFloat(request.getParameter("one-one"))
					+Float.parseFloat(request.getParameter("one-two"))
					+Float.parseFloat(request.getParameter("two-one"))
					+Float.parseFloat(request.getParameter("two-two"))
					+Float.parseFloat(request.getParameter("three-one"))
					+Float.parseFloat(request.getParameter("three-two"));
			studentsBean.setAvgGpa(sum/6);
			studentsBean.setCurrentStatus(request.getParameter("status"));
			try {
				registerDao.addStudent(studentsBean);
				registerDao.addStudentLogin(studentsBean);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
