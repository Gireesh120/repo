package com.swapwindow;

public class ShoppingCart {
	
	private ShoppingCart(){
		
	}
	private static ShoppingCart getinsta=null;
	public static ShoppingCart getinstance() {
		if(getinsta==null) {
			getinsta=new ShoppingCart();
		} return getinsta;
	}
	String [] items= {"food","Toys","pens","book","coke"};
	int [] price= {50,10,5,20,10};
	String [] ires=new String[5];
	int [] pres=new int[5];
	int [] tot=new int[5];
	public  void list() {
		System.out.println();
		System.out.println();
		System.out.println(" PId     Products     Price(RS)");
		for(int i=0;i<items.length;i++){
			for(int j=0;j<price.length;j++) {
				System.out.println(" "+i+"         "+items[i]+"         "+ price[i]);
				break;
			}
		}
		System.out.println();
	}
	public  void add(int id,int qty) {
		System.out.println();
		System.out.println();
		System.out.println("^^    Your Product  :  "+items[id]);
		int add=0;
		pres[id]=add;
		add+=qty;
		pres[id]=add;
		int tot1=price[id];
		tot[id]=tot1*qty;
		System.out.println("^^    Quantity      :    "+qty+" added Sucessfully");
			}
	
	public  void remove(int id) {
		int rem=pres[id];
		rem-=1;
		pres[id]=rem;
		System.out.println(pres[id]);
		System.out.println();
		System.out.println();
		System.out.println("  Your Product "+items[id]+"  has been removed");
		int remo=price[id];
		int temp=tot[id];
		tot[id]=temp-remo;
	}
	public  void viewCart() {
		System.out.println();
		System.out.println();
		System.out.println("   PId      Name       Quantity");
		int total=0;
		for(int y=0;y<pres.length;y++) {
			if(pres[y]>0) {
				System.out.println("    "+y+"       "+items[y]+"         "+pres[y]);
				System.out.println();
				total+=tot[y];
		}
	}
		System.out.println("    Total :  "+ total);

}
}
