package Utli;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Book;
import Entity.User;

public class ManageBook {
	private static final SessionFactory factory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() { 
	   	try { 
		   // Create the SessionFactory from hibernate.cfg.xml 
		   return new Configuration().configure().buildSessionFactory(); } 
	   	catch (Throwable ex) { 
       		// Make sure you log the exception, as it might be 
	   		System.err.println("Initial SessionFactory creation failed." + ex); 
          	throw new ExceptionInInitializerError(ex); 
	   	} 
	} 
	private static List<Book> BookList = new ArrayList();
	private static boolean initable = true;
	private static void Init() {
        Book book1 = new Book(0, "bookA", "authorA", "styleB");
        book1.setImg_url("files\\PIC\\bookA.png");
        book1.setPrice(5.13f);
        book1.setSold(16);
        book1.setStock(96);
        Book book2 = new Book(1, "bookB", "authorB", "styleA");
        book2.setImg_url("files\\PIC\\bookB.png");
        book2.setPrice(15.66f);
        book2.setSold(6);
        book2.setStock(62);
        Book book3 = new Book(2, "bookC", "authorC", "styleB");
        book3.setImg_url("files\\PIC\\bookC.png");
        book3.setPrice(12.36f);
        book3.setSold(7);
        book3.setStock(25);
        Book book4 = new Book(3, "bookD", "authorA", "styleC");
        book4.setImg_url("files\\PIC\\bookD.png");
        book4.setPrice(24.53f);
        book4.setSold(9);
        book4.setStock(43);
        BookList.add(book1);
        BookList.add(book2);
        BookList.add(book3);
        BookList.add(book4);
	}
	public ManageBook() {
		if(initable == true) {
			initable = false;
			Init();
		}
	}
	public List getBooks( ){
		/*Session session = factory.openSession();
		Transaction tx = null;
		List books = null;
		try{
			tx = session.beginTransaction();
			books = session.createQuery("FROM Book").list();
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return books;*/
		return BookList;
	}
	public Book getBook(Integer bookid){
		/*Session session = factory.openSession();
		Transaction tx = null;
		Book book = null;
		try{
			tx = session.beginTransaction();
			book = (Book) session.get(Book.class, bookid);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return book;*/
		return BookList.get(bookid);
	}
   /*public void updateUser(Integer UserID, String password ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         User user = (User)session.get(User.class, UserID); 
         user.setPassword( password );
         session.update(user); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }*/
   public void deleteBook(Integer bookID){
      /*Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Book book =  (Book)session.get(Book.class, bookID); 
         session.delete(book); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }*/
	   Book book = BookList.get(bookID);
	   BookList.remove(book);
   }
}

