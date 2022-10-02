package com.masai.dao;

import java.util.List;


import com.masai.Exception.BuyerException;
import com.masai.Exception.ProductException;
import com.masai.Exception.SellerException;
import com.masai.bean.Buyer;
import com.masai.bean.Product;
import com.masai.bean.Seller;

public interface SellerDao {

	public Seller SellerLogin(String username,String password)throws SellerException;

	public String sellerAddproduct(int sellerid ,int serialno);
	
	public String registerBuyer(Seller seller);
	
	public List<Product> VewProductList()throws ProductException;
	
	public String updateprice(int price,int quantity,String pname) throws ProductException;
	
	public String removeProduct(String cname) throws ProductException;
	
	public String addNewProduct(Product product);
	
	public Product searchProduct(String pname) throws ProductException;

	



}
