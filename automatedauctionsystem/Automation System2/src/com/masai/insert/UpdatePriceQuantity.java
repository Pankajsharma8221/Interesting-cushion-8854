package com.masai.insert;

import java.util.Scanner;


import com.masai.Exception.ProductException;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class UpdatePriceQuantity {

	public static void update() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter price for which you want to update ");
		int price=sc.nextInt();
		System.out.println("Enter Quantity for which you want to update");
		int quantity=sc.nextInt();
		System.out.println("Enter product name which you want to update price and quantity");
		String pname=sc.next();
		SellerDao sd= new SellerDaoImpl();
		try {
			String rs=sd.updateprice(price, quantity, pname);
			System.out.println(rs);
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
