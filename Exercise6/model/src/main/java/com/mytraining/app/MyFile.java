package com.mytraining.app;

import java.util.*;

public class MyFile {
	private String currentFileName;
	private final String DIRECTORY_NAME = "GeneratedTable";
	
	public MyFile() {
	}
	
	public void setCurrentFileName(String curFileName) {
		this.currentFileName = curFileName;
	}

	public String getCurrentFileName() {
		return currentFileName;
	}
	
	public String getDirectoryName() {
		return DIRECTORY_NAME;
	}
	
}