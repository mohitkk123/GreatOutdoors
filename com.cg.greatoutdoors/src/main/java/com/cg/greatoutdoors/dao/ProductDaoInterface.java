package com.cg.greatoutdoors.dao;

import java.util.List;

import com.cg.greatoutdoors.dto.Product;

public interface ProductDaoInterface {
	public boolean addProductDoa(Product product);
	public void  deleteProductDoa(String key);
	public List<Product> viewProductsDoa();
	public List<Product> filterProducts(String s);
	public List<Product> searchProducts(String s);
}
