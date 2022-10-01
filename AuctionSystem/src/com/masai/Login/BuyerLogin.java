package com.masai.Login;

import java.util.Scanner;

import com.masai.bean.Buyer;
import com.masai.dao.BuyerDao;
import com.masai.dao.BuyerDaoImpl;

public class BuyerLogin {

	public static void main() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the username");
		String username=sc.next();
		
		System.out.println("Enter your password");
		String password=sc.next();
		
		BuyerDao buyer=new BuyerDaoImpl(); 
		
		try {
			Buyer b=buyer.BuyerLogin(username,password);
			
			System.out.println("Welcome to the system"+b.getName());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
