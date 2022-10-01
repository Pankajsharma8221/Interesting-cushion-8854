package com.masai.dao;

import java.util.List;

import com.masai.Exception.BuyerException;
import com.masai.Exception.ProductException;
import com.masai.bean.Buyer;
import com.masai.bean.Product;

public interface BuyerDao {

	public Buyer BuyerLogin(String username,String password)throws BuyerException;

	
	public String Addproduct(int buyerido,int serialn)throws BuyerException;


public String RegisterBuyer(Buyer buyer);
    
    public List<Product> SearchProduct(String category) throws ProductException;
}
