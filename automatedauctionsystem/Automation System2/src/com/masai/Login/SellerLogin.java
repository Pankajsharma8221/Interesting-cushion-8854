package com.masai.Login;

import java.util.Scanner;

import com.masai.appflow.AuctionSystem;
import com.masai.bean.Seller;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class SellerLogin {

	public static void sellerlogin() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the username");
		String username=sc.next();
		
		System.out.println("Enter the password");
		String password=sc.next();
		
		
		if(username.equals("pankaj") && password.equals("12345")) {
			System.out.println("Seller login successful");
			AuctionSystem.seller();;
		}else {
			System.out.println("Username or password are wrong try again");
			AuctionSystem.selectUser();
		}

//		SellerDao seller=new SellerDaoImpl();
//		
//		try {
//			Seller s=seller.SellerLogin(username,password);
//			System.out.println("Welcome to the system"+s.getName());
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
	}
}
