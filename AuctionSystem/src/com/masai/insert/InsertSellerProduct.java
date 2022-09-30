package com.masai.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


import com.masai.Exception.SellerException;

import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class InsertSellerProduct {
public static void main(String[] args) {


		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the seller id");
		int sellerid=sc.nextInt();
		
		System.out.println("Enter the Productid");
		int productId=sc.nextInt();
		
	
		
		try {

			SellerDao bd= new SellerDaoImpl();
		
		String rs=bd.Addproduct(productId,sellerid);
		System.out.println(rs);
		
		} catch (SellerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
