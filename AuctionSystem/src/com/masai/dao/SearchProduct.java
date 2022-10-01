package com.masai.dao;

import java.util.List;
import java.util.Scanner;

import com.masai.Exception.ProductException;
import com.masai.bean.Product;

public class SearchProduct {

    public static void main() {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Entery category to search the products falls under that.");
        String category = sc.next();
        
        BuyerDao buyer = new BuyerDaoImpl();
        
        try {
            List<Product> product = buyer.SearchProduct(category);
            
            product.forEach(p ->{
                System.out.println("Product Id is : " + p.getProductId());
                System.out.println("Product Name is : " + p.getProductName());
                System.out.println("Product Category is : " + p.getProductCategory());
                System.out.println("Product Price is : " + p.getProductPrice());
                System.out.println("Product Quantity is : " + p.getProductQuantity());
                
                System.out.println("============================================");
            });
        } catch (ProductException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
