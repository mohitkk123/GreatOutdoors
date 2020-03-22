package com.cg.greatoutdoors.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ValidationServiceTest {
	ValidationService vService;
	@Before
	public void init() {
		vService=new ValidationService();
	}

	@Test
	public void test() {
		assertTrue(vService.validateProduct("123", "mohit", "des", "manu", 234.56));
	}
	
	
	@Test
	public void testProductFail() {
		assertFalse(vService.validateProduct("1234", "mohit@#", "des", "manu", 234.56));
	}
	
	
	@Test
	public void testKey() {
		assertTrue(vService.validateSearchKey("qweefjfejf"));
	}
	
	@Test
	public void testKeyFail() {
		assertFalse(vService.validateSearchKey("qweefjfejf@#"));
	}
	
	
	@Test
	public void testPriceRange() {
		assertTrue(vService.validateSearchPriceRange("5000"));
	}
	
	@Test
	public void testPriceRangeFail() {
		assertFalse(vService.validateSearchPriceRange("5000as"));
	}

}
