package Servlet;
import java.io.IOException; 
import javax.servlet.ServletConfig; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Utli.ManageUser;

public class loginServlet implements javax.servlet.Servlet{ 
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		ManageUser MU = new ManageUser();
		Integer userID = MU.login(userName, password);
		if(userID == 0) {
			HttpSession session = request.getSession();
	        session.setAttribute("username",userName);
	        session.setAttribute("userid",userID);
			response.sendRedirect("manager.jsp");
		}
		else if(userID > 0){
			HttpSession session = request.getSession();
	        session.setAttribute("username",userName);
	        session.setAttribute("userid",userID);
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
	}
 
	public void destroy() { 
	}
 
	public ServletConfig getServletConfig() {
		return null;
	}
 
	public String getServletInfo() {
		return null;
	}
 
	public void init(ServletConfig arg0) throws ServletException {  
	}
 
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		HttpServletRequest rq = (HttpServletRequest)request;
		HttpServletResponse rs = (HttpServletResponse) response;
		doPost(rq,rs);
	}
}