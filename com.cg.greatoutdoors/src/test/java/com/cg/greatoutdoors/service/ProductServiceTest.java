package com.cg.greatoutdoors.service;
import com.cg.greatoutdoors.dto.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import com.cg.greatoutdoors.util.ProductRepository;

public class ProductServiceTest {
ProductService pService;

	
	
	
	@Before
	public void init() {
		pService=new ProductService();
		
		
		
		
	}

	@Test
	public void test() {
		assertTrue(pService.addProduct(new Product("mohit","djdjfg","123","manuf",234.6)));
	}
	
	@Test
	public void viewAll() {
		
		
	
		assertNotNull("object is not null", pService.viewAllProduct());
	}
	
	
	@Test
	public void searchProducts() {
		
		
	
		assertNotNull("object is not null", pService.searchProduct("moh"));
	}
	
	@Test
	public void filterProducts() {
		
		//ProductRepository.productsList.put("123",new Product("mohit","djdjfg","123","manuf",234.6));
	
		assertNotNull("object is not null", pService.filterProduct("5000"));
	}

}
