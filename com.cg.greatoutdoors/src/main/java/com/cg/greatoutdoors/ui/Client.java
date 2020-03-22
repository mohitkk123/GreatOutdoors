package com.cg.greatoutdoors.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import com.cg.greatoutdoors.dto.Product;
import com.cg.greatoutdoors.exception.ProductException;
import com.cg.greatoutdoors.service.ProductService;
import com.cg.greatoutdoors.service.ValidationService;
import com.cg.greatoutdoors.util.ProductRepository;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int flag=0,input;
		
		Scanner sc=new Scanner(System.in);
		Random rand = new Random(); 
		ValidationService vService=new ValidationService();
		ProductService pService=new ProductService();
		
		ArrayList<Product> searchedItems;
		
		
		
		
		do {
			
		
		
		System.out.println("Product Management System");
		System.out.println("...                   ...");
		System.out.println("...                   ...");
		System.out.println("...                   ...");
		
		System.out.println("\n");
		System.out.println("1. Add a Product");
		System.out.println("2. Delete a Product");
		System.out.println("3. Search Products");
		System.out.println("4. Filter Products");
		System.out.println("5. View Products\n");
		
		System.out.println("enter your selection");
		
		try {
		
			input=sc.nextInt();
			
			
			
			if((input!=1) && (input!=2) && (input!=3) && (input!=4) && (input!=5)) {
				System.out.print("Invalid input...try again");
				continue;
			}else {
				
				switch(input) {
					
				case 1:
					
					try {
					System.out.println("add a product");
					
					System.out.println("Enter product name");
					String pName=sc.next();
					System.out.println("Enter product description ps. not less than 30 words");
					String pDescription=sc.next();
					System.out.println("Enter manufacturer name");
					String pManufacturer=sc.next();
					System.out.println("Enter product price");
					String pPrice=sc.next();
					int id=rand.nextInt(1000000);
					
					boolean feedback=vService.validateProduct(id+"", pName, pDescription, pManufacturer, Double.parseDouble(pPrice));
					if(feedback) {
						System.out.println("product valid");
						
						Product product=new Product(pName,pDescription,id+"",pManufacturer, Double.parseDouble(pPrice));
						if(pService.addProduct(product)) {
							System.out.println("product added successfully!\n");
							System.out.println("Product Name :"+pName+" id: "+id+"");
							
						}
						
						
					}else {
						System.out.println("wrong input no special characters");
					}
					
					}catch(NullPointerException e) {
						System.out.println(""+e.toString());
					}catch(InputMismatchException e) {
						System.out.println(""+e.toString());
						
					}catch(Exception e) {
						System.out.println(""+e.toString());
					}
					
					
					
					
					
					
					
					break;
					
				case 2:
					System.out.println("Delete a product\n");
					if(ProductRepository.productsList.isEmpty()) {
						System.out.println("there are no products available right now");
					}else {
						System.out.println("Enter a product id to delete");
						try {
						
							String key=sc.next();
							boolean feedback=vService.validateSearchKey(key);
							if(feedback) {
								try {
								boolean result =pService.deleteProduct(key);
								if(result) {
									System.out.println("product deleted successfully");
									
								}else {
									System.out.println("error while deleting");
								}
								
								}catch(ProductException e) 
								{
									System.out.println(""+e.getMessage());
								}
								
								
							}else {
								System.out.print("bad id..try again ");
							}
						}catch(InputMismatchException e){
							System.out.println(""+e);
							
							
						}
					
					}
					
					
					break;
					
				case 3:
					System.out.println("Search  products");
					
					if(ProductRepository.productsList.isEmpty()) {
						System.out.println("there are no products available right now");
					}else {
						
							System.out.println("enter the product name");
							try {
							String searchInput=sc.next();
							boolean feedback=vService.validateSearchKey(searchInput);
							if(feedback) {
								try {
								searchedItems=pService.searchProduct(searchInput);
								System.out.println("validated");
								
								for(int i=0;i<searchedItems.size();i++) {
									System.out.println((i+1)+": "+searchedItems.get(i).getProductName()+" price : "+searchedItems.get(i).getProductPrice());
								}
								
								}
							
						catch(ProductException e) {
								System.out.println("shsh "+e.getMessage());
								
							}
							
						}
						}catch(InputMismatchException e) {
							System.out.println(""+e.toString());
							
						}catch(Exception e) {
							
						}
						
					}
					
					
					
					break;
					
				case 4:
					System.out.println("Filter  products\n");
					if(ProductRepository.productsList.isEmpty()) {
						System.out.println("there are no products available right now");
					}else {
						System.out.println("Enter maximum price range");
						try {
						String searchInput=sc.next();
						boolean feedback=vService.validateSearchPriceRange(searchInput);
						if(feedback) {
							try {
							searchedItems=pService.filterProduct(searchInput);
							System.out.println(" input validated");
							
							for(int i=0;i<searchedItems.size();i++) {
								System.out.println((i+1)+": "+searchedItems.get(i).getProductName()+" price : "+searchedItems.get(i).getProductPrice());
							}
							
							}catch(ProductException e) {
								System.out.println(""+e.getMessage());
							}
							
						}
						}catch(InputMismatchException e) {
							System.out.println(""+e.toString());
							
						}catch(Exception e) {
							
						}
					
					}
					
					break;
					
					
				case 5:
					System.out.println("View all  products\n");
					try {
					searchedItems=pService.viewAllProduct();
					if(searchedItems!=null) {
					for(int i=0;i<searchedItems.size();i++) {
						System.out.println((i+1)+" id : "+searchedItems.get(i).getProductId()+" Name :"+searchedItems.get(i).getProductName()+" price : "+searchedItems.get(i).getProductPrice());
						System.out.println(("Description : "+searchedItems.get(i).getProductDescription()+" By company : "+searchedItems.get(i).getManufacturer()));
	
	
						
					}
					}
					}catch(ProductException e) {
						System.out.println(""+e.getMessage());
						
					}
					
					break;
					
					
					
				default:
						
					System.out.println("wrong input default\n");
					break;
						
				
				
				}
				
				
			}
		
		}catch(InputMismatchException e) {
			System.out.println("wrong input..please enter an integer");
			
		}
		
		
		
		
		System.out.println("\nEnter 1 to continue or 2 for an exit...");
		try {
		flag=sc.nextInt();
		if((flag!=1) && flag!=2) {
			System.out.println("wrong input");
			continue;
		}
		}catch(InputMismatchException e) {
			System.out.println("wrong input silly");
		}
		
		
		
		
		
		
		
		}while(flag==1);
		

	}
	
	
	

}
