package com.mytraining.app;

import java.util.*;
import org.apache.commons.collections4.*;
import org.apache.commons.lang3.*;
 
public class TableService {
	private String[][] arrayOfRow;
	
	public TableService() {}
	
	//Should test
	public boolean saveUpdatedTable(String type, Table tab) {
		MyFileService myFileService = new MyFileService();
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		readListToArr(type, tab);
		
		if (type == "test") {
			System.out.println("::::::::::::::::::::::::::::TABLE::SAVED[TEST]:::::::::::::::::::::::::::::");
			return true;
		} else {
			try {
				myFileService.initWriteToFile(arrayOfRow);
				System.out.println(":::::::::::::::::::::::::::::::::TABLE::SAVED:::::::::::::::::::::::::::::::::");
				return true;
			
			} catch(Exception e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			return false;
		}
	}
	
	//should test
	public Table sortSelectedRow(int selectedRow, String type, Table tab) {
		SortUtil sortIt = new SortUtil();
		
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		String mode;
		
		readListToArr(type, tab); 
		
		List<String> tableList = new ArrayList<String>();
		
		if(selectedRow > 0) {
			selectedRow--;
			
			if(sortIt.isSorted(arrayOfRow[selectedRow])) {
				arrayOfRow[selectedRow] = sortIt.unsortRow(arrayOfRow[selectedRow]);
				mode = "UNSORTED";
			} else {
				arrayOfRow[selectedRow] = sortIt.sortRow(arrayOfRow[selectedRow]);
				mode = "SORTED";
			}
			
			for(int i = 0; i < arrayOfRow.length; i++) {
				for(int h = 0; h < arrayOfRow[i].length; h++) {
					
					int num = 3;
					
					String key = arrayOfRow[i][h].substring(0, num);
					String value = arrayOfRow[i][h].substring(num+1, arrayOfRow[i][h].length());
		
					tableList.add(key + "=" + value);
				}
			}
			
			tab.setTableList(tableList);
			
			System.out.println(":::::::::::::::::::::::::::::::::ROW:" + mode + ":::::::::::::::::::::::::::::::::");
			
			return tab;
		} else if(selectedRow == 0) {
			System.out.println("No rows selected!");
			return tab;
		} else {
			System.out.println("Row does not exist!");
			return tab;
		}
		
	}
	
	//should test
	public Table insertRow(Table tab) { 
		CharacterUtil genChar = new CharacterUtil();
		List<String> tableList = new ArrayList<String>(tab.getTableList());
		Map<String, String> map = new HashMap<String, String>(tab.getTableMap());
		
		int row = tab.getRows();
		row++;
		tab.setRows(row);
		
		for (int j = 0; j < tab.getCols(); j++){
			
			String key = genChar.generateRandomChars(3);
			String value = genChar.generateRandomChars(3);
			
			map.put(key,value);
			
			tableList.add(key + "=" + value);
		}
		
		tab.setTableList(tableList);
		tab.setTableMap(map);
		
		System.out.println(":::::::::::::::::::::::::::::::::ROW:ADDED:::::::::::::::::::::::::::::::::");
		
		return tab;
	}
	
	//should test
	public Table createTable(int cols, int rows, String type) {
		CharacterUtil genChar = new CharacterUtil();
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		if(rows <= 0) {
			rows = 1;
		}
		
		if(cols <= 0) {
			cols = 1;
		}
		
		String[][] arrToMap = new String[rows*cols][2];
		
		int iterate = 0;
		for (int i = 0; i < rows*cols; i++) {
			String key = genChar.generateRandomChars(3);
			String value = genChar.generateRandomChars(3);
				
			arrToMap[iterate][0] = key;
			arrToMap[iterate][1] = value;
			iterate++;
		}
		
		map = MapUtils.putAll(new HashMap(), arrToMap);
		
		if(type == "test") {
			type = "Test Created";
		}
		System.out.println("Table "+ type +" with "+ rows +" rows and "+ cols +" columns!");
		
		List<String> tableList = new ArrayList<String>();
		
		for(Object entry : map.entrySet()) {
			tableList.add(entry.toString());
		}
	
		Table tab = new Table();
		tab.setTableList(tableList);
		tab.setTableMap(map);
		tab.setRows(rows);
		tab.setCols(cols);
		
		if(type == "Created") {
			saveUpdatedTable(type, tab);
		} else if(type == "Reset") {			
			readListToArr(type, tab);
		}
		
		return tab;
	}
	
	//should test
	public boolean displayTable(String type, Table tab){
		System.out.println(":::::::::::::::::::::::::::::::::DISPLAY:::::::::::::::::::::::::::::::::::");
		
		readListToArr(type, tab); 
		
		if(arrayOfRow == null) {
			return false;
		}
		
		for(int i = 0; i < arrayOfRow.length; i++) {
			for(int h = 0; h < arrayOfRow[i].length; h++) {								
				System.out.print(" | ");
				System.out.print(arrayOfRow[i][h]);
			}
			
			System.out.print(" | ");
			System.out.println();
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		return true;
	}
	
	//should test
	public Table updateCellTable(int selRow, int selCol, String value, Table tab, String type) {
		Map<String, String> map = new HashMap<String, String>(tab.getTableMap());
		
		String selCell = "";
		if(selRow < 1 && selCol <1) {
			System.out.println("Cell not found!");
			return tab;
		}
		
		for(int g = 0; g < selRow; g++) {
			for(int h = 0; h < selCol; h++) {
				selCell = arrayOfRow[g][h].substring(0,3);
			}
		}
			
		map.put(selCell, value);
			
		readListToArr(type, tab);
			
		arrayOfRow[selRow-1][selCol-1] = selCell + "=" + value; 
			
		List<String> tableList = new ArrayList<String>();
			
		for(int g = 0; g < tab.getRows(); g++) {
			for(int h = 0; h < tab.getCols(); h++) {
				tableList.add(arrayOfRow[g][h]);
			}
		}
			
		tab.setTableList(tableList);
		tab.setTableMap(map);
		
		System.out.println(":::::::::::::::::::::::::::::TABLE:UPDATED:::::::::::::::::::::::::::::::::");
		
		return tab;
		
	}
	
	//should test
	public void searchTable(Table tab, String query) {
		if(query != "") {
			System.out.println("::::::::::::::::::::::::::::::::RESULTS::::::::::::::::::::::::::::::::::::");
			
			List<String> tableList = new ArrayList<String>(tab.getTableList());
			
			
			int k = 0;
			int j = 0;
			int occur = 0;
			
			for(int i = 0; i < tableList.size(); i++){
				
				int num = 4;
				int lengthVal = tableList.get(i).length();
				
				String newVal = tableList.get(i).substring(0, 3) + tableList.get(i).substring(num, lengthVal);
				String arrayStr = new String(newVal);
				
				int index = arrayStr.indexOf(query);
				int noOfCharInCell = 0;
				int s = 0, a = 0, noResults = 0;
				
				int searchRow = j + 1;
				int searchCol = k + 1;
				String result = "Row " + searchRow + " and Column " + searchCol;
				
				if(index >= 0) {
					if(query.length() == 1) {
						char[] letters = new char[arrayStr.length()];
						
						for(int o = 0; o < arrayStr.length(); o++){
							letters[o] = arrayStr.charAt(o);
							if(letters[o] == query.charAt(0)){
								noOfCharInCell++;
							}
						}
						if(noOfCharInCell > 1) {
							for(int l = 0; l < letters.length; l++) {
								if(letters[l] == query.charAt(0)) {
									System.out.println("Element found at "+result);
									occur++;
								}
							}
						} else {
							System.out.println("Element found at "+result);
							occur++;
						}
					} else {
						System.out.println("Element found at "+result);
						occur++;
					}
				}
				k++;
				if(k == tab.getCols()) {
					k = 0;
					j++;
				}
			}
			
			System.out.println("Number of occurences found: " + occur);
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		} else {
			System.out.println("Please enter a query!");
		}
		
	}
	
	//should test
	public Table readFiletoList(String type) {
		MyFileService myFileService = new MyFileService();
		MyFile myFile = new MyFile();
		Table tab = new Table();
		
		List<String> extractedList = new ArrayList<String>();
		
		if(type != "test") {
			extractedList = new ArrayList<String>(myFileService.initReadFile(myFile.getDirectoryName()));
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		for(String cell : extractedList) {
			map.put(cell.substring(0,3), cell.substring(4,7));
		}
		
		tab.setTableList(extractedList);
		tab.setTableMap(map);
		
		return myFileService.getTableProperties(myFile.getDirectoryName(), tab);
	}
	 
	//should test
	public void readListToArr(String type, Table tab) {
		if(tab != null) {
			List<String> tableList = new ArrayList<String>(tab.getTableList());
			
			int row = tab.getRows();
			int col = tab.getCols();
			
			arrayOfRow = new String[row][col];
			
			if(!CollectionUtils.isEmpty(tableList)) {
				int k = 0;
				int j = 0;
				for(int i = 0; i < tableList.size(); i++) {
					arrayOfRow[j][k] = tableList.get(i);
					
					k++;
					
					if(k == col){
						k = 0;
						j++;
					}
				}
			} else {
				System.out.println("No data to read...");
			}
		} else {
			System.out.println("No data to read...");
		}
		
	}
}