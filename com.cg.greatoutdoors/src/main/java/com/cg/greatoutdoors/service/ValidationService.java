package com.cg.greatoutdoors.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.greatoutdoors.util.*;

public class ValidationService {
	Pattern pattern,numbers,alphabets;
	
	
	public ValidationService() {
	 pattern = Pattern.compile("[a-zA-Z0-9 ]*", Pattern.CASE_INSENSITIVE);
	 numbers=Pattern.compile("[0-9]+");
	 alphabets=Pattern.compile("^[a-zA-Z]*$");
	 
	 }
	
	//method validating product inputs
	
	
	public boolean validateProduct(String id,String name,String des,String manufacturer,double price) {
		
		if(ProductRepository.productsList.containsKey(id)) {
			
			return false;
		}else {
			if(numbers.matcher(id).matches() && alphabets.matcher(name).matches() && pattern.matcher(des).matches() && alphabets.matcher(manufacturer).matches() ) {
				if(des.length()>=30) {
				return true;
				
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		
		
		
		
		
		
	}
	
	//method validating Search key inputs
	
	
	public boolean validateSearchKey(String key) {
		if(pattern.matcher(key).matches()) {
			return true;
		}else {
			return false;
		}
	}
	
	//method validating Search Price Range inputs
	
	public boolean validateSearchPriceRange(String key) {
		if(numbers.matcher(key).matches()) {
			return true;
		}else {
			return false;
		}
	}

}
