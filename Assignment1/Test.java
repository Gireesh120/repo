package com.swapwindow;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("                                        Shopping Cart                                 ");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println();
		System.out.println();
		int check=0;
		while(check==0) {
			System.out.println("  >      press 1 for list of the products.");
			System.out.println("  >      press 2 for add products");
			System.out.println("  >      press 3 for remove products");
			System.out.println("  >      press 4 to view cart");
			System.out.println();
			System.out.println();
			System.out.print("   **    Enter Your Choice: ");
			ShoppingCart s=ShoppingCart.getinstance();
			int choice=sc.nextInt();
			int count=0;
			int choice2=0;
			if(choice>0&&choice<=4){
				count=2;
				if(choice==1) {
					s.list();;
				}else if(choice==2) {
					System.out.println();
					System.out.print(">>     Product Id :");
					int id=sc.nextInt();
					System.out.print(">>     Quantity   : ");
					int quantity=sc.nextInt();
					s.add(id,quantity);
				}else if(choice==3) {
					System.out.print("    Enter productId :");
					int id=sc.nextInt();
					s.remove(id);
				}else if(choice==4) {
					s.viewCart();
				}
				
			}else {
			while(count==0) {
			System.out.println("please enter the valid key");
			choice2=sc.nextInt();
			if(choice2>0&&choice2<=4) {
				count=2;
				choice=choice2;
			}
			
		}
		}
			
		}
		sc.close();

}
}
