package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Exception.SellerException;
import com.masai.bean.Seller;
import com.masai.utility.DBUtil;

public class SellerDaoImpl implements SellerDao {

	@Override
	public Seller SellerLogin(String username, String password) throws SellerException {
	
		Seller seller=null;
		
		
		try(Connection conn =DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from where email =?");
			
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2=conn.prepareStatement("select * from Seller where password=?");
				
				ps2.setString(1, password);
				
				ResultSet rs2=ps2.executeQuery();
				
				if(rs2.next()) {
					int id = rs2.getInt("sellerId");
					String name = rs2.getString("name");
					String email = rs2.getString("email");
					String mobile = rs2.getString("mobile");
					String address = rs2.getString("address");
					String pass = rs2.getString("password");
					
					seller = new Seller(id, name, email, mobile, address, password);
				}else {
					throw new SellerException("Invalid password, please enter the valid password");
					
				}
			}else {
				throw new SellerException("Invalid username enter the valid username");
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new SellerException();
		}
		
		
		
		return seller;
	}

	@Override
	public String Addproduct(int sellerid, int serialno) throws SellerException {
	String message="Not inserted";
		
		try(Connection conn= DBUtil.provideConnection()) {
		PreparedStatement ps=	conn.prepareStatement("select * from Seller where SellerId=?");
		
		ps.setInt(1,sellerid);
		
		ResultSet rs= ps.executeQuery();
		
		if(rs.next()) {
			PreparedStatement ps2=	conn.prepareStatement("select * from Product where serialno=?");
			ps2.setInt(1,serialno);
			
			ResultSet rs2= ps2.executeQuery();
			
			if(rs2.next()) {
				PreparedStatement ps3=	conn.prepareStatement("insert into Sellerproduct values(?,?)");
				
				ps3.setInt(1,sellerid);
				ps3.setInt(2, serialno);
				
				int x= ps3.executeUpdate();
				
				if(x>0) {
				message="Seller Product Added succesfully";
				}else {
				throw new SellerException("Invalid Seller id");
				
				}
				
				
			}
		}else {
			throw new SellerException("Invalid buyer id");
		}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return message;
	
	}

}
