package com.mytraining.app;

//Number verification process
public class ValidationUtil{
	public static boolean isThreeChars(String str, int option) {
		switch(option){
			case 1:
				if (str.length() >= 1 && str.length() <= 3) {
					return true;
				}
				
				return false;
			case 2:
				if (str.length() == 3) {
					return true;
				}
				
				return false;
			default:
				return false;
		}
	}
}