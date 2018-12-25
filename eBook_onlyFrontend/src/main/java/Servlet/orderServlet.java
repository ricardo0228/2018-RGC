package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Book;
import Utli.ManageBook;
import Utli.ManageOrder;
import Utli.ManageUser;
 
public class orderServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;

    public orderServlet() {
        super();
    }
    protected void getTmpOrder(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<String> tmporder;
	    if(session.getAttribute("tmporder")==null) {
	    	tmporder = new ArrayList<>();
	    }
	    else {
	    	tmporder = (List<String>) session.getAttribute("tmporder");
	    }
    	Set<String> itemlist = new HashSet<>(tmporder);
    	
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	
            out.println("<html>");
            out.println("<head>");
            out.println("<title>tmpOrder List</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"files/CSS/tmporder.css\"/>");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<table class = \"tbstyle\">");
            
            out.println("<tr><td class = \"authorstyle\">作者</td>");
            out.println("<td class = \"namestyle\">书名</td>");
            out.println("<td class = \"pricestyle\">单价</td>");
            out.println("<td class = \"numstyle\">数量</td>");
            out.println("<td class = \"sumstyle\">总额</td></tr>");
            
            ManageBook MB = new ManageBook();
            Float sum = 0F;
			for (String temp : itemlist){
				Book book = MB.getBook(Integer.valueOf(temp));
				Integer num = Collections.frequency(tmporder, temp);
	            out.println("<tr><td class = \"authorstyle\">" + book.getAuthor() + "</td>");
	            out.println("<td class = \"namestyle\">" + book.getName() + "</td>");
	            out.println("<td class = \"pricestyle\">" + book.getPrice() + "</td>");
	            out.println("<td class = \"numstyle\">" + num + "</td>");
	            out.println("<td class = \"sumstyle\">" + book.getPrice() * num + "</td></tr>");
	            sum += book.getPrice() * num;
			}
            out.println("<tr><td class = \"authorstyle\"></td>");
            out.println("<td class = \"namestyle\"></td>");
            out.println("<td class = \"pricestyle\"></td>");
            out.println("<td class = \"numstyle\">合计</td>");
            out.println("<td class = \"sumstyle\">" + sum + "</td></tr>");
			out.println("</table>");
			
			out.println("</body>");
			out.println("</html>");
            
        } catch(Exception e){
        	e.printStackTrace();
        }
        finally {
            out.close();
        }
    }
    protected void addBook(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		String id = request.getParameter("bookid");
		HttpSession session = request.getSession();
		List<String> tmporder;
	    if(session.getAttribute("tmporder")==null) {
	    	tmporder = new ArrayList<>();
	    }
	    else {
	    	tmporder = (List<String>) session.getAttribute("tmporder");
	    }
	    tmporder.add(id);
		System.out.println(tmporder);
        session.setAttribute("tmporder",tmporder);
    }
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<String> tmporder = null;
	    if(session.getAttribute("tmporder")==null) {
			response.sendRedirect("order.jsp");
	    }
	    else {
	    	tmporder = (List<String>) session.getAttribute("tmporder");
	    }

		Integer userid = (Integer) session.getAttribute("userid");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");//获取订单信息

        ManageOrder MO = new ManageOrder();
		Integer orderID = MO.addOrder(name, address, phone, userid, tmporder);
        session.setAttribute("tmporder",null);
		
		response.sendRedirect("order.jsp");
    }
    protected void Clear(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<String> tmporder = null;
        session.setAttribute("tmporder",tmporder);
        
		response.sendRedirect("order.jsp");
    }
	public void deleteOrder(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		Integer orderID = Integer.valueOf(request.getParameter("orderid"));
		ManageOrder MO = new ManageOrder(); 
		MO.deleteOrder(orderID);
		System.out.println(orderID); 
		response.sendRedirect("manager?action=list");
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("Do Get");
		
		String action = request.getParameter("action");
		System.out.println(action);
		switch(action) {
			case"addbook":
				addBook(request, response);
				break;
			case"tmporder":
				getTmpOrder(request, response);
				break;
			case"clear":
				Clear(request, response);
				break;
			case"deleteorder":
				deleteOrder(request, response);
				break;
		}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("Do Post"); 
		
		createOrder(request, response);
    }

}