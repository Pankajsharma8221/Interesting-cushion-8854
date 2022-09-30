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

}
