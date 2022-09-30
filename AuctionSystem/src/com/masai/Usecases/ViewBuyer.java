package com.masai.Usecases;

import java.util.List;

import com.masai.Exception.BuyerException;
import com.masai.bean.Buyer;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class ViewBuyer {
public static void main(String[] args) {
		
		AdminDao buyer = new AdminDaoImpl();
		
		try {
			List<Buyer> buyerList = buyer.ViewRegisteredBuyerList();
			
			buyerList.forEach(b ->{
				System.out.println("Id of the Buyer : " + b.getBuyerId());
				System.out.println("Name of the Buyer : " + b.getName());
				System.out.println("Email of the Buyer : " + b.getEmail());
				System.out.println("Address of the Buyer : " + b.getAddress());
				System.out.println("Mobile Number of the Buyer : " + b.getMobile());
				System.out.println("==============================================");
			});
		} catch (BuyerException e) {
			System.out.println(e.getMessage());
		}
	}
}
