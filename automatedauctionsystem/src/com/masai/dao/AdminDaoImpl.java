package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.Exception.BuyerException;
import com.masai.Exception.ProductException;
import com.masai.Exception.SellerException;
import com.masai.bean.Admin;
import com.masai.bean.Buyer;
import com.masai.bean.Product;
import com.masai.bean.Seller;
import com.masai.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	
	
	public Admin AdminLogin(String username, String password) throws AdminException {
		
		Admin admin=null;
		
		try(Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from Admin Aemail=?");
			
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				PreparedStatement ps2=conn.prepareStatement("select * from Admin where Apassword=?");
				
				ps.setString(1, password);
				ResultSet rs2=ps.executeQuery();
				
				
				if(rs2.next()) {
					String name=rs.getString("Aname");
					String email=rs2.getString("Aemail");
					String pass=rs2.getString("Apassword");
					
					admin =new Admin(name,email,pass);
				}else {
					throw new AdminException("Invalid password, please enter the valid password");
				}
			}else {
				throw new AdminException("Invalid email, enter the valid email");
			}
			
		}catch(SQLException e) {
			throw new AdminException();
		}
		return admin;
	}
	@Override
	public List<Buyer> ViewRegisteredBuyerList() throws BuyerException {
		// TODO Auto-generated method stub
	 List<Buyer> buyerlist =new ArrayList<>();
	 
	  try(Connection conn=DBUtil.provideConnection()){ 
		  PreparedStatement ps=conn.prepareStatement("select * from Buyer");
		  
		  ResultSet rs=ps.executeQuery();
		  while(rs.next()) {
			  int id= rs.getInt("buno");
			  String name=rs.getString("buyername");
			  String email=rs.getString("buyeremail");
			  String mobile =rs.getString("buyermobile");
			  String address=rs.getString("buyeraddress");
			  String pass=rs.getString("buyerpassword");
			  
			  Buyer buyer=new Buyer(id,name,email,mobile,address,pass);
			  
			  buyerlist.add(buyer);
		  }
		  
		
	  }catch(SQLException se) {
		  System.out.println(se.getMessage());
		  
	  }
	  if(buyerlist.size()==0) {
		  System.out.println("there is no any buyer please insert as buyer ");
	  }
	  return buyerlist;
	  }
	@Override
	public List<Seller> ViewRegisteredSellerList() throws SellerException {
		List<Seller> sellerlist =new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from seller");
			
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			int id= rs.getInt("seno");
			String name = rs.getString("sellername");
			String email = rs.getString("selleremail");
			String mobile = rs.getString("sellermobile");
			String address = rs.getString("selleraddress");
			String pass = rs.getString("sellerpassword");
			
			Seller seller= new Seller(id,name,email,mobile,address,pass);
			sellerlist.add(seller);
			
		}
			
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		
		if(sellerlist.size()==0) {
			System.out.println("No seller are there");
			
		}
		return sellerlist;
	}
	@Override
	public List<Product> ViewProductList() throws ProductException {
		
		List<Product> productlist= new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from product");
			
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			int id= rs.getInt("pno");
			String name = rs.getString("productname");
			int price= rs.getInt("price");
			int quantity= rs.getInt("quantity");
			
			Product prouduct= new Product(id, name, price, quantity);
			productlist.add(prouduct);
			
		}
			
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		
		if(productlist.size()==0) {
			System.out.println("No product are there");
			
		}
		return productlist;
	}
}
