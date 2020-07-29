package com.swapwindow;
import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("                                        Shopping Cart                                 ");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println();
		
		while(true) 
		{
			System.out.println("  >      press 1 for list of the products.");
			System.out.println("  >      press 2 for add products");
			System.out.println("  >      press 3 for remove products");
			System.out.println("  >      press 4 to view cart");
			System.out.println();
			System.out.println();
			System.out.print("   **    Enter Your Option: ");
			
			ShoppingCart s = new ShoppingCart();
			s.setProductName();
			s.setProductPrice();
			int Option = sc.nextInt();
			
			switch(Option) 
			{
				
				case 1 :
					s.listOfProducts();
					break;
				case 2:
					System.out.println();
					System.out.print(">>     Product Id :");
					int productId = sc.nextInt();
					s.addToCart(productId,sc);
					break;
				case 3:
					System.out.println();
					System.out.println();
					if (s.map.isEmpty()) 
					{
						System.out.println("----NO PRODUCT IS ADDED TO THE CART---SO NOTHING TO REMOVE----\n");
						break;
					}
					else 
					{
						System.out.print("Enter product Id");
						int productid = sc.nextInt();
						s.removeFromCart(productid);
						break;
					}	
				case 4:
					s.viewCart();
					break;
					
				default:
					System.out.println();
					System.out.println("Please enter the Correct Key\n");
					break;
					
			}
		}
	}
}
