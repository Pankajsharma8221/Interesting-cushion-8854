package com.masai.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.masai.bean.Buyer;
import com.masai.dao.BuyerDao;
import com.masai.dao.BuyerDaoImpl;
import com.masai.utility.DBUtil;

public class RegisterBuyer {

	public static void rsgisterBuyer() {
		// TODO Auto-generated method stub

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
		

		Buyer buyer= new Buyer(name, email, mobile, address, password);
		
		BuyerDao bd= new BuyerDaoImpl();
		String rs=bd.registerBuyer(buyer);
		System.out.println(rs);
						
			
			}

}
