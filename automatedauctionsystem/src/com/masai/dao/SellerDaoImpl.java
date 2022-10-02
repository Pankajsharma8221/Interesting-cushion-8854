package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.masai.Exception.ProductException;
import com.masai.Exception.SellerException;
import com.masai.bean.Product;
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
	public String sellerAddproduct(int sellerid, int serialno){
		String msg="Not inserted";
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into seller_product values(?,?)");
			ps.setInt(1, sellerid);
			ps.setInt(2, serialno);
			int x=ps.executeUpdate();
			if(x>0) {
				msg="product alloted successfully for Seller roll "+serialno;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return msg;
	
	}

	@Override
	public List<Product> VewProductList() throws ProductException {
		List<Product> list= new ArrayList<>();
		
		try (Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from product");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String n=rs.getString("pname");
				int fe=rs.getInt("price");
				int qua=rs.getInt("quantity");
				
				Product p= new Product(n, fe, qua);
				list.add(p);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	@Override
	public String registerBuyer(Seller seller) {
		String message = "Not inserted";
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into seller (sellername,selleremail,sellermobile,sellerpassword,selleraddress) values(?,?,?,?,?)");
			
			ps.setString(1, seller.getName());
			ps.setString(2, seller.getEmail());
			ps.setString(3, seller.getAddress());
			ps.setString(4, seller.getPassword());
			ps.setString(5, seller.getMobile());
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="Student registered successfully";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		
		
		
		
		return message;
	}

	

	@Override
	public String updateprice(int price,int quantity,String pname) throws ProductException {
		String msg="Not updated";
		
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("update Product set price=?,quantity=? where productname=?");
			ps.setInt(1, price);
			ps.setInt(2,quantity);
			ps.setString(3, pname);
			int x=ps.executeUpdate();
			if(x>0) {
				msg="product price and quantity updated successfully";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			new ProductException("Not able to update price for  name "+price);
//			new ProductException("Not able to update quantity for  name "+quantity);
		}
		return msg;
	}

	@Override
	public String removeProduct(String pname) throws ProductException {
		String msg="Not deleted";
		
		try(Connection conn=DBUtil.provideConnection();) {
			PreparedStatement ps= conn.prepareStatement("delete from product where productname=?");
			ps.setString(1, pname);
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Product deleted successfully "+ pname;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new ProductException("Product does not exist "+pname);
		}
		return msg;
	}

	@Override
	public String addNewProduct(Product product) {
		String msg="Not inserted";
		
		try(Connection conn= DBUtil.provideConnection()) {
			PreparedStatement ps= conn.prepareStatement("insert into Product values(?,?,?,?)");
			ps.setInt(1, product.getSno());
			ps.setString(2, product.getPname());
			ps.setInt(3, product.getPrice());
			ps.setInt(4, product.getQuantity());
			
			int x=ps.executeUpdate();
			if(x>0) {
				msg="A new Product added successfully";
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public Product searchProduct(String pname) throws ProductException {
		Product p=null;
		
		
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select * from product where productname=?");
			ps.setString(1, pname);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int no=rs.getInt("Pno");
				String pn=rs.getString("productname");
				int pr=rs.getInt("price");
				int qn=rs.getInt("quantity");
				p= new Product(no, pname, pr, qn);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new ProductException("Course does not exist");
		}
		return p;
	}

	

}
