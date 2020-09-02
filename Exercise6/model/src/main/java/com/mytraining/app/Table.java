package com.mytraining.app;

import java.util.*;
 
public class Table {
	private int rows;
	private int cols;
	private List<String> tableList;
	private Map<String, String> tableMap;
	
	public Table() {}
	
	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public void setTableList(List<String> tableList) {
		this.tableList = tableList;
	}

	public void setTableMap(Map<String, String> tableMap) {
		this.tableMap = tableMap;
	}
	
	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}
	
	public List<String> getTableList() {
		return tableList;
	}
	
	public Map<String, String> getTableMap() {
		return tableMap;
	}
}