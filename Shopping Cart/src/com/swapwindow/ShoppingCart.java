package com.swapwindow;
import java.util.*;

public class ShoppingCart {
	
	String[] nameOfItems = new String[5];
	double[] PriceOfProducts = new double[5];
	static Map<Integer,Cart> map = new LinkedHashMap<Integer,Cart>();
	Test t=new Test();

	
	void setProductName() {
		nameOfItems[0]="Food";
		nameOfItems[1]="Toys";
		nameOfItems[2]="Pens";
		nameOfItems[3]="Book";
		nameOfItems[4]="Coke";
	}
	
	
	void setProductPrice() {
		PriceOfProducts[0]=50.00;
		PriceOfProducts[1]=10.00;
		PriceOfProducts[2]=5.00;
		PriceOfProducts[3]=20.00;
		PriceOfProducts[4]=10.00;
	}
	
	
    //showing the list of the products
	void listOfProducts() 
	{
		System.out.println();
		System.out.println();
		System.out.println(" PId     Products     Price(RS)");
		for (int i=0; i<nameOfItems.length; i++)
		{
			for (int j=0; j < PriceOfProducts.length; j++) 
			{
				System.out.println(" "+i+"\t"+nameOfItems[i]+"\t\t"+ PriceOfProducts[i]);
				break;
			}
		}
		
		System.out.println();
	}
	
	//Adding Products to Cart
	void addToCart (int id, Scanner sc) 
	{
		System.out.println();
		System.out.println();
		
		//checking the product id is correct/not
		if ((id >= 0) && (id < (nameOfItems.length)))
		{
			System.out.print(">>     Quantity   : ");
			int qty = sc.nextInt();
			
			//checking the quantity is less than that minimum value 
			if (qty <= 0)
			{
				System.out.println("please bye atleast one /more items\n");
					
			}
			
			//check the quantity is under the maximum number or not
			else if(qty > 100) 
			{
				System.out.println("sorry you can bye upto 100 items only\n");
				
				//we are adding the product at first time
				
			}
			else 
			{
				boolean flag = true;
				if (map.containsKey(id)) 
				{
					Cart c = map.get(id);
					c.ProductQuantity+= qty;
					c.ProductPrice = (PriceOfProducts[id])*(c.ProductQuantity);
					flag = false;
					System.out.println(c.ProductQuantity);
					System.out.println(c.ProductPrice);
				}
				
				//we are adding the product is already exist
				if (flag) 
				{
					Cart c = new Cart ((nameOfItems[id]),qty,(qty*PriceOfProducts[id]));
					map.put (id, c);
					System.out.println("********your product is addded*********");
				}
			}
		}
		else 
		{
			System.out.println("please check the product id\n");
		}
	}
	
	//Remove products From Cart
	void removeFromCart (int id) 
	{
		if (map.containsKey(id)) 
		{
			Cart c = map.get(id);
			c.ProductQuantity = c.ProductQuantity - 1;
			c.ProductPrice = c.ProductPrice - PriceOfProducts[id];
			System.out.println(c.productname +"\t"+"is removed from your cart\n");
		}
		else 
		{
			System.out.println("####your id is not found######please check your id\n");
		}
	}
	
	//showing the Cart with Bill Generation
	void viewCart() 
	{
		System.out.println();
		System.out.println();
		double GrandTotal = 0;
		if (map.isEmpty()) 
		{
			System.out.println("NO ITEMS ARE ADDED TO THE CART\n");
		}
		else 
		{
			System.out.println("PID"+"\t"+"PRODUCT NAME"+"\t"+"PRICE");
			for (Map.Entry m : map.entrySet()) {
				int productid = (int)m.getKey();
				Cart c = (Cart)m.getValue();
				double ProductTotal = c.ProductPrice;
				GrandTotal+= ProductTotal;
				String pname = c.productname;
			System.out.println(productid + "\t" + pname + "\t\t" + ProductTotal);
			}
			System.out.println();
			System.out.println("Grand Total"+"\t\t" + GrandTotal);
		}
	}
}

//class for cartObject
class Cart 
{
	String productname;
	int ProductQuantity;
	double ProductPrice;
	Cart(String productname,int productQuantity,double TotalProductPrice)
	{
		this.productname = productname;
		this.ProductPrice = TotalProductPrice;
		this.ProductQuantity = productQuantity;
	}
	
	
}
