package com.masai.dao;

import java.util.List;

import com.masai.Exception.BuyerException;
import com.masai.Exception.ProductException;
import com.masai.Exception.SellerException;
import com.masai.bean.Product;
import com.masai.bean.Seller;

public interface SellerDao {

	public Seller SellerLogin(String username,String password)throws SellerException;

	public String Addproduct(int sellerid ,int serialno)throws SellerException;

	   public String RegisterSeller(Seller seller);
	    
	    public List<Product> CreateListofProducttoSell()throws ProductException;
	    
	    public String UpdateProductinList(Product product);
	    
	    public String AddProducttoSell(Product product);
	    
	    public String RemoveProductfromList(int id);


}
