package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	private int id;
	private String name; 
	private String author; 
	private String style; 
	private String img_url; 
	private Date pub_date; 
	private Date shelf_date; 
	private Float price; 
	private Integer sold; 
	private Integer stock; 
	private String text; 
	private SimpleDateFormat onlydate = new SimpleDateFormat("yyyy-MM-dd");

	public Book() {}
	public Book(int id, String name, String author, String style) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.style = style;
	}
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
	public String getAuthor() {
	   	return author;
	}
	public void setAuthor( String author ) {
	      this.author = author;
	}
	public String getStyle() {
	   	return style;
	}
	public void setStyle( String style ) {
	      this.style = style;
	}
	public String getImg_url() {
	   	return img_url;
	}
	public void setImg_url( String img_url ) {
	      this.img_url = img_url;
	}
	public Date getPub_date() {
	   	return pub_date;
	}
	public void setPub_date( Date pub_date ) {
	      this.pub_date = pub_date;
	}
	public String getPubDate() {
	   	return onlydate.format(pub_date);
	}
	public Date getShelf_date() {
	   	return shelf_date;
	}
	public void setShelf_date( Date shelf_date ) {
	      this.shelf_date = shelf_date;
	}
	public String getShelfDate() {
	   	return onlydate.format(shelf_date);
	}
	public Integer getSold() {
	   	return sold;
	}
	public void setSold( Integer sold ) {
	      this.sold = sold;
	}
	public Integer getStock() {
	   	return stock;
	}
	public void setStock( Integer stock ) {
	      this.stock = stock;
	}
	public Float getPrice() {
	   	return price;
	}
	public void setPrice( Float price ) {
	      this.price = price;
	}
	public String getText() {
		if(text == null) return "���޼��";
	   	return text;
	}
	public void setText( String text ) {
	      this.text = text;
	}

}

