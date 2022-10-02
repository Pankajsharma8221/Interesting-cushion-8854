package com.masai.insert;

import java.util.List;
import com.masai.Exception.ProductException;
import com.masai.bean.Product;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class ViewAllProduct {

	public static void viewproduct() {
		AdminDao ad=new AdminDaoImpl();
		try {
			List<Product> product = ad.ViewProductList();
			product.forEach(p->{
				
				System.out.println("--------------------------");
				System.out.println("product details - ");
				System.out.println("--------------------------");
				System.out.println("product id - "+p.getSno());
				System.out.println("product name - "+p.getPname());
				System.out.println("product price - "+p.getPrice());
				System.out.println("product quantity - "+p.getQuantity());
				
				
				
			});
		} catch (ProductException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}		
		
		
	}
}
