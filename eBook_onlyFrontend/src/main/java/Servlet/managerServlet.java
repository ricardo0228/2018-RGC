package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import Entity.Book;
import Entity.Order;
import Entity.User;
import Utli.ManageBook;
import Utli.ManageOrder;
import Utli.ManageUser;
 
public class managerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String type;

    public managerServlet() {
        super();
    }
    protected void listBook(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Book List</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"files/CSS/booklist.css\"/>");
            out.println("</head>");
            
            out.println("<body>");
            
    		ManageBook MB = new ManageBook(); 
    		List books = MB.getBooks();
			for (Iterator iterator = books.iterator(); iterator.hasNext();){
				Book book = (Book) iterator.next(); 
	            out.println("<table class = \"tableStyle\">");
	            out.println("<tr><th class = \"picStyle\">");
	            out.println("<div class = \"pic\"><img src=\""+ book.getImg_url() +"\"/></div>");
	            out.println("</th><th class = \"detailStyle\">");
	            out.println("<ul><li>书名：" + book.getName() + "</li>");
	            out.println("<li>作者： " + book.getAuthor() + "</li>");
	            out.println("<li>类型： " + book.getStyle() + "</li>");
	            out.println("<li>出版年份： " + "" + "</li>");
	            out.println("<li>上架时间： " + "" + "</li></ul></th>");
	            out.println("<th class = \"introduceStyle\">");
	            out.println("<p>简介:" + "" + "</p>");
	            out.println("</th><th class = \"orderStyle\">");
	            out.println("<p>售价：" + book.getPrice() + "<br />已售：" 
	            					  + book.getSold() + "<br />库存："
	            					  + book.getStock() + "<br />");
	            out.println("<button style=\"font-size:30px\" onClick=\"test("+ book.getId() + ")\">+1</button>");
	            out.println("<br /></p></th></tr></table>");
			}
			
			out.println("</body>");
			out.println("</html>");
			
			out.println("<script>");
			out.println("function test(id){");
			out.println("var xmlhttp = new XMLHttpRequest();");
			out.println("xmlhttp.open(\"GET\",\"order?action=addbook&bookid=\" + id,true);");
			out.println("xmlhttp.send();}");
			out.println("</script>");
            
        } catch(Exception e){
        	e.printStackTrace();
        }
        finally {
            out.close();
        }
    }
    protected void listUser(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Book List</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"files/CSS/userlist.css\"/>");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<table class = \"tableStyle\">");
            out.println("<tr><th class = \"idstyle\">ID</th>");
            out.println("<th class = \"namestyle\">用户名</th>");
            out.println("<th class = \"emailstyle\">邮箱</th>");
            out.println("<th class = \"phonestyle\">手机号码</th>");
            out.println("<th class = \"optionstyle\">操作</th></tr>");

    		ManageUser MU = new ManageUser(); 
    		List users = MU.getUsers();
			for (Iterator iterator = users.iterator(); iterator.hasNext();){
				User user = (User) iterator.next(); 
				//if(user.getId() == 0) continue;
	            out.println("<tr><td class = \"idstyle\">");
	            out.println("<p>" + users.indexOf(user) + "</p>");
	            out.println("</td><td class = \"namestyle\">");
	            out.println("<p>" + user.getName() + "</p>");
	            out.println("</td><td class = \"emailstyle\">");
	            out.println("<p>" + user.getEmail() + "</p>");
	            out.println("</td><td class = \"phonestyle\">");
	            out.println("<p>" + user.getPhone() + "</p>");
	            out.println("</td><td class = \"optionstyle\">");
	            out.println("<a href=\"user?action=deleteUser&userid="+users.indexOf(user)+"\"><button style=\"font-size:20px\">删除用户</button>");
	            out.println("<button style=\"font-size:20px\" onClick=\"frezen("+ users.indexOf(user) + ")\">冻结用户</button>");
	            out.println("</td></tr>");
			}
            out.println("</table>");
			
			out.println("</body>");
			out.println("</html>");
			
			out.println("<script>");
			out.println("function frezen(id){");
			out.println("var xmlhttp = new XMLHttpRequest();");
			out.println("xmlhttp.open(\"GET\",\"user?action=frezenUser&userid=\" + id,true);");
			out.println("xmlhttp.send();}");
			out.println("</script>");
        } catch(Exception e){
        	e.printStackTrace();
        }
        finally {
            out.close();
        }
    }
    protected void listOrder(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Book List</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"files/CSS/orderlist.css\"/>");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<table class = \"tableStyle\">");
            out.println("<tr><th class = \"idstyle\">订单号</th>");
            out.println("<th class = \"namestyle\">收件人</th>");
            out.println("<th class = \"addressstyle\">收件人地址</th>");
            out.println("<th class = \"phonestyle\">收件人电话</th>");
            out.println("<th class = \"sumstyle\">总金额</th>");
            out.println("<th class = \"datestyle\">下单日期</th>");
            out.println("<th class = \"statestyle\">订单状态</th>");
            out.println("<th class = \"optionstyle\">操作</th></tr>");
            
    		ManageOrder MO = new ManageOrder(); 
    		List orders = MO.getOrders();
			for (Iterator iterator = orders.iterator(); iterator.hasNext();){
				Order order = (Order) iterator.next(); 
	            out.println("<tr><td class = \"idstyle\">");
	            out.println("<p>" + order.getId() + "</p>");
	            out.println("</td><td class = \"namestyle\">");
	            out.println("<p>" + order.getName() + "</p>");
	            out.println("</td><td class = \"addressstyle\">");
	            out.println("<p>" + order.getAddress() + "</p>");
	            out.println("</td><td class = \"phonestyle\">");
	            out.println("<p>" + order.getPhone() + "</p>");
	            out.println("</td><td class = \"sumstyle\">");
	            out.println("<p>" + order.getSum() + "</p>");
	            out.println("</td><td class = \"datestyle\">");
	            out.println("<p>" + order.getPlace_date() + "</p>");
	            out.println("</td><td class = \"statestyle\">");
	            out.println("<p>" + order.getState() + "</p>");
	            out.println("</td><td class = \"optionstyle\">");
	            out.println("<a href=\"order?action=deleteorder&orderid="+order.getId()+"\"><button style=\"font-size:20px\">删除订单</button>");
	            out.println("</td></tr>");
			}
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println(action);
		switch(action) {
			case"list":
				if(type == "user") listUser(request, response);
				if(type == "book") listBook(request, response);
				if(type == "order") listOrder(request, response);
				break;
			case"listUser":
				type = "user";
				break;
			case"listBook":
				type = "book";
				break;
			case"listOrder":
				type = "order";
				break;
		}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("Do Post"); 
    }

}