package com.mytraining.app;

import java.util.*;
import org.apache.commons.lang3.*;

public class ProgramService {
	
	private static int valX;
	private static int valY;
	
	private static Table tab;
	
	public ProgramService() {}
	
	//Should test
	public static void initiateProgram(String type) {
		if(type != "test") {
			TableService tabService = confirmTable("");
			
			boolean isMenu = true;
			
			while(isMenu) {
				System.out.println();
				System.out.println("Please select the desired action in the menu by typing the corresponding number:");
				System.out.println(" [1] - Search");
				System.out.println(" [2] - Edit");
				System.out.println(" [3] - Print");
				System.out.println(" [4] - Reset");
				System.out.println(" [5] - New Row");
				System.out.println(" [6] - Sort Row");
				System.out.println(" [7] - Save Table");
				System.out.println(" [8] - Exit");
				
				//validate input
				String selNo = validateInput("Menu", "");
				
				switch (Integer.parseInt(selNo)){
					case 1:
						String getSearchData = validateInput("Search", "");
						
						tabService.searchTable(tab, getSearchData);
						
						continue;
					case 2:
						System.out.println("Please specify the index you want to update.");
						
						String selCol = validateInput("Edit/Column", "");
						String selRow = validateInput("Edit/Row", "");
						String newVal = validateInput("Edit/Value", "");
						
						int newX = Integer.parseInt(selRow);
						int newY = Integer.parseInt(selCol);
						
						tab = tabService.updateCellTable(newX, newY, newVal, tab, "");
						
						continue;
					case 3:
						tabService.displayTable("", tab);
						
						continue;
					case 4:
						System.out.println("Please insert the dimension of the table");
						
						valY = Integer.parseInt(validateInput("Columns", ""));
						valX = Integer.parseInt(validateInput("Rows", ""));
											
						tab = tabService.createTable(valX, valY, "Reset");
						tabService.displayTable("", tab);
						
						continue;
					case 5:
						tab = tabService.insertRow(tab);
						
						valX++;
						
						continue;
					case 6:
						System.out.println("Please select the row by entering numbers from 1 to " + valX + ": ");
						
						int selectedRow = Integer.parseInt(validateInput("Sort", ""));
						
						tab = tabService.sortSelectedRow(selectedRow, "", tab);
						
						continue;
					case 7:
						tabService.saveUpdatedTable("", tab);
						
						continue;
					case 8:
						System.out.println("You're now exiting.");
						
						isMenu = false;
						
						break;
					default:
						System.out.printf("Input not found in choices");
						
						continue;
				}
			}
			
		} else {
			System.out.println("For Testing Only: Will now terminate this method...");
		}
	}
	
	//Should test
	public static TableService confirmTable(String type) {
		MyFileService myFileService = new MyFileService();
		MyFile myFile = new MyFile();
		
		TableService tabService = new TableService();
		
		String directoryName = myFile.getDirectoryName();
		if(type == "test") {
			directoryName = "TestFolder";
		}
		
		if(myFileService.getLatestFilefromDir(directoryName) == null) {
			if(type != "test") {
				//will ask for the dimension of the table
				System.out.println("Please insert the dimension of the table and it will generate random values in its cell.");
			
				//validateInput() will validate the user input if it's acceptable to the program or not.
				valY = Integer.parseInt(validateInput("Columns", ""));
				valX = Integer.parseInt(validateInput("Rows", ""));
			
				System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			
				//Table generator
				tabService.createTable(valX, valY, "Created");
				tab = tabService.readFiletoList("");
				tabService.displayTable("", tab);
				
				return tabService;
			}
			System.out.println("There's no existing table.");
			return tabService;
			
		} else {
			if(type != "test") {
				tab = tabService.readFiletoList("");
				tabService.displayTable("", tab);
				
				valX = tab.getRows();
				valY = tab.getCols();
				
				return tabService;
			}
			System.out.println("There is a table.");
			return tabService;
		}
	}
	
