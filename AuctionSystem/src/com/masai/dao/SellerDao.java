package com.masai.dao;

import com.masai.Exception.SellerException;
import com.masai.bean.Seller;

public interface SellerDao {

	public Seller SellerLogin(String username,String password)throws SellerException;
}
