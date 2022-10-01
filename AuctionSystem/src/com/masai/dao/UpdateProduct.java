package com.masai.dao;

import java.util.Scanner;

import com.masai.bean.Product;

public class UpdateProduct {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Product id : ");
        int id = sc.nextInt();
        
        System.out.println("Enter Product name : ");
        String pname = sc.next();
        
        System.out.println("Enter Product category : ");
        String pcategory = sc.next();
        
        System.out.println("Enter Product price : ");
        int pprice = sc.nextInt();
        
        System.out.println("Enter Product quantity : ");
        int pquantity = sc.nextInt();
        
        Product product = new Product(id, pname, pcategory, pprice, pquantity);
        
        SellerDao seller = new SellerDaoImpl();
        
    }

}
