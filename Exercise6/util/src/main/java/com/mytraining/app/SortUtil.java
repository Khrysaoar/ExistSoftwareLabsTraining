package com.mytraining.app;

import java.util.*;
public class SortUtil{
	public SortUtil() {}
	
	public boolean isSorted(String[] strArr) {
		for(int i = 0; i < strArr.length - 1; i++) {
			if(strArr[i].compareTo(strArr[i + 1]) > 0) { 
				return false;
			}
		}
		
		return true;
	}
	
	public String[] concatKeyValue(String[] arr) {
		String[] conArr = new String[arr.length];
		
		int i = 0;
		
		for(String cell : arr) {
			if(cell == null){
				cell = "___=___";
			}
			cell = cell.substring(0, 3) + cell.substring(4, 7);
			conArr[i] = cell;
			
			i++;
		}
		
		return conArr;
	}
	
	public String[] reformatKeyValue(String[] arr) {
		String[] reArr = new String[arr.length];
		
		int i = 0;
		
		for(String cell : arr) {
			if(cell == null){
				cell = "______";
			}
			cell = cell.substring(0, 3) + "=" + cell.substring(3, 6);
			
			reArr[i] = cell;
			
			i++;
		}
		
		return reArr;
	}
	
	public String[] unsortRow(String[] arr) {
		arr = concatKeyValue(arr);
		Arrays.sort(arr, Collections.reverseOrder());
		arr = reformatKeyValue(arr);
				
		return arr;
	}
	
	public String[] sortRow(String[] arr) {
		arr = concatKeyValue(arr);
		Arrays.sort(arr);
		arr = reformatKeyValue(arr);
		
		return arr;
	}
}