	//Should test
	public static String validateInput(String require, String type) {
		Scanner scanner = new Scanner(System.in);
		boolean valid = false;
		
		String col;
		String row; 
		
		while(!valid) {
			if(require == "Columns") {
				//For Testing
				if(type == "test") {
					System.out.println("TEST SUCCEED require["+ require +"]: Parameter is recorded and it exists in the cases");
					return "true";
				}
				
				System.out.print(require + ": ");
				col = scanner.nextLine();
				//verify if it's a number
				if(StringUtils.isNumeric(col)){
					//will continue the program if it is a number
					return col;
				}
			} else if(require == "Rows") {
				//For Testing
				if(type == "test") {
					System.out.println("TEST SUCCEED require["+ require +"]: Parameter is recorded and it exists in the cases");
					return "true";
				}
				
				System.out.print(require + ": ");
				row = scanner.nextLine();
				
				if(StringUtils.isNumeric(row)){
					return row;
				}
			} else if(require == "Search") {
				//For Testing
				if(type == "test") {
					System.out.println("TEST SUCCEED require["+ require +"]: Parameter is recorded and it exists in the cases");
					return "true";
				}
				
				System.out.print("Please input a character/characters: ");
				String getSearchData = scanner.nextLine();
				
				if(ValidationUtil.isThreeChars(getSearchData, 1)) {
					return getSearchData;
				} else {
					System.out.println("Please enter 1 to 3 characters only!");
					continue;
				}
			} else if(require == "Menu") {
				//For Testing
				if(type == "test") {
					System.out.println("TEST SUCCEED require["+ require +"]: Parameter is recorded and it exists in the cases");
					return "true";
				}
				
				String selNo = "";
				
				System.out.printf("SELECT: ");
				selNo = scanner.nextLine();
				
				if(StringUtils.isNumeric(selNo)){
					//will check if the inputted number is from numbers 1 to 8
					if(Integer.parseInt(selNo) >= 1 && Integer.parseInt(selNo) <=8) {
						return selNo;
					}
					System.out.println("Please enter numbers 1 to 8 only!");
					continue;
				} else {
					System.out.println("Please enter numbers 1 to 8 only!");
					continue;
				}
			} else if(require == "Edit/Row") {
				//For Testing
				if(type == "test") {
					System.out.println("TEST SUCCEED require["+ require +"]: Parameter is recorded and it exists in the cases");
					return "true";
				}
				
				System.out.printf("Row: ");
				String selRow = scanner.nextLine();
				
				if(StringUtils.isNumeric(selRow)){
					if(valX >= Integer.parseInt(selRow)) {
						return selRow;
					} else {
						System.out.println("Please insert a valid range up to " + valX);
						continue;
					}
				} else {
					System.out.println("Please insert a number!");
					continue;
				}
			} else if(require == "Edit/Column") {
				//For Testing
				if(type == "test") {
					System.out.println("TEST SUCCEED require["+ require +"]: Parameter is recorded and it exists in the cases");
					return "true";
				}
				
				System.out.printf("Column: ");
				String selCol = scanner.nextLine();
				
				if(StringUtils.isNumeric(selCol)){
					if(valY >= Integer.parseInt(selCol)) {
						return selCol;
					} else {
						System.out.println("Please insert a valid range up to " + valY);
						continue;
					}
				} else {
					System.out.println("Please insert a number!");
					continue;
				}
			} else if(require == "Edit/Value") {
				//For Testing
				if(type == "test") {
					System.out.println("TEST SUCCEED require["+ require +"]: Parameter is recorded and it exists in the cases");
					return "true";
				}
				
				System.out.printf("Value: ");
				String newVal = scanner.nextLine();
				
				if(ValidationUtil.isThreeChars(newVal, 2)) {
					return newVal;
				}
				System.out.println("Please insert only 3 ASCII Characters!");
				continue;
			} else if(require == "Sort") {
				//For Testing
				if(type == "test") {
					System.out.println("TEST SUCCEED require["+ require +"]: Parameter is recorded and it exists in the cases");
					return "true";
				}
				
				String selectedRow = scanner.nextLine();
				
				if(StringUtils.isNumeric(selectedRow)){
					int selRow = Integer.parseInt(selectedRow);
					if(selRow>valX){
						System.out.println("Please insert a number from 1 to " + valX + " only!");
						continue;
					} else {
						return selectedRow;
					}
				} else {
					System.out.println("Please insert a number!");
					continue;
				}
			}
			//For Testing
			if(type == "test") {
				System.out.println("TEST SUCCEED : Parameter is recorded and it does not exists in the cases");
				return "false";
			}
				
			
			//will repeat this loop if the user input is not a number
			System.out.println("Please insert a number!");
		}
		return "";
	} 
}