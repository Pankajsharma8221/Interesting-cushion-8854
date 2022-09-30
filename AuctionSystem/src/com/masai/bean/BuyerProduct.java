package com.masai.bean;

public class BuyerProduct {
	private int serialno;
   private String name;
 private String email;
 public BuyerProduct() {
	super();
}
public BuyerProduct(int serialno, String name, String email, String productname, int price, int quantity) {
	super();
	this.serialno = serialno;
	this.name = name;
	this.email = email;
	this.productname = productname;
	this.price = price;
	this.quantity = quantity;
}
@Override
public String toString() {
	return "BuyerProduct [serialno=" + serialno + ", name=" + name + ", email=" + email + ", productname=" + productname
			+ ", price=" + price + ", quantity=" + quantity + "]";
}
public int getSerialno() {
	return serialno;
}
public void setSerialno(int serialno) {
	this.serialno = serialno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
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
private String productname;
 private int price;
 private int quantity;
}
