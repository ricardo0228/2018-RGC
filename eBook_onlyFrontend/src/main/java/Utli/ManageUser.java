package Utli;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Book;
import Entity.User;

public class ManageUser {
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
	private static List<User> UserList = new ArrayList();
	private static boolean initable = true;
	private static void Init() {
        User user0 = new User("admin", "admin", "", "");
        User user1 = new User("user1", "password1", "", "");
        User user2 = new User("user2", "password2", "", "");
        User user3 = new User("user3", "password3", "", "");
		UserList.add(user0);
		UserList.add(user1);
		UserList.add(user2);
		UserList.add(user3);
	}
	public ManageUser() {
		if(initable == true) {
			initable = false;
			Init();
		}
	}
	public Integer addUser(String name, String password, String email, String phone){
		/*Session session = factory.openSession();
      	Transaction tx = null;
      	Integer userID = null;
      	try{
         	tx = session.beginTransaction();
         	User user = new User(name, password, email, phone);
         	userID = (Integer) session.save(user); 
         	tx.commit();
      	}catch (HibernateException e) {
         	if (tx!=null) tx.rollback();
         	e.printStackTrace(); 
      	}finally {
         	session.close(); 
      	}
      	return userID;*/

      	Integer userID = null;
     	User user = new User(name, password, email, phone);
		UserList.add(user);
		userID = UserList.indexOf(user);
      	return userID;
	}
	public Integer login(String name,String password){
		/*Integer userId = -1;
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
	    	List Users = session.createQuery("FROM User").list(); 
	    	for (Iterator iterator = Users.iterator(); iterator.hasNext();){
	    		User user = (User) iterator.next(); 
	         	String nameInDB = user.getName();
				String passwordInDB = user.getPassword();
				if(nameInDB.equals(name) && passwordInDB.equals(password)){
					userId = user.getId();
					break;
				}
	         }
	         tx.commit();
	  	}catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	 	}finally {
	         session.close(); 
	 	}
		return userId;*/
		
		Integer userId = -1;
    	for (Iterator iterator = UserList.iterator(); iterator.hasNext();){
    		User user = (User) iterator.next(); 
         	String nameInDB = user.getName();
			String passwordInDB = user.getPassword();
			if(nameInDB.equals(name) && passwordInDB.equals(password)){
				userId = UserList.indexOf(user);
				break;
			}
         }
    	return userId;
	}
	public List getUsers( ){
		/*Session session = factory.openSession();
		Transaction tx = null;
		List users = null;
		try{
			tx = session.beginTransaction();
			users = session.createQuery("FROM User").list();
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return users;*/
		return UserList;
	}
	public Boolean checkUser(String username ){
		/*Session session = factory.openSession();
		Transaction tx = null;
		Boolean result = false;
		try{
			tx = session.beginTransaction();
			List User = session.createQuery("SELECT id FROM User WHERE name = " + username).list(); 
			if(User.size() > 0) result = true;
		   	tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return result;*/

		Integer userId = -1;
    	for (Iterator iterator = UserList.iterator(); iterator.hasNext();){
    		User user = (User) iterator.next(); 
         	String nameInDB = user.getName();
			if(nameInDB.equals(username)){
				userId = UserList.indexOf(user);
				break;
			}
        }
    	if(userId == -1) return false;
    	else return true;
	}
	public User getUser(Integer userid){
		/*Session session = factory.openSession();
		Transaction tx = null;
		User user = null;
		try{
			tx = session.beginTransaction();
			user = (User) session.get(User.class, userid);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return user;*/
     	User user = UserList.get(userid);
      	return user;
	}
	public void updateUser(Integer UserID, String password, String email, String phone){
		/*Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			User user = (User)session.get(User.class, UserID); 
			user.setPassword( password );
			user.setEmail( email );
			user.setPhone( phone );
			session.update(user); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}*/
     	User user = UserList.get(UserID);
		user.setPassword( password );
		user.setEmail( email );
		user.setPhone( phone );
	}
	public void deleteUser(Integer UserID){
		/*Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			User user =  (User)session.get(User.class, UserID); 
			session.delete(user); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}*/
     	User user = UserList.get(UserID);
     	UserList.remove(user);
	}
}
