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
	public String Addproduct(int buyerid, int serialno) throws BuyerException {
		
		String message="Not inserted";
		
		try(Connection conn= DBUtil.provideConnection()) {
		PreparedStatement ps=	conn.prepareStatement("select * from Buyer where BuyerId=?");
		
		ps.setInt(1,buyerid);
		
		ResultSet rs= ps.executeQuery();
		
		if(rs.next()) {
			PreparedStatement ps2=	conn.prepareStatement("select * from Product where serialno=?");
			ps2.setInt(1,serialno);
			
			ResultSet rs2= ps2.executeQuery();
			
			if(rs2.next()) {
				PreparedStatement ps3=	conn.prepareStatement("insert into Buyerproduct values(?,?)");
				
				ps3.setInt(1,buyerid);
				ps3.setInt(2, serialno);
				
				int x= ps3.executeUpdate();
				
				if(x>0) {
				message="Buyer Product Added succesfully";
				}else {
				throw new BuyerException("Invalid buyer id");
				
				}
				
				
			}
		}else {
			throw new BuyerException("Invalid buyer id");
		}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return message;
	}

	 @Override
	    public String RegisterBuyer(Buyer buyer) {
	        // TODO Auto-generated method stub
	        String message = "";
	        
	        try(Connection conn = DBUtil.provideConnection()){
	            
	            PreparedStatement ps = conn.prepareStatement("insert into Buyer (name, email, mobile, address, password) values (?, ?, ?, ?, ?)");
	            
	            ps.setString(1, buyer.getName());
	            ps.setString(2, buyer.getEmail());
	            ps.setString(3, buyer.getMobile());
	            ps.setString(4, buyer.getAddress());
	            ps.setString(5, buyer.getPassword());
	            
	            int x = ps.executeUpdate();
	            
	            if(x > 0)
	                message = "Buyer registered successfully...";
	            else
	                message = "Buyer could not registered successfully...";
	                throw new SQLException();
	                
	        }
	        catch (SQLException e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        
	        return message;
	    }
	 @Override
	    public List<Product> SearchProduct(String category)throws ProductException{
	        // TODO Auto-generated method stub
	        
	        List<Product> productList = new ArrayList<>();
	        
	        try(Connection conn = DBUtil.provideConnection()){
	            
	            PreparedStatement ps = conn.prepareStatement("Select * from product where ProductCategory = ?");
	            
	            ps.setString(1, category);
	            
	            ResultSet rs = ps.executeQuery();
	            
	            while(rs.next()) {
	                int id = rs.getInt("ProductId");
	                String pname = rs.getString("ProductName");
	                String pcategory = rs.getString("ProductCategory");
	                int pprice = rs.getInt("ProductPrice");
	                int pquantity = rs.getInt("ProductQuantity");
	                
	                Product product = new Product(id, pname, pcategory, pprice, pquantity);
	                
	                productList.add(product);
	            }
	            
	        }
	        catch (SQLException e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	        
	        return productList;
	    }

	
	
}
