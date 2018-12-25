package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
	private int id;
	private String name; 
	private String address; 
	private String phone; 
	private String state; 
	private Date place_date; 
	private Float sum; 
	private Integer userid; 
	private SimpleDateFormat onlydate = new SimpleDateFormat("yyyy-MM-dd");

	public Order() {}
	public int getId() {
		return id;
	}
	public void setId( int id ) {
		this.id = id;
	}
	public String getName() {
	   	return name;
	}
	public void setName( String name ) {
	      this.name = name;
	}
	public String getAddress() {
	   	return address;
	}
	public void setAddress( String address ) {
	      this.address = address;
	}
	public String getPhone() {
	   	return phone;
	}
	public void setPhone( String phone ) {
	      this.phone = phone;
	}
	public String getState() {
	   	return state;
	}
	public void setState( String state ) {
	      this.state = state;
	}
	public Date getPlace_date() {
	   	return place_date;
	}
	public void setPlace_date( Date place_date ) {
	      this.place_date = place_date;
	}
	public String getPlacedate() {
	   	return onlydate.format(place_date);
	}
	public Float getSum() {
	   	return sum;
	}
	public void setSum( Float sum ) {
	      this.sum = sum;
	}
	public Integer getUserid() {
	   	return userid;
	}
	public void setUserid( Integer userid ) {
	      this.userid = userid;
	}

}

