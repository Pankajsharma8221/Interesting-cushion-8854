package com.masai.Login;

import java.util.Scanner;

import com.masai.Exception.AdminException;
import com.masai.bean.Admin;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;


public class AdminLogin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your username...");
		String username = sc.next();
		
		System.out.println("Enter your password...");
		String password = sc.next();
		
		AdminDao admin = new AdminDaoImpl();
		
		try {
			Admin a = admin.AdminLogin(username, password);
			System.out.println("Welcome to the System " + a.getName());
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
