package com.masai.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertProduct {
	public static void main() {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the serialno");
		int serialno=sc.nextInt();
		
		System.out.println("Enter the productname");
		String productname=sc.next();
		
		
		System.out.println("Enter the Price");
		int price=sc.nextInt();
		
		
		System.out.println("Enter the Quantity");
		int quantity=sc.nextInt();

		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/pankajdb";
		try(Connection conn=DriverManager.getConnection(url,"root","root")) {
			
			
			PreparedStatement ps=conn.prepareStatement("insert into product values(?,?,?,?)");
			ps.setInt(1, serialno);
			ps.setString(2, productname);
			ps.setInt(3, price);
          ps.setInt(4,quantity);		
			
			
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
