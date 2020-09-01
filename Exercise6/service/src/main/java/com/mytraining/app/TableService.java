package com.mytraining.app;

import java.util.*;
import org.apache.commons.collections4.*;
import org.apache.commons.lang3.*;
 
public class TableService {
	public int row;
	public int col;
	private String key;
	private String value;
	private int noDigitsCol;
	private	int noDigitsRow;
	private String DIR_NAME;
	private Table tab;
	
	Random r = new Random();
	Map map;
	List<String> extractedList;
	List<String> updatedList;
	MyFileService myFileService;
	CharacterUtil genChar;
	SortUtil s;
	String[][] arrayOfRow;
	
	public TableService() {
		instantiateVariables();
	}
	
	public void instantiateVariables() {
		try {
			tab = new Table();
			myFileService = new MyFileService();
			s = new SortUtil();
			genChar = new CharacterUtil();
			extractedList = new ArrayList<String>();
			updatedList = null;
			this.DIR_NAME = myFileService.DIR_NAME;
		} catch(Exception e) {
			System.out.println("Exception is catched");
		}
	}
	
	//Should test
	public void saveUpdatedTable(String type) {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		readListToArr();
		
		if (type == "test") {
			System.out.println("::::::::::::::::::::::::::::TABLE::SAVED[TEST]:::::::::::::::::::::::::::::");
		} else {
			try {
				myFileService.initWriteToFile(arrayOfRow);
				System.out.println(":::::::::::::::::::::::::::::::::TABLE::SAVED:::::::::::::::::::::::::::::::::");
			
			} catch(Exception e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
	}
	
	//should test
	public void sortSelectedRow(int selectedRow, String type) {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		String mode;
		
		readListToArr(); 
		
		updatedList.clear();
		if(selectedRow > 0) {
			selectedRow--;
			
			if(s.isSorted(arrayOfRow[selectedRow])) {
				arrayOfRow[selectedRow] = s.unsortRow(arrayOfRow[selectedRow]);
				mode = "UNSORTED";
			} else {
				arrayOfRow[selectedRow] = s.sortRow(arrayOfRow[selectedRow]);
				mode = "SORTED";
			}
			
			for(int i = 0; i < arrayOfRow.length; i++) {
				for(int h = 0; h < arrayOfRow[i].length; h++) {
					
					int num = 3;
					
					key = arrayOfRow[i][h].substring(0, num);
					value = arrayOfRow[i][h].substring(num+1, arrayOfRow[i][h].length());
					
					updatedList.add(key + "=" + value);
				}
			}
			
			System.out.println(":::::::::::::::::::::::::::::::::ROW:" + mode + ":::::::::::::::::::::::::::::::::");
		} else if(selectedRow == 0) {
			System.out.println("No rows selected!");
		} else {
			System.out.println("Row does not exist!");
		}
		
	}
	
	//should test
	public void insertRow() { 
		row++;
		
		for (int j = 0; j < col; j++){
			int rowNo = row;
			int colNo = j+1;
			
			key = genChar.generateRandomChars(3);
			value = genChar.generateRandomChars(3);
			
			map.put(key,value);
			
			updatedList.add(key + "=" + value);
		}
		
		System.out.println(":::::::::::::::::::::::::::::::::ROW:ADDED:::::::::::::::::::::::::::::::::");
	}
	
	//should test
	public void createTable(int cols, int rows, String type) {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		tab.setRows(rows);
		tab.setCols(cols);
		row = tab.getRows();
		if(row <= 0) {
			row = 1;
		}
		col = tab.getCols();
		if(col <= 0) {
			col = 1;
		}
		
		
		String[][] arrToMap = new String[row*col][2];
		int iterate = 0;
		for (int i = 0; i < row*col; i++) {
			key = genChar.generateRandomChars(3);
			value = genChar.generateRandomChars(3);
				
			arrToMap[iterate][0] = key;
			arrToMap[iterate][1] = value;
			iterate++;
		}
		
		map = MapUtils.putAll(new HashMap(), arrToMap);
		
		System.out.println("Table Created with "+ row +" rows and "+ col +" columns!");
		
		updatedList = new ArrayList<String>();
		
		for(Object entry : map.entrySet()) {
			updatedList.add(entry.toString());
		}
		
		saveUpdatedTable(type);
	}
	
	//should test
	public void resetTable(int cols, int rows) {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		tab.setRows(rows);
		tab.setCols(cols);
		row = tab.getRows();
		col = tab.getCols();
		if(row <= 0) {
			row = 1;
		}
		col = tab.getCols();
		if(col <= 0) {
			col = 1;
		}
		
		String[][] arrToMap = new String[row*col][2];
		int iterate = 0;
		for (int i = 0; i < row*col; i++) {
			key = genChar.generateRandomChars(3);
			value = genChar.generateRandomChars(3);
				
			arrToMap[iterate][0] = key;
			arrToMap[iterate][1] = value;
			iterate++;
		}
		
		map = MapUtils.putAll(new HashMap(), arrToMap);
		
		System.out.println("Table Reset with "+ row +" rows and "+ col +" columns!");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		updatedList = new ArrayList<String>();
		
		for(Object entry : map.entrySet()) {
			updatedList.add(entry.toString());
		}
		
		System.out.println(updatedList);
		readListToArr();
	}
	
	//should test
	public void displayTable(){
		System.out.println(":::::::::::::::::::::::::::::::::DISPLAY:::::::::::::::::::::::::::::::::::");
		
		readListToArr(); 
		
		for(int i = 0; i < arrayOfRow.length; i++) {
			for(int h = 0; h < arrayOfRow[i].length; h++) {								
				System.out.print(" | ");
				System.out.print(arrayOfRow[i][h]);
			}
			
			System.out.print(" | ");
			System.out.println();
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	}
	
	//should test
	public void updateCellTable(int selRow, int selCol, String value) {
		String selCell = "";
		if(selRow < 1 && selCol <1) {
			System.out.println("Cell not found!");
		} else {
			for(int g = 0; g < selRow; g++) {
				for(int h = 0; h < selCol; h++) {
					selCell = arrayOfRow[g][h].substring(0,3);
				}
			}
			
			map.put(selCell, value);
			
			readListToArr();
			
			arrayOfRow[selRow-1][selCol-1] = selCell + "=" + value; 
			
			updatedList.clear();
			
			for(int g = 0; g < row; g++) {
				for(int h = 0; h < col; h++) {
					updatedList.add(arrayOfRow[g][h]);
				}
			}
			
			
			System.out.println(":::::::::::::::::::::::::::::TABLE:UPDATED:::::::::::::::::::::::::::::::::");
		}
	}
	
	//should test
	public void searchTable(String query) {
		if(query != "") {
			System.out.println("::::::::::::::::::::::::::::::::RESULTS::::::::::::::::::::::::::::::::::::");
		
			int k = 0;
			int j = 0;
			int occur = 0;
			
			for(int i = 0; i < updatedList.size(); i++){
				
				int num = 4;
				int lengthVal = updatedList.get(i).length();
				
				String newVal = updatedList.get(i).substring(0, 3) + updatedList.get(i).substring(num, lengthVal);
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
				if(k == col) {
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
	public void readFiletoList(String type) {
		if(type != "test") {
			extractedList = new ArrayList<String>(myFileService.initReadFile(myFileService.DIR_NAME));
		}
		
		updatedList = ListUtils.defaultIfNull(updatedList, extractedList);
		
		map = new HashMap();
		
		for(String cell : updatedList) {
			map.put(cell.substring(0,3), cell.substring(4,7));
		}
	}
	 
	//should test
	public void readListToArr() {
		if(row == 0) {
			row = myFileService.noRows;
			col = myFileService.noCols;
		}
		
		arrayOfRow = new String[row][col];
		
		if(!CollectionUtils.isEmpty(updatedList)) {
			int k = 0;
			int j = 0;
			for(int i = 0; i < updatedList.size(); i++) {
				arrayOfRow[j][k] = updatedList.get(i);
				
				k++;
				
				if(k == col){
					k = 0;
					j++;
				}
			}
		} else {
			System.out.println("No data to read...");
		}
		
	}
}