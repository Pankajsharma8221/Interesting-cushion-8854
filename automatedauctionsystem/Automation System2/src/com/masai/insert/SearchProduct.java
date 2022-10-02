package com.masai.insert;

import java.util.Scanner;


import com.masai.Exception.ProductException;
import com.masai.bean.Product;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class SearchProduct {

	public static void search() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter product name to get the details");
		String pname=sc.next();
		SellerDao sd=new SellerDaoImpl();
		Product p=null;
		try {
			p=sd.searchProduct(pname);
		} catch (ProductException e) {
			
			System.out.println(e.getMessage());
		}
		if(p!=null) {
			System.out.println("Product no - "+p.getSno());
			System.out.println("Product name - "+p.getPname());
			System.out.println("Product price - "+p.getPrice());
			System.out.println("Product Quantity - "+p.getQuantity());
		}else {
			System.out.println("Product does not exist");
		}

	}
}
