package com.mytraining.app;

import static org.junit.Assert.*;

import org.junit.*;
import java.util.*;

/**
 * Unit test for TableService class.
 */
public class TableServiceTest {
	TableService tableService = new TableService();
	Table tab;
	String[] dummyArray;
	List<String> dummyList;
	
	@Before
	public void init() {
		tab = new Table();
		tab.setRows(2);
		tab.setCols(5);
		dummyArray = new String[]{"asd=456", "ASD=A}{", ":?K=dfh", "@#$=346", "bsd=4gs", ":?K=dfh", "@#$=346", "ASD=A}{", "asd=456", "bsd=4gs"};
		dummyList =  Arrays.asList(dummyArray);
		tab.setTableList(dummyList);
	}
	
	//POSITIVE CASE
    @Test
    public void createTable_withRowsAndColsAndType_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--createTable_withRowAndColAndType_shouldRunWithoutExceptionOrError()");
		assertNotNull(tableService.createTable(3, 3, "test"));
	}
	
	//NEGATIVE CASE
    @Test
    public void createTable_withNegativeRowsAndColsAndType_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--createTable_withNegativeRowsAndColsAndType_shouldRunWithoutExceptionOrError()");
		try {
			tableService.createTable(-1, -3, "test");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
    }
	
	//NEGATIVE CASE
    @Test
    public void createTable_withZeroRowsAndColsAndType_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--createTable_withZeroRowsAndColsAndType_shouldRunWithoutExceptionOrError()");
		try {
			tableService.createTable(0, 0, "test");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
    }
	
	//NEGATIVE CASE
	@Test(expected=NullPointerException.class)
    public void readFiletoList_withTestTypeParameter_shouldExpectExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--readFiletoList_withTestTypeParameter_shouldExpectExceptionOrError())");
		assertNull(tableService.readFiletoList("test"));
    }
	
	//NEGATIVE CASE
	@Test
    public void readFiletoList_withOutTestTypeParameter_shouldRunWithExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--readFiletoList_withOutTestTypeParameter_shouldRunWithExceptionOrError())");
		try {
			tableService.createTable(3, 3, "test");
			
			//Test Method
			tableService.readFiletoList("");
			fail("Should throw an Exception");
			
		} catch(Exception e) {
			System.out.println("The empty parameter only works when in not testing phase");
		}
    }
	
	//POSITIVE CASE
	@Test
    public void readListToArr_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--readListToArr_shouldRunWithoutExceptionOrError()");
		try {
			tableService.readListToArr("test", tab);
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
		
	//POSITIVE CASE
	@Test
    public void displayTable_shouldReturnTrue() {
		System.out.println("[POSITIVE]TEST--displayTable_shouldReturnTrue()");
		assertTrue(tableService.displayTable("test", tab));
			
    }
	
	//POSITIVE CASE
	@Test
    public void saveUpdatedTable_withTestTypeParameter_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--saveUpdatedTable_withTestTypeParameter_shouldRunWithoutExceptionOrError()");
		try {
			tableService.saveUpdatedTable("test", tab);
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//POSITIVE CASE
	@Test
    public void sortSelectedRow_withSelectedRowAndTestTypeParameter_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--sortableServiceelectedRow_withSelectedRowAndTestTypeParameter_shouldRunWithoutExceptionOrError()");
		assertNotNull(tableService.sortSelectedRow(2, "test", tab));
    }
	
	//NEGATIVE CASE
	@Test
    public void sortSelectedRow_withSelectedRowZeroAndTestTypeParameter_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--sortableServiceelectedRow_withSelectedRowZeroAndTestTypeParameter_shouldRunWithoutExceptionOrError()");
		assertNotNull(tableService.sortSelectedRow(0, "test", tab));
    }
	
	//NEGATIVE CASE
	@Test
    public void sortSelectedRow_withSelectedRowNegativeValueAndTestTypeParameter_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--sortableServiceelectedRow_withSelectedRowNegativeValueAndTestTypeParameter_shouldRunWithoutExceptionOrError()");
		assertNotNull(tableService.sortSelectedRow(-4, "test", tab));
    }
	
	//NEGATIVE CASE
	@Test(expected=NullPointerException.class)
    public void insertRow_withExistingTableInstance_shouldExpectExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--insertRow_withExistingTableInstance_shouldRunWithoutExceptionOrError()");
		assertNotNull(tableService.insertRow(tab));
    }
	
	//NEGATIVE CASE
	@Test(expected=NullPointerException.class)
    public void insertRow_withNewTableInstance_shouldExpectExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--insertRow_withoutCreatingTable_shouldRunWithoutExceptionOrError()");
		assertNotNull(tableService.insertRow(new Table()));
    }
	
	//NEGATIVE CASE
	@Test(expected=NullPointerException.class)
    public void updateCellTable_withSelectedRowandColTableAndNewValue_shouldExpectExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--updateCellTable_withSelectedRowandColTableAndNewValue_shouldResultNullPointerException()");
		assertNotNull(tableService.updateCellTable(2, 2, "_as", tab, "test"));			
    }
	
	//POSITIVE CASE
	@Test
    public void searchTable_withSearchQuery_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--searchTable_withSearchQuery_shouldRunWithoutExceptionOrError()");
		try {
			tableService.searchTable(tab, "4");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//NEGATIVE CASE
	@Test
    public void searchTable_withoutableServiceearchQuery_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--searchTable_withoutableServiceearchQuery_shouldRunWithoutExceptionOrError()");
		try {
			tableService.searchTable(tab, "");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
}
