package com.masai.insert;

import java.util.Scanner;

import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class RemoveProduct {

    public static void main() {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the Product Id which you want to remove from the list.");
        int id = sc.nextInt();
        
        SellerDao seller = new SellerDaoImpl();
        System.out.println(seller.RemoveProductfromList(id));
    }

}
