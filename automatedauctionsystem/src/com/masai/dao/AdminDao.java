package com.masai.dao;

import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.Exception.BuyerException;
import com.masai.Exception.ProductException;
import com.masai.Exception.SellerException;
import com.masai.bean.Admin;
import com.masai.bean.Buyer;
import com.masai.bean.Product;
import com.masai.bean.Seller;

public interface AdminDao {
	public Admin AdminLogin(String username, String password)throws AdminException;

	public List<Buyer> ViewRegisteredBuyerList()throws BuyerException;
 

	public List<Seller> ViewRegisteredSellerList() throws SellerException;
	
	public List<Product> ViewProductList() throws ProductException;
	

}
