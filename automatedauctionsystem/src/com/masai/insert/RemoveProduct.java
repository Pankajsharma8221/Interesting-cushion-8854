package com.masai.insert;

import java.util.Scanner;

import com.masai.Exception.ProductException;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;



public class RemoveProduct {
	public static void remove() {
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter Product name which you want to delete");
	String pname=sc.next();
	SellerDao sd= new SellerDaoImpl();
	try {
		String rs=sd.removeProduct(pname);
		System.out.println(rs);
	} catch (ProductException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
