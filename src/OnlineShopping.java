import java.util.*;

class Customer {
	int ID = 12345;
	String password = "pema";
	
	void register() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter user ID card number: ");
		int Id = scan.nextInt();
		System.out.print("Enter new pass word: ");
		String Pass = scan.next();
		ID = Id;
		password = Pass;
		
		
	}
	void login() {
 		while(true) {
 			Scanner scan = new Scanner(System.in);

			System.out.println("Please enter ID card number: ");
			int card = scan.nextInt();
			System.out.println("Enter Password: ");
			String ps = scan.next();
			
			if (card == ID && ps.equals(password)) {
				System.out.println("You are successfully logged in.");
				break;
			}else {
				System.out.println("ID or password is incorrect. Please try again.");
				continue;
			}
		}
	}

	
	
}


 
class ShoppingCart {
	//catalog for seller and buyer 
	static ArrayList<Integer> ProductID = new ArrayList<Integer>(2);
	static ArrayList<String> ProductName = new ArrayList<String>(2);
	static ArrayList<String> ProductDesc = new ArrayList<String>(2);
	static ArrayList<Integer> Quantity = new ArrayList<Integer>(2);
	static ArrayList<Integer> ProductPrice= new ArrayList<Integer>(2);
	static ArrayList<String> Manufacturer = new ArrayList<String>(2);
	
	//cart  for buyer
	static ArrayList<Integer> CartID = new ArrayList<Integer>();
	static ArrayList<String> CartName = new ArrayList<String>();
	static ArrayList<String> CartDesc = new ArrayList<String>();
	static ArrayList<Integer> CartQ = new ArrayList<Integer>();
	static ArrayList<Integer> CartPrice= new ArrayList<Integer>();
	static ArrayList<String> CartManufacturer = new ArrayList<String>();
	
	void addProducts() {
		ProductID.add(112);
		ProductID.add(111);
		ProductName.add("Mask");
		ProductName.add("Bag");
		ProductDesc.add("blue black red");
		ProductDesc.add("Capacity 5L   color grey & black");
		Quantity.add(5);
		Quantity.add(7);
		ProductPrice.add(30);
		ProductPrice.add(1500);
		Manufacturer.add("gjr");
		Manufacturer.add("Mountain");
	}
 	 	
	Scanner scan = new Scanner(System.in);
 	void addProductToCatalog() { //will add the product to the catalog
		//seller
		System.out.println("Total items you want to add: ");
		int tot_i = scan.nextInt();
		for (int i =1 ; i <= tot_i; i++) {
			System.out.println("Enter Product ID: ");
			int cata = scan.nextInt();
			System.out.println("Enter Product Name: ");
			String NewName = scan.next();
			System.out.println("Enter product description: ");
			String newDescrip = scan.next();
			System.out.println("Enter quantity: ");
			int newQty = scan.nextInt();
			System.out.println("Enter Unit Price: ");
			int newPrice = scan.nextInt();
			System.out.println("Enter Manufacturer: ");
			String newManu = scan.next();
			
			ProductID.add(cata);
			ProductName.add(NewName);
			ProductDesc.add(newDescrip);
			Quantity.add(newQty);
			ProductPrice.add(newPrice);
			Manufacturer.add(newManu);
			
			
		}
		 
	}
	void showCatalog() { //displays all the product (items) from the shopping cart catalog.
		//seller / buyer
		 
		System.out.println("ID = "+ProductID);
		System.out.println("Nmae = " + ProductName);
		System.out.println("Description = "+ ProductDesc);
		System.out.println("Quantity = "+Quantity);
		System.out.println("Price = " + ProductPrice);
		System.out.println("Manufacturer = " + Manufacturer);
	}
	void editProduct() { //will update/edit the product in the shopping cart catalog.
		// seller
		showCatalog();
		Scanner scan = new Scanner(System.in);
 		System.out.println("Price or Quantity; if Price enter 1 else enter 2");
		int ca = scan.nextInt();
		if (ca == 1) {
			 
			while(true) {
				System.out.println("Amount of which item you want to change(Enter 0 for mask and enter 1 for Bag): ");
				int item = scan.nextInt();
				if(item==0) {
					System.out.print("Enter new Amount: ");
					int newAmount = scan.nextInt();
					ProductPrice.set(item, newAmount);//item = index 
					break;
					
				}
				else if(item==1) {
					System.out.print("Enter new Quantity: ");
					int newQuantity = scan.nextInt();
					ProductPrice.set(item, newQuantity);
					break;
				}
				else {
					System.out.println("Try again!");
					continue;
				}
				 
			}
			 
		} else if(ca==2) {
 			 while(true) {
					System.out.println("Quantity of which item you want to change(Enter 0 for mask and enter 1 for Bag): ");
					int item = scan.nextInt();
					if(item==0) {
						System.out.print("Enter new Amount: ");
						int newAmount = scan.nextInt();
						Quantity.set(item, newAmount);
						break;
						
					}
					else if(item==1) {
						System.out.print("Enter new Quantity: ");
						int newQuantity = scan.nextInt();
						Quantity.set(item, newQuantity);
						break;
					}
					else {
						System.out.println("Try again!");
						continue;
					}
					 
				}
			 
		}
		
		 
 
	}
	void delete() {
		System.out.println("Total items to be removed:");
		int totalItems= scan.nextInt();
		for (int i =0; i<=totalItems; i++) {
			System.out.println("Which item do you want to remove(Enter Product ID):");
			int str = scan.nextInt();
			if (str == 112) {
				ProductID.remove(0);
 				ProductName.remove(0);
 				ProductDesc.remove(0);
 				Quantity.remove(0);
 				ProductPrice.remove(0);
 				Manufacturer.remove(0);
 				break;
 			}else if(str==111) {
				ProductID.remove(1);
				ProductName.remove(1);
				ProductDesc.remove(1);
				Quantity.remove(1);
				ProductPrice.remove(1);
				Manufacturer.remove(1);
				break;

			}else {
				System.out.println("No item found with that Product ID. Try again!");
				continue;
			}
		}
 
	}
	
