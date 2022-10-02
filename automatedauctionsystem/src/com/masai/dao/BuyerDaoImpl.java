package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Exception.BuyerException;
import com.masai.Exception.ProductException;
import com.masai.bean.Buyer;
import com.masai.bean.Product;
import com.masai.bean.Seller;
import com.masai.utility.DBUtil;

public class BuyerDaoImpl implements BuyerDao {

	@Override
	public Buyer BuyerLogin(String username, String password) throws BuyerException {
	
		
		Buyer buyer = null;
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("Select * from Buyer where email = ?");
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("Select * from Buyer where password = ?");
				
				ps2.setString(1,password);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					
					int id = rs2.getInt("buyerId");
					String name = rs2.getString("name");
					String email = rs2.getString("email");
					String mobile = rs2.getString("mobile");
					String address = rs2.getString("address");
					String pass = rs2.getString("password");
					
					buyer = new Buyer(id, name, email, mobile, address, password);
				}
				else
					throw new BuyerException("Invalid Password, Please Enter valid password...");
			}
			else
				throw new BuyerException("Invalid Username, Please Enter valid username...");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BuyerException();
		}
		
		return buyer;
	}

	@Override
	public String Addproduct(int buyerid, int serialno)  {
		
		String msg="Not inserted";
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into buyer_product values(?,?)");
			ps.setInt(1, buyerid);
			ps.setInt(2, serialno);
			int x=ps.executeUpdate();
			if(x>0) {
				msg="product alloted successfully for buyer roll "+serialno;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public String registerBuyer(Buyer buyer) {
		String message = "Not inserted";
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into buyer (Buyername,buyeremail,buyermobile,buyerpassword,buyeraddress) values(?,?,?,?,?)");
			
			ps.setString(1, buyer.getName());
			ps.setString(2, buyer.getEmail());
			ps.setString(3, buyer.getAddress());
			ps.setString(4, buyer.getPassword());
			ps.setString(5, buyer.getMobile());
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="Student registered successfully";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		
		
		
		
		return message;
	}

	
	
	
}
