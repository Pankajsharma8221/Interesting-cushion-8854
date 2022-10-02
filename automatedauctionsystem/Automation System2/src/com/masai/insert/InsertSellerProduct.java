package com.masai.insert;

import java.util.Scanner;

import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;


public class InsertSellerProduct {

	public static void sellerProduct() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Seller id");
		int sellerid=sc.nextInt();
		
		System.out.println("Enter the Product id");
		int productId=sc.nextInt();
	
		SellerDao sd= new SellerDaoImpl();
		String rs=sd.sellerAddproduct(sellerid, productId);
		System.out.println(rs);

	}
}