	void addToCart() { //method, will add the product to the cart.
		while(true) {
			Scanner nu = new Scanner(System.in);
			System.out.println("Enter Product ID you want to buy: ");
			int z = nu.nextInt();
			if (z == 112) {
				System.out.println("Enter Quantity: ");
				int qty = nu.nextInt();
				if (qty> 5 || qty <0) {
					 System.out.println("Insufficient quantity.");
				}else {
					CartID.add(z);
					CartName.add(ProductName.get(0));
					CartDesc.add(ProductDesc.get(0));
					CartQ.add(qty);
					CartPrice.add(ProductPrice.get(0));
					CartManufacturer.add(Manufacturer.get(0));
					
					Quantity.set(0,Quantity.get(0)-qty);
					break;
				}
			}else if(z ==111) {
				System.out.println("Enter Quantity: ");
				int qty = nu.nextInt();
			
				if (qty> 7 || qty <0) {
					System.out.println("Insufficient quantity.");
					 
				}else {
					CartID.add(z);
					CartName.add(ProductName.get(1));
					CartDesc.add(ProductDesc.get(1));
					CartQ.add(qty);
					CartPrice.add(ProductPrice.get(1));
					CartManufacturer.add(Manufacturer.get(1));
					
					Quantity.set(1,Quantity.get(1)-qty);

					break;
				}
			}else {
				System.out.println("Invalid input. Try again!");
				continue;
			}
		}
		
	}
//	void buyItems() {
//		System.out.println("Address: ");
//		String address = scan.next();
//		System.out.println("Phone number must be exactly 8!!");
//		
//		System.out.println("Mobile Number: ");
//		int num = scan.nextInt();
////		if (num.length() == 8) {
////			
////		}else {
////			
////		}
//		
//		System.out.println("Are you sure that you want to buy the product? if YES enter 1 or if NO enter 0:");
//		int confirmation = scan.nextInt();
//		if (confirmation == 1) {
//			System.out.println("Item name");
//			
//			
//		}else {
////			exit()
//		}
// 
//
//	}
	
