package com.masai.insert;

import java.util.List;

import com.masai.Exception.ProductException;
import com.masai.bean.Product;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class ListofProduct {
    public static void main() {
        // TODO Auto-generated method stub
        
        SellerDao productDetail = new SellerDaoImpl();
        
        try {
            List<Product> productList = productDetail.CreateListofProducttoSell();
            
            productList.forEach(p -> {
                System.out.println("Product Id is : " + p.getProductId());
                System.out.println("Product Name is : " + p.getProductName());
                System.out.println("Product Category is : " + p.getProductCategory());
                System.out.println("Product Price is : " + p.getProductPrice());
                System.out.println("Product Quantity is : " + p.getProductQuantity());
                
                System.out.println("============================================");
                
            });
        }
        catch (ProductException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
