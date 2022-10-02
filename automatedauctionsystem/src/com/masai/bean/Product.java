package com.masai.bean;

public class Product {

	private int Sno;
	private String pname;
	private int price;
	private int quantity;
	public int getSno() {
		return Sno;
	}
	public void setSno(int sno) {
		Sno = sno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product(int sno, String pname, int price, int quantity) {
		super();
		Sno = sno;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
	}
	public Product() {
		super();
	}
	public Product(String pname, int price, int quantity) {
		super();
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [Sno=" + Sno + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
