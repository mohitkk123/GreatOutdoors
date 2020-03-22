package com.cg.greatoutdoors.service;

import java.util.ArrayList;

import com.cg.greatoutdoors.dto.Product;
import com.cg.greatoutdoors.exception.ProductException;

public interface ProductServiceInterface {
	public boolean addProduct(Product product) ;
	public boolean deleteProduct(String key) throws ProductException;
	
	public ArrayList<Product> filterProduct(String s) throws ProductException;
	public ArrayList<Product> viewAllProduct() throws ProductException;
	public ArrayList<Product> searchProduct(String s) throws ProductException;

}
