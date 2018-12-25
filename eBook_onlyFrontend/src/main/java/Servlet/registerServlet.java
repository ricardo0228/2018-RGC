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

import Utli.ManageUser;

public class registerServlet extends HttpServlet{
	public void reg(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		ManageUser MU = new ManageUser(); 
		Integer userID = MU.addUser(userName, password, email, phone);
		if(userID > 0){
			HttpSession session = request.getSession();
	        session.setAttribute("username",userName);
	        session.setAttribute("userid",userID);
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("register.jsp");
		}
	}
	public void testUser(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String userName = request.getParameter("username");
		ManageUser MU = new ManageUser(); 
		Boolean userExisted = MU.checkUser(userName);
		if(userExisted) response.getWriter().write("true");
		else response.getWriter().write("false");
	}
	public void testPassword(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String password = request.getParameter("password");
		Boolean onlyNumber = false, onlyChar = false;
		onlyNumber = password.matches("^[0-9]+$");
		onlyChar = password.matches("^[a-zA-Z]+$");
		System.out.println(onlyNumber+" "+onlyChar); 
		if(!onlyNumber && !onlyChar) response.getWriter().write("true");
		else response.getWriter().write("false");
	}

    public registerServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("Do Get");
		
		String action = request.getParameter("action");
		System.out.println(action);
		switch(action) {
			case"testUser":
				testUser(request, response);
				break;
			case"testPassword":
				testPassword(request, response);
				break;
		}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("Do Post"); 
		
		reg(request, response);
    }
}