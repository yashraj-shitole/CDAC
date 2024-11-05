package com.sunbeam;

import java.util.*;


public class Cart {
	
	public static void main(String[] args) throws productNotFoundException {
		
		Scanner sc=new Scanner(System.in);
		
		
		ArrayList<Customer> customerList=new ArrayList<>();
		
		ArrayList<Product> productList=new ArrayList<>();
		productList.add(new Product(101,"Banana","10-12-24",30));
		productList.add(new Product(102,"Pen","11-12-24",5));
		productList.add(new Product(103,"Notebook","10-12-24",60));
		productList.add(new Product(104,"Ball","10-12-24",20)); 
		productList.add(new Product(105,"Pencil","10-12-24",7));
		productList.add(new Product(106,"TV","10-12-24",50000));
		productList.add(new Product(107,"Soap","10-12-24",40));
		
		
		customerList.add(new Customer(1, "Yashraj", "yashraj@gmail.com", "1234"));
		int choice=1;
		
		while( choice !=0) {
			
			System.out.println(	"0. EXIT\n"  
								+ "1. Add Customer \n"
								+ "2. Update Customer Details (Take input from User. E.g. Name, Email) \n"
								+ "3. Sort Product by their Price and PurchaseDate \n"
								+ "4. Search Product by Name (If product not found then throw Custom Exception) \n"
								+ "5. Add Products in a Cart and Generate Bill");
			
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			switch (swichCase.values()[choice]) {
			case exit:
				System.out.println("Thanks for using app...");
				break;
			
			case addCustomer:
					Customer c=new Customer();
					c.acceptCustomer(sc);
					customerList.add(c);
				break;
				
			case updateCustomer:
					System.out.println("Enter id to update customer data");
					int id=sc.nextInt();
					
					Customer c1=new Customer(id);
					int index=-1;
					
					for(int i=0;i<customerList.size();i++) {
						index=customerList.indexOf(c1);
					}
					
					if(index!=-1) {
					customerList.get(index).acceptCustomer(sc);;
					}
					else {
						System.out.println("Customer with given id not present");
					}
					
				break;
				
			case sortProduct:
//					productList.stream().sorted((x,y)->Double.compare(x.getPrice(), y.getPrice())).forEach(System.out::println);
					productList.stream().sorted(Comparator.comparingDouble(Product::getPrice).thenComparing(Product::getPurchase_date)).forEach(System.out::println);
				break;
				
			case searchProduct:
					System.out.println("Enter product name");
					String productName=sc.next();
					if(productList.stream().anyMatch(product -> productName.equals(product.getProduct_name()))) {						
						productList.stream().filter(product->productName.equals(product.getProduct_name())).forEach(System.out::println);
					}else {
						throw new productNotFoundException();
					}
					break;
					
			case addProduct:
				
				System.out.println("Enter id of customer to add product");
				int customerId=sc.nextInt();
				
				System.out.println("Enter id of product to add");
				int productId=sc.nextInt();
			
				for(int i=0;i<customerList.size();i++) {
					if(customerList.get(i).getCustomer_id()==customerId) {
						
						ArrayList<Product> tempList=new ArrayList<>(customerList.get(i).getProductList());
						
						
						for(int j=0;j<productList.size();j++) {
							if(productList.get(j).getProduct_id()==productId) {
								tempList.add(productList.get(j));
							}
						}
						
						customerList.get(i).setProductList(tempList);
												
						System.out.println("Total bill= "+customerList.get(i).getBill());
						
						customerList.get(i).setBill(0);
						
					}	
				}
			
				
				

				break;

			default:
				break;
			}
			
			
		}
		
		
	}

}



enum swichCase{
	exit,
	addCustomer,
	updateCustomer,
	sortProduct,
	searchProduct,
	addProduct
}



class productNotFoundException extends Throwable{
	
	public productNotFoundException() {
		System.out.println("Product Not Found");
	}
	
}
