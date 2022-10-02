package com.masai.insert;

import java.util.List;

import com.masai.Exception.SellerException;
import com.masai.bean.Seller;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class GetSellerList {

	public static void sellerlist() {
		AdminDao ad=new AdminDaoImpl();
		try {
			List<Seller> courses = ad.ViewRegisteredSellerList();
			courses.forEach(s->{
				
				System.out.println("--------------------------");
				System.out.println("Sellers details - ");
				System.out.println("--------------------------");
				System.out.println("seller id - "+s.getSellerId());
				System.out.println("Seller name - "+s.getName());
				System.out.println("Seller email - "+s.getEmail());
				System.out.println("Seller address - "+s.getEmail());
				System.out.println("Seller mobile - "+s.getMobile());
				System.out.println("Seller password - "+s.getPassword());
				
				
			});
		} catch (SellerException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
