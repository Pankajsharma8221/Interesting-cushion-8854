package com.masai.insert;

import java.util.Scanner;

import com.masai.Exception.BuyerException;
import com.masai.dao.BuyerDao;
import com.masai.dao.BuyerDaoImpl;

public class InsertBuyerProduct {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the buyer id");
		int buyerid=sc.nextInt();
		
		System.out.println("Enter the Productid");
		int productId=sc.nextInt();
		
	
		
		try {

			BuyerDao bd= new BuyerDaoImpl();
		
		String rs=bd.Addproduct(productId, buyerid);
		System.out.println(rs);
		
		} catch (BuyerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
