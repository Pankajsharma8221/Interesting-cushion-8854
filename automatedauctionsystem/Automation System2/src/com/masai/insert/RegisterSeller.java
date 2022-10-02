package com.masai.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.masai.bean.Seller;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;
import com.masai.utility.DBUtil;

public class RegisterSeller {

	public static void registerSeller() {
		Scanner sc=new Scanner(System.in);
		
		
		
		System.out.println("Enter the name");
		String name=sc.next();
		
		System.out.println("Enter email");
		String email=sc.next();
		
		System.out.println("Enter mobile");
		String mobile=sc.next();
		
		System.out.println("Enter the address");
		String address=sc.next();
		
		System.out.println("Enter the password");
		String password=sc.next();
		
		
		Seller seller = new Seller(name, email, mobile, address, password);
		
		SellerDao sd= new SellerDaoImpl();
		String rs=sd.registerBuyer(seller);
		System.out.println(rs);
	}
}
