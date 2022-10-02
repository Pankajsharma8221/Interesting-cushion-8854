package com.masai.appflow;

import java.util.InputMismatchException;
import java.util.Scanner;


import com.masai.Login.AdminLogin;
import com.masai.Login.BuyerLogin;
import com.masai.Login.SellerLogin;
import com.masai.insert.AddNewProduct;
import com.masai.insert.GetBuyerList;
import com.masai.insert.GetSellerList;
import com.masai.insert.InsertBuyerProduct;
import com.masai.insert.InsertSellerProduct;
import com.masai.insert.RegisterBuyer;
import com.masai.insert.RegisterSeller;
import com.masai.insert.RemoveProduct;
import com.masai.insert.SearchProduct;
import com.masai.insert.UpdatePriceQuantity;
import com.masai.insert.ViewAllProduct;




public class AuctionSystem {

	public static void selectUser() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Automated Auction System");
		
		
		System.out.println("Choose the option -\n"+"1. Administrator\n"
												+"2. seller\n"
												+"3. buyer\n"
												+"4. Go Back\n");
		
		
		
		System.out.println();
		System.out.println("Enter the above choice ");
		
		
		int choice = 0;
		try {
			choice = sc.nextInt();
		} catch (InputMismatchException e) {

			System.out.println("Invalid input!");

			System.out.println();
			System.out.println("Try again...");

			AuctionSystem.selectUser();
		}

		switch (choice) {
		case 1:
			AuctionSystem.administer();
			break;
		case 2:
			AuctionSystem.seller();
			break;
		case 3:
			AuctionSystem.buyer();
			break;
		case 4:
			AuctionSystem.selectUser();
			break;
		default:
			System.out.println("Invalid choice!");
			System.out.println();

			System.out.println("Try again...");
			AuctionSystem.selectUser();
		
		
					
		}
		
		
		
	}
	public static void administer() {
Scanner sc=new Scanner(System.in);
		
		System.out.println("1.  admin login \r\n"
				         + "2.  View the registered buyer list.\r\n"
				         + "3.  View the registered seller list.\r\n"
				         + "4.  View the registered product list.\r\n"
				         + "5.  Add new product list.\r\n"
				         + "6.  Update Product price and Quantity from the list.\r\n"
				         + "7. Go Back");
		
		System.out.println();
		System.out.println("Enter any number from above which you want to operate");
		
		int c=0;
		
		try {
			c=sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Invalid input!");
			System.out.println("Try again....");
			
		}
		
		switch(c) {
		case 1:
			AdminLogin.adminlogin();
		case 2:
			GetBuyerList.buyerlist();
			break;
		case 3:
			GetSellerList.sellerlist();
			break;
		case 4:
			ViewAllProduct.viewproduct();
			break;
		case 5:
			AddNewProduct.addNewProduct();
			break;
		case 6:
			UpdatePriceQuantity.update();
			break;
		case 7:
			AuctionSystem.selectUser();
		}
		
		AuctionSystem.administer();
			
	
		}
	public static void seller() {
		Scanner sc=new Scanner(System.in);
		System.out.println(" 	1. Register himself or herself as seller.\r\n"
						+  "	2. seller login.\r\n"
						+  "	3. Create list of items to sell.\r\n"
						+  "	4. Search Product in the list.\r\n"
						+  "	5. Remove Product from the list.\n"
						+  " 	6. Go back");
		
		System.out.println();
		System.out.println("Enter any number from above which you want to operate");
		int c=0;
		
		try {
			c=sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Invalid input!");
			System.out.println("Try again....");
			AuctionSystem.seller();
		}
		
		switch(c) {
		
		case 1:
			RegisterSeller.registerSeller();;
			break;
		case 2:
			SellerLogin.sellerlogin();
			break;
		case 3:
			InsertSellerProduct.sellerProduct();;
			break;
		case 4:
			SearchProduct.search();;
			break;
		case 5:
			RemoveProduct.remove();;
			break;
		case 6:
			AuctionSystem.selectUser();;
			break;
		}
		
		AuctionSystem.seller();;
		
		
		
	}
	public static void buyer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("	1. Register himself in a buyer with a username and password (email should be the username)\r\n"
						  + "	2. Login as Buyer.\r\n"
						  + "	3. Insert product into buyer.\r\n"
						  + "	4. Go back");
		
		System.out.println();
		System.out.println("Enter any number from above which you want to operate");
		int c=0;
		
		try {
			c=sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Invalid input!");
			System.out.println("Try again....");
			AuctionSystem.buyer();
		}
		
		switch(c) {
		case 1:
			RegisterBuyer.rsgisterBuyer();;
			break;
		case 2:
			BuyerLogin.buyerlogin();;
			break;
		case 3:
			InsertBuyerProduct.buyerproduct();;
			break;
		case 4:
			AuctionSystem.selectUser();;
			break;
		}
		
		AuctionSystem.buyer();;
	}

}
