package com.masai.dao;

import com.masai.Exception.BuyerException;
import com.masai.bean.Buyer;

public interface BuyerDao {

	public Buyer BuyerLogin(String username,String password)throws BuyerException;

}
