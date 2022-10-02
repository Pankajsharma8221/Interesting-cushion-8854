package com.masai.insert;

import java.util.Scanner;


import com.masai.dao.BuyerDao;
import com.masai.dao.BuyerDaoImpl;

public class InsertBuyerProduct {

	public static void buyerproduct() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the buyer id");
		int buyerid=sc.nextInt();
		
		System.out.println("Enter the Productid");
		int productId=sc.nextInt();
		
	
		
		BuyerDao bd= new BuyerDaoImpl();

		String rs = bd.Addproduct(productId, buyerid);
		System.out.println(rs);
		
		
	}
}
