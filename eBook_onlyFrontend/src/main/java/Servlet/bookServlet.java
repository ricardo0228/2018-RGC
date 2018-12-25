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
import Utli.ManageBook;
import Utli.ManageUser;
 
public class bookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public bookServlet() {
        super();
    }
    protected void getList(HttpServletRequest request,
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
	public void deleteBook(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		Integer bookID = Integer.valueOf(request.getParameter("bookid"));
		ManageBook MB = new ManageBook(); 
		MB.deleteBook(bookID);
		System.out.println(bookID); 
		response.sendRedirect("manager?action=list");
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("Do Get");
		
		String action = request.getParameter("action");
		switch(action) {
			case"getlist":
				getList(request, response);
				break;
			case"deletebook":
				deleteBook(request, response);
				break;
		}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("Do Post"); 
    }

}