

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
import bean.StudentDetailsBean;
import dao.LoginDAO;

/**
 * Servlet implementation class BlahServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		RequestDispatcher requestDispatcher;
		LoginBean loginBean = new LoginBean();
		LoginDAO logindao = new LoginDAO();
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		if(request.getParameter("operation").equals("FacultyLogin"))
		{
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		loginBean.setUsername(request.getParameter("username"));
		loginBean.setPassword(request.getParameter("password"));
		String role=null;
	    
	        LoginBean loginBean1 = null;
	        loginBean1 = logindao.getLogin(loginBean);
	        	
	        if(loginBean1==(null))
	        {
				requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			}
					if(loginBean1.getRole().equals("Faculty") || loginBean1.getRole().equals("HOD"))
					{
						session.setAttribute("login", loginBean1);
						requestDispatcher = request.getRequestDispatcher("faculty.jsp");
						requestDispatcher.forward(request, response);
					}
					else if(loginBean1.getRole().equals("Tpo"))
					{
						requestDispatcher = request.getRequestDispatcher("tpo.jsp"); 
						requestDispatcher.forward(request, response);
					}
					else {
						requestDispatcher = request.getRequestDispatcher("login.jsp");
						requestDispatcher.forward(request, response);
					}
		}   
		else if(request.getParameter("operation").equals("StudentLogin"))
		{
			loginBean.setUsername(request.getParameter("username"));
			loginBean.setPassword(request.getParameter("password"));
			if(logindao.validateStudent(loginBean))
			{
				StudentDetailsBean student =(StudentDetailsBean) logindao.getStudentDetails(loginBean);
				session.setAttribute("student", student);
				ArrayList<DiscussionsBean> discussions = new ArrayList<DiscussionsBean>();
				discussions = logindao.getDiscussions();
				session.setAttribute("discussions", discussions);
				requestDispatcher = request.getRequestDispatcher("student.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
				requestDispatcher = request.getRequestDispatcher("studentLogin.jsp");
				requestDispatcher.forward(request, response);
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
