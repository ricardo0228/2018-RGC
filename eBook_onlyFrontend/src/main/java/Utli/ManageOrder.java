package Utli;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Book;
import Entity.Order;

public class ManageOrder {
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
	private static List<Order> OrderList = new ArrayList();
	private static boolean initable = true;
	private static void Init() {
	}
	public ManageOrder() {
		if(initable == true) {
			initable = false;
			Init();
		}
	}
	public Integer addOrder(String name, String address, String phone, Integer userid, List<String> tmporder){
		/*Session session = factory.openSession();
		Transaction tx = null;
		Integer orderID = null;
		try{
			tx = session.beginTransaction();
			Order order = new Order();
			order.setName(name);
			order.setAddress(address);
			order.setPhone(phone);
			order.setUserid(userid);
			Date now = new Date();
			order.setPlace_date(now);
			order.setState("Accept");
         
			Set<String> itemlist = new HashSet<>(tmporder);
			ManageBook MB = new ManageBook();
			Float sum = 0F;
			for(String temp : itemlist){
				Book book = MB.getBook(Integer.valueOf(temp));
				Integer num = Collections.frequency(tmporder, temp);
				Integer sold = book.getSold();
				Integer stock = book.getStock();
				book.setSold(sold + num);
				book.setStock(stock - num);
		        session.update(book); 
				
	            sum += book.getPrice() * num;
			}
			order.setSum(sum);
         
			orderID = (Integer) session.save(order); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return orderID;*/

		Order order = new Order();
		order.setName(name);
		order.setAddress(address);
		order.setPhone(phone);
		order.setUserid(userid);
		Date now = new Date();
		order.setPlace_date(now);
		order.setState("Accept");
     
		Set<String> itemlist = new HashSet<>(tmporder);
		ManageBook MB = new ManageBook();
		Float sum = 0F;
		for(String temp : itemlist){
			Book book = MB.getBook(Integer.valueOf(temp));
			Integer num = Collections.frequency(tmporder, temp);
			Integer sold = book.getSold();
			Integer stock = book.getStock();
			book.setSold(sold + num);
			book.setStock(stock - num);
			
            sum += book.getPrice() * num;
		}
		order.setSum(sum);
		OrderList.add(order);
		return OrderList.indexOf(order);
	}
	public List getOrders( ){
		/*Session session = factory.openSession();
		Transaction tx = null;
		List orders = null;
		try{
			tx = session.beginTransaction();
			orders = session.createQuery("FROM Order").list();
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return orders;*/
		return OrderList;
	}
   public void deleteOrder(Integer orderID){
      /*Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Order order =  (Order)session.get(Order.class, orderID); 
         session.delete(order); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }*/
	   Order order = OrderList.get(orderID);
	   OrderList.remove(order);
   }
}

