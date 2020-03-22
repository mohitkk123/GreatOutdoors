package com.cg.greatoutdoors.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cg.greatoutdoors.dto.*;
import com.cg.greatoutdoors.util.*;
import com.cg.greatoutdoors.exception.*;

public class ProductDao implements ProductDaoInterface{
	
	
	//method to add products to repository
		
		public boolean addProductDoa(Product product)  {
			
			ProductRepository.productList.add(product);
			ProductRepository.productsList.put(product.getProductId(),product);
			
			
			
			
			
			return true;
			
		}
		
		//method to delete products from repository
		
		
	public void  deleteProductDoa(String key)  {
		
		 
	        	
	    			
	    			ProductRepository.productsList.remove(key);
	    	
	        	
	        	
	        }
	  
		
		
		
//		if(ProductRepository.productList.size()>=position) {
//			ProductRepository.productList.remove(position);
//			return true;
//		}else {
//			throw new ProductException("product not found");
//			
//		}
//			
			
			
			
			
			
		
	
	
	
	
	
	
	
	//method to get a List of Products in repository
	
	public List<Product> viewProductsDoa(){
		
		ArrayList<Product> products=new ArrayList<Product>();
	
			for(Map.Entry<String, Product> mapElement:ProductRepository.productsList.entrySet()) {
				products.add(mapElement.getValue());
			}
			return products;
		
		}
		
		
		
		
		
		
	
	
	//method to get a List of filtered Products in repository in terms of Price Range
	
	
public List<Product> filterProducts(String s) {
		
		ArrayList<Product> products=new ArrayList<Product>();
		
		double price=(int)Double.parseDouble(s);
		
		
//		for(int i=0;i<(ProductRepository.productList.size());i++){
//			if(price<((int)ProductRepository.productList.get(i).getProductPrice())) {
//				
//				products.add(ProductRepository.productList.get(i));
//			 }
//			
//			
//		}
		
		
			
			for(Map.Entry<String, Product> mapElement:ProductRepository.productsList.entrySet()) {
				if(((int)mapElement.getValue().getProductPrice())<=price) {
					products.add(mapElement.getValue());	
				}
				
			}
				
				return products;
			
		
		
//			for(int i=0;i<(ProductRepository.productList.size());i++){
//				if(ProductRepository.productList.get(i).getProductName().contains(s)) {
//					
//					products.add(ProductRepository.productList.get(i));
//				 }
			
				
			
		

		
		
	}

//method to seach a List of Products in repository



	public List<Product> searchProducts(String s) {
		
		List<Product> products=new ArrayList<Product>();
		
		
		
			
			for(Map.Entry<String, Product> mapElement:ProductRepository.productsList.entrySet()) {
				if(mapElement.getValue().getProductName().contains(s)) {
					products.add(mapElement.getValue());	
				}
				
			}
			
		
		
//			for(int i=0;i<(ProductRepository.productList.size());i++){
//				if(ProductRepository.productList.get(i).getProductName().contains(s)) {
//					
//					products.add(ProductRepository.productList.get(i));
//				 }
			return products;
				
			
			
			
			
		
		}
		
	




}
