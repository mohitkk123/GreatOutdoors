package com.cg.greatoutdoors.service;
import java.util.ArrayList;

import com.cg.greatoutdoors.dao.*;
import com.cg.greatoutdoors.dto.*;
import com.cg.greatoutdoors.exception.*;
import com.cg.greatoutdoors.util.ProductRepository;

public class ProductService implements ProductServiceInterface {
	
	ProductDao pDoa;
	
	public ProductService() {
		 this.pDoa=new ProductDao();
	}
	
	//method call to Doa layer to add products
	
	public boolean addProduct(Product product) 
	{
		
	
		
			boolean feedback=pDoa.addProductDoa(product);
			if(feedback) {
				
							return true;	
				}
			else {
				
					}
			
			
			
		
		
		
		
		
		return false;
		
	}
	
	
	
	//method to call delete function of Doa layer
	
	
	public boolean deleteProduct(String key) throws ProductException {
		
		if (ProductRepository.productsList.isEmpty()) { 
			throw new ProductException("product not found exception");
            
        }else {
        	if(ProductRepository.productsList.containsKey(key)) {
        		pDoa.deleteProductDoa(key);
    			return true;
    		
    		}else {
    			throw new ProductException("product not found exception");
    		}
        	
        }
		
			
			
		
		
	
		
		
	}
	
	//method call to Doa layer to filter Products
	
	
	public ArrayList<Product> filterProduct(String s) throws ProductException{
		ArrayList<Product> products=new ArrayList<Product>();

		if(ProductRepository.productsList.isEmpty()) {
			throw new ProductException("there are no products in the store");
			
		}else {
			products.addAll(pDoa.filterProducts(s));
		}
	
		return products;
		
		
	}
	
	//method call to Doa layer to view All products
	
		public ArrayList<Product> viewAllProduct() throws ProductException{
			ArrayList<Product> products=new ArrayList<Product>();
			if(ProductRepository.productsList.isEmpty()) {
				throw new ProductException("there are no products in the store");
				
			}else {
			
			products.addAll(pDoa.viewProductsDoa());
			
			}
			
			
			return products;
			
			
			
			
			
		}
		
		//method call to Doa layer to search products
		
		public ArrayList<Product> searchProduct(String s) throws ProductException{
	ArrayList<Product> products=new ArrayList<Product>();
	
	if(ProductRepository.productsList.isEmpty()) {
		throw new ProductException("there are no products in the store");
		
	}else {
		products.addAll(pDoa.searchProducts(s));
		
	}
			
			
			
			
			
			return products;
			
			
				
				
				
			}

}
