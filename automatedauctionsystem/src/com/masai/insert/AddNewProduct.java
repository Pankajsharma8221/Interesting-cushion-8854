package com.masai.insert;

import java.util.Scanner;

import com.masai.bean.Product;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;



public class AddNewProduct {

	public static void addNewProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter details of Product which you want to add");
		System.out.println("Enter Product name : ");
		String pname=sc.next();
		System.out.println("Enter Price of Product : ");
		int price=sc.nextInt();
		System.out.println("Enter product no");
		int pno=sc.nextInt();
		System.out.println("Enter product Quantity");
		int quantity=sc.nextInt();
		
		Product p= new Product(pno, pname, price, quantity);
		SellerDao sd= new SellerDaoImpl();
		String result= sd.addNewProduct(p);
		System.out.println(result);
	}
}
