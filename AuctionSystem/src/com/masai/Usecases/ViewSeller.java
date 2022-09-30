package com.masai.Usecases;

import java.util.List;

import com.masai.Exception.SellerException;
import com.masai.bean.Seller;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class ViewSeller {
	public static void main(String[] args) {
		
		AdminDao seller = new AdminDaoImpl();
		
		try {
			List<Seller> buyerList = seller.ViewRegisteredSellerList();
			
			buyerList.forEach(b ->{
				System.out.println("Id of the Buyer : " + b.getSellerId());
				System.out.println("Name of the Buyer : " + b.getName());
				System.out.println("Email of the Buyer : " + b.getEmail());
				System.out.println("Address of the Buyer : " + b.getAddress());
				System.out.println("Mobile Number of the Buyer : " + b.getMobile());
				System.out.println("==============================================");
			});
		} catch (SellerException e) {
			System.out.println(e.getMessage());
		}
	}
}
