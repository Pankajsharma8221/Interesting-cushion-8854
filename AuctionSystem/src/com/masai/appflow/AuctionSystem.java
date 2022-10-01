package com.masai.appflow;

import java.util.Scanner;

import com.masai.Login.AdminLogin;
import com.masai.Login.BuyerLogin;
import com.masai.Login.SellerLogin;
import com.masai.Usecases.ViewBuyer;
import com.masai.Usecases.ViewSeller;
import com.masai.dao.AdminDao;
import com.masai.dao.SearchProduct;
import com.masai.insert.InsertBuyer;
import com.masai.insert.InsertBuyerProduct;
import com.masai.insert.InsertProduct;
import com.masai.insert.InsertSeller;
import com.masai.insert.ListofProduct;
import com.masai.insert.RemoveProduct;

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
		case 1: AuctionSystem.admin();
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
	 
	    
	    AdminLogin.main();
	   
	
		
		System.out.println(
				"1. Search the product\r\n"
		        +"2. View register buyer\r\n"
				+"3. View Register seller\r\n"
				+ "4. Add product\r\n"
				+"5. Remove Product\r\n"
				+"6. Add Buyer \r\n"
				+ "7. Add Seller \r\n "
				+ "8. See List of Product\r\n"
				+ "9. Go Back");
		
		System.out.println();
		System.out.println("Enter the number from above which you wan tot operat");
		
		
		int c=0;
		try {
		    Scanner sc=new Scanner(System.in);
		    c=sc.nextInt();
        } catch (Exception e) {
  System.out.println("Invaid input!");
  System.out.println("Try again........ ");
  
  
  AuctionSystem.selectUser();
            
        }
		
		
		switch(c) {
		    case 1: SearchProduct.main();
		    break;
		    case 2: ViewBuyer.main();
		    break;
		    case 3:ViewSeller.main();
		    break;
		    case 4:InsertProduct.main();
		    break;
		    case 5:RemoveProduct.main();
		    break;
		    case 6: InsertBuyer.Buyer();
		    break;
		    case 7: InsertSeller.main();
		    break;
		    case 8:ListofProduct.main();
		    break;
		    case 9 :AuctionSystem.selectUser();
		    
		}
		
	}
	

    public static void Seller() {
		
        Scanner sc=new Scanner(System.in);
        
        
        System.out.println("1. Register as seller\r\n"
                +"2. Login as Seller"
                +"3. Go to home page");
        
        System.out.println();
        
        System.out.println("choose above option");
        
        int c=0;
        try {
            c=sc.nextInt();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Invalid input!");
            System.out.println("Try again.....");
            AuctionSystem.selectUser();
        }
        
        switch(c) {
            case 1:InsertSeller.main();
            break;
            case 2: SellerLogin.main();
            break;
            case 3: AuctionSystem.selectUser();
            break;
            }
        
        AuctionSystem.Seller();
        
	}
	
	public static void Buyer() {
		
	    Scanner sc= new Scanner(System.in);
	    System.out.println("1. login as Buyer"
	            +"2 Register as Buyer"
	            +"3. BuyProduct"
	            +"4. See product list"
	               +"5. Go Back" );
	    
	    System.out.println();
	    System.out.println("choose from above");
	    
	    int c=0;
	    try {
            c=sc.nextInt();
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Invalid input...");
            System.out.println("Try again");
            AuctionSystem.Buyer();
            
        }
	    
	    switch(c) {
	        case 1:BuyerLogin.main();
	        break;
	        case 2:InsertBuyer.Buyer();
	        break;
	        case 3:InsertBuyerProduct.main();
	        break;
	        case 4:ListofProduct.main();
	        break;
	        case 5: AuctionSystem.Buyer();
	    }
	    AuctionSystem.selectUser();
	    
	    
	}
	public static void CreateAccountAsBuyer() {
	
		InsertBuyer.Buyer();
	}
	
	public static void CreateAccountAsSeller() {
		InsertSeller.main();
	}
}
