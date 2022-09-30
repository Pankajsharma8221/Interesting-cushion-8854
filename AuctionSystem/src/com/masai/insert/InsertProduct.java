package com.masai.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertProduct {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the productname");
		String productname=sc.next();
		
		
		System.out.println("Enter the Price");
		int price=sc.nextInt();
		
	
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/pankajdb";
		try(Connection conn=DriverManager.getConnection(url,"root","root")) {
			
			
			PreparedStatement ps=conn.prepareStatement("insert into product values(?,?)");
			ps.setString(1, productname);
			ps.setInt(2, price);
		
			
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Recod inserted succesfully");
			}else {
				System.out.println("Not inserted");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
