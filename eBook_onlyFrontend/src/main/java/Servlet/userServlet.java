package Servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.User;
import Utli.ManageUser;

public class userServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void updateUser(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		ManageUser MU = new ManageUser(); 
		MU.updateUser(userID, password, email, phone);
		response.sendRedirect("information.jsp");
	}
	public void getUserName(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userid");
		ManageUser MU = new ManageUser(); 
		User user = MU.getUser(userID);
		System.out.println(userID); 
		response.getWriter().write(user.getName());
	}
	public void getPassword(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userid");
		ManageUser MU = new ManageUser(); 
		User user = MU.getUser(userID);
		System.out.println(userID); 
		response.getWriter().write(user.getPassword());
	}
	public void getEmail(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userid");
		ManageUser MU = new ManageUser(); 
		User user = MU.getUser(userID);
		System.out.println(userID); 
		response.getWriter().write(user.getEmail());
	}
	public void getPhone(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userid");
		ManageUser MU = new ManageUser(); 
		User user = MU.getUser(userID);
		System.out.println(userID); 
		response.getWriter().write(user.getPhone());
	}
	public void deleteUser(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		Integer userID = Integer.valueOf(request.getParameter("userid"));
		ManageUser MU = new ManageUser(); 
		MU.deleteUser(userID);
		System.out.println(userID); 
		response.sendRedirect("manager?action=list");
	}

    public userServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("Do Get");
		
		String action = request.getParameter("action");
		System.out.println(action);
		switch(action) {
			case"getUserName":
				getUserName(request, response);
				break;
			case"getPassword":
				getPassword(request, response);
				break;
			case"getEmail":
				getEmail(request, response);
				break;
			case"getPhone":
				getPhone(request, response);
				break;
			case"deleteUser":
				deleteUser(request, response);
				break;
			case"frezenUser":
				break;
		}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("Do Post"); 
		
		updateUser(request, response);
    }
}
