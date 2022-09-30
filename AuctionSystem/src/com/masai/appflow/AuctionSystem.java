package com.masai.appflow;

import java.util.Scanner;

public class AuctionSystem {

	public static void selectUser() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Automated Auction System");
		
		
		System.out.println("Choose the option -\n"+"1. Admin Login\n"+"2. Login As Seller\n"+"3.Login as Buyer\n"+"4.Create Account as Buyer\n"+"5.create account as Seller");
		
		
		
		System.out.println();
		System.out.println("Enter the above choice ");
		
		
		int choice=0;
		try {
			choice =sc.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Invalid insertion please insert correctly");
			
			System.out.println();
			System.out.println("Try again");
			
			AuctionSystem.selectUser();
		}
		
		
		switch(choice) {
		case 1: System.out.println("Enter the admin username");
		String username=sc.next();
		System.out.println("Enter admin password");
		String password=sc.next();
		
		
//		
//		
		break;
		
		case 2:
			AuctionSystem.Seller();
		break;
		case 3:
			AuctionSystem.Buyer();
		break;
		case 4:
			AuctionSystem.CreateAccountAsBuyer();
		case 5: 
			AuctionSystem.CreateAccountAsSeller();
	
		default:
			System.out.println("Invalid choice!");
			System.out.println();
			System.out.println("Try again");
			AuctionSystem.selectUser();
			
			
		}
		
		
		
	}
	public static void admin() {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("1. Add a new product\r\n"
				+"  ");
		
		
	}
	
	public static void Seller() {
		
	}
	
	public static void Buyer() {
		
	}
	public static void CreateAccountAsBuyer() {
		
	}
	
	public static void CreateAccountAsSeller() {
		
	}
}
