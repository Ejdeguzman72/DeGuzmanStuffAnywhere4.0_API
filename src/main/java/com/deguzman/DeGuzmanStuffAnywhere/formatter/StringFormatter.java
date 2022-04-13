package com.deguzman.DeGuzmanStuffAnywhere.formatter;

import java.util.ArrayList;
import java.util.List;

public class StringFormatter {

	public String formatPhoneNumber(String phone) {
		
		String formatPhoneNumber = "";
		
		if (phone.contains("-")) {
			
			formatPhoneNumber = phone.substring(0,2) + "-" + phone.substring(3,5) + "-" + phone.substring(6,10);
		}
		
		return formatPhoneNumber;
	}
	
	public String formatFirstName(String firstname) {
		char letter = firstname.charAt(0);
		List<Character> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String restOfWord = firstname.substring(1, firstname.length()-1);
		String result = "";
		
		
		if (firstname != null) {
			if (!Character.isUpperCase(letter)) {
				list.add(letter);
				
				for (char c : restOfWord.toCharArray()) {
					list.add(c);
				}
			}
			
			
			
			
			for (Character ch : list) {
				sb.append(ch);
			}
			
			
			
			result = sb.toString();
		}
		
		return result;
	}
	
	public String formatLastName(String lastname) {
		char letter = lastname.charAt(0);
		List<Character> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String restOfWord = lastname.substring(1, lastname.length()-1);
		String result = "";
		
		
		if (lastname != null) {
			if (!Character.isUpperCase(letter)) {
				list.add(letter);
				
				for (char c : restOfWord.toCharArray()) {
					list.add(c);
				}
			}
			
			
			
			
			for (Character ch : list) {
				sb.append(ch);
			}
			
			
			
			result = sb.toString();
		}
		
		return result;
	}
	
	public String formatName(String name) {
		char letter = name.charAt(0);
		List<Character> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String restOfWord = name.substring(1, name.length()-1);
		String result = "";
		
		
		if (name != null) {
			if (!Character.isUpperCase(letter)) {
				list.add(letter);
				
				for (char c : restOfWord.toCharArray()) {
					list.add(c);
				}
			}
			
			
			
			
			for (Character ch : list) {
				sb.append(ch);
			}
			
			
			
			result = sb.toString();
		}
		
		return result;
	}
}
