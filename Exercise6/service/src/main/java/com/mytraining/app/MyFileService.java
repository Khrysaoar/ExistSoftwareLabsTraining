package com.mytraining.app;

import java.io.*;
import java.util.*;
import org.apache.commons.io.input.AutoCloseInputStream;
import org.apache.commons.io.FileUtils;

public class MyFileService {
	public int noRows;
	public	int noCols;
	private String currentFileName;
	private List<String> arrList;
	public final String DIR_NAME;
	Table tab;
	MyFile myFile;
	
	public MyFileService() {
		myFile = new MyFile();
		DIR_NAME = myFile.getDirectoryName();
		arrList = new ArrayList<String>();
	}
	
	//should test
	public File getLatestFilefromDir(String directoryName) {
		File dir = new File(directoryName);
		File[] files = dir.listFiles();
		
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
	
	public void initWriteToFile(String[][] arrTable)  {
		myFile.setCurrentFileName("ReadableTable.txt");
		currentFileName = myFile.getCurrentFileName();
		
		boolean isCreated = writeReadableToFile(arrTable, DIR_NAME, currentFileName);
	}
	
	//should test
	public boolean writeReadableToFile(String[][] arrTable, String dir, String curFile) {
		if(arrTable != null && dir != null && curFile != null) {
			String filePath = dir + "\\" + curFile;
		
			try {
				File file = new File(filePath);
			
				initDeleteFile(dir, curFile);

				if(file.length() == 0) {
					for(int i = 0; i < arrTable.length; i++) {
						for(int h = 0; h < arrTable[i].length; h++) {
							FileUtils.writeStringToFile(file, arrTable[i][h], true);
							FileUtils.writeStringToFile(file, " | ", true);
						}
				
						FileUtils.writeStringToFile(file, "\n", true);
					}
			
					System.out.println("Display data is saved at " + curFile);
				}
			
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			} catch (NullPointerException e) {
				System.out.println("List is null...");
			}
			return true;
		}	
		return false;
	}
	
	public List initReadFile(String directoryName) {
		myFile.setCurrentFileName(getLatestFilefromDir(DIR_NAME).toString().replace(DIR_NAME+"\\",""));
		currentFileName = myFile.getCurrentFileName();
		
		return readFile(directoryName, currentFileName);
	}
	
	public void initDeleteFile(String dir, String curFile) {
		String filePath = dir + "\\" + curFile;
		
		File file = new File(filePath);
			
		FileUtils.deleteQuietly(file);
	} 
	
	//should test
	public List readFile(String directoryName, String curFileName) {
		Scanner scanner;
		
		String currentDirectory = System.getProperty("user.dir");
		
		tab = new Table();
		try {
			File readFile = new File(currentDirectory + "\\" 
									+ directoryName + "\\" 
									+ curFileName);
			
			List<String[]> listWords = new ArrayList<>();
			List<String> readLines = FileUtils.readLines(readFile);
			
			readLines.forEach(i -> listWords.add(i.toString().replace(" | ", " ").split(" ")));
			
			noRows = 0;
			for(String[] rows : listWords) {
				noRows++;
				
				noCols = 0;
				for(String cell : rows) {
					noCols++;
					
					arrList.add(cell);
				}
			}
			
			tab.setRows(noRows);
			tab.setCols(noCols);
			
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist...");
		} catch (IOException e) {
			System.out.println("This is not a list...");
		} 
		
		return arrList;
		
	}
	
}