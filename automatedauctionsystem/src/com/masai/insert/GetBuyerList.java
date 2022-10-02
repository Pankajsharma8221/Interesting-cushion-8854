package com.masai.insert;

import java.util.List;

import com.masai.Exception.BuyerException;
import com.masai.bean.Buyer;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class GetBuyerList {

	public static void buyerlist() {
		AdminDao ad=new AdminDaoImpl();
		try {
			List<Buyer> courses = ad.ViewRegisteredBuyerList();
			courses.forEach(b->{
				
				System.out.println("--------------------------");
				System.out.println("Buyers details - ");
				System.out.println("--------------------------");
				System.out.println("Buyer id - "+b.getBuyerId());
				System.out.println("Buyer name - "+b.getName());
				System.out.println("Buyer email - "+b.getEmail());
				System.out.println("Buyer address - "+b.getEmail());
				System.out.println("Buyer mobile - "+b.getMobile());
				System.out.println("Course password - "+b.getPassword());
				
			});
		} catch (BuyerException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