	void removeFromCart() {
	 
		Scanner num = new Scanner(System.in);
		System.out.println("Enter the product ID you want to remove: ");
		int id = num.nextInt();
		int i =0;
		while(i >= 0) {
			if (CartID.get(i)==id) {
				Quantity.set(i,Quantity.get(i)+CartQ.get(i));
				CartID.remove(CartID.get(i));
				CartName.remove(CartName.get(i));
				CartDesc.remove(CartDesc.get(i));
				CartQ.remove(CartQ.get(i));
				CartPrice.remove(CartPrice.get(i));
				CartManufacturer.remove(CartManufacturer.get(i));
				System.out.println("Removed successfully.");
				break;
			}
			else if(CartID.get(i)!= id){
				System.out.println("Incorrect ID. Try again");
				i+=1;
				
			}
			
		}
		 
	}
		

	
	void showCart() {
		//method will display all the products (items) from the shopping cart. These items have been added by the customer.
		//buyer
		if (CartID.size()==0) {
			System.out.println("No items available in your cart.");
			System.out.println("--------------------------------");
		
		}else {
		System.out.println("Items in your Cart");
		System.out.println("Produt ID: "+CartID);
		System.out.println("Product Name: "+CartName);
		System.out.println("Product Description: "+CartDesc);
		System.out.println("Quantity: "+CartQ);
		System.out.println("Price: "+CartPrice);
		System.out.println("Manufacturer: "+CartManufacturer);
		}
	}
	
			
	

}

public class OnlineShopping {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShoppingCart pr = new ShoppingCart();
		pr.addProducts();
		System.out.println("WELCOME TO SHOPPING CART");
		Scanner scan = new Scanner(System.in);
		System.out.println("Do you have an user account? if Yes enter 1, if No enter 0: ");
		int user_details = scan.nextInt();
		Customer obj = new Customer();
 		
		boolean t = false;//login or new account
 		boolean z = false;//buyer or seller

		while(true) {
			if (user_details == 1) {
				obj.login();
				t = true;

				break;
 			}else if (user_details == 0) {
				while(true) {
					System.out.println("Do you want to create account. If yes enter 1 else enter 0");
					int dd = scan.nextInt();
					if (dd == 1) {
						obj.register();
						break;
					}else if (dd == 0 ) {
						System.out.println("Visit us again.");
						z = true;
						t=true;
						break;
					}else {
						System.out.println("Try again please.");
						continue;
					}
				}
				break;
			}
			else {
				System.out.println("Please try again.");
				continue;
			}
		}
		 
 		while (t == false) {
 			System.out.println("Enter 1 if u want to login into your new account. Else enter 0 to exit.");
 			int one = scan.nextInt();
			if (one == 1) {
				obj.login();
				break;
	
			}else if (one == 0 ) {
				System.out.println("Visit us again.");
				t= true;
				z =true;
				break;
			}else {
				System.out.println("Please enter right option.");
				continue;
			}
		}
 		
  		while (z == false) {
	 		System.out.println("Do you want to buy or sell?? If Seller enter 1 Buyer 0: ");
	 		int bas = scan.nextInt();
	 		 
	 		if (bas == 1) {
	 			Scanner q = new Scanner(System.in);
	 			System.out.println("1 Add to catalog\n2 edit catalog\n3 Show Catalog\n4 Delete Item In Catalog");
	 			int opt = q.nextInt();
	 			if (opt == 1) {
	 				pr.addProductToCatalog();
	 				continue;
	 			}
	 			else if(opt == 2) {
	 				pr.editProduct();
	 				continue;
	 			}
	 			else if(opt == 3) {
	 				pr.showCatalog();
	 				continue;
	 			}else if(opt == 4) {
	 				pr.delete();
	 			}
	 			else {
	 				System.out.println("Enter valid input.");
	 				continue;
	 			}

	 		
	 		}else if(bas == 0) {
	 			while (true) {
 	 				System.out.println("1 show catalog\n2 Add to Cart\n3 Remove Item from Cart\n4 Clear Cart\n5 Show Cart\n6 Total Price\n7 Payable Amount\n8 Print Invoice\n9 Exit");
	 				int num = scan.nextInt();
	 				
	 				if(num==1) {
	 					pr.showCatalog();
		 				continue;
	 				}else if(num==2) {
	 					pr.addToCart();
	 					continue;
	 				}else if(num==3) {
	 					pr.removeFromCart();
	 				}else if(num==4) {
	 					
	 				}else if(num==5) {
	 					pr.showCart();
	 					continue;
//	 				}else if(num==6) {
//	 					
//	 				}else if (num ==7) {
//	 					
//	 				}else if(num==8) {
	 					
	 				}else if(num==9) {
	 					System.out.println("Thank u!!!!");
	 					break;
	 				}else {
	 					System.out.println("Please enter valid Input.");
	 				}
	 			}
	 		}break;
	 		
	 		
 		}
 		
		
	}

}
