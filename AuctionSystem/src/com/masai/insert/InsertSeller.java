package com.masai.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertSeller {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the SellerId");
		int sellerId=sc.nextInt();
		
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
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/pankajdb";
		try(Connection conn=DriverManager.getConnection(url,"root","root")) {
			
			
			PreparedStatement ps=conn.prepareStatement("insert into Seller values(?,?,?,?,?,?)");
			ps.setInt(1, sellerId);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4,mobile);
			ps.setString(5, address);
			ps.setString(6,password);
			
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Record inserted succesfully");
			}else {
				System.out.println("Not inserted");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
