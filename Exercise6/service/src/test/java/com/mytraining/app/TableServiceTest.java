package com.mytraining.app;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Unit test for TableService class.
 */
public class TableServiceTest {
	TableService ts = new TableService();
	
	//POSITIVE CASE
    @Test
    public void createTable_withRowsAndColsAndType_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--createTable_withRowAndColAndType_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(3, 3, "test");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
    }
	
	//NEGATIVE CASE
    @Test
    public void createTable_withNegativeRowsAndColsAndType_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--createTable_withNegativeRowsAndColsAndType_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(-1, -3, "test");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
    }
	
	//NEGATIVE CASE
    @Test
    public void createTable_withZeroRowsAndColsAndType_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--createTable_withZeroRowsAndColsAndType_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(0, 0, "test");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
    }
	
	//POSITIVE CASE
	@Test
    public void readFiletoList_withTestTypeParameter_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--readFiletoList_withTestTypeParameter_shouldRunWithoutExceptionOrError())");
		try {
			ts.createTable(3, 3, "test");

			//Test Method
			ts.readFiletoList("test");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
    }
	
	//NEGATIVE CASE
	@Test
    public void readFiletoList_withOutTestTypeParameter_shouldRunWithExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--readFiletoList_withOutTestTypeParameter_shouldRunWithExceptionOrError())");
		try {
			ts.createTable(3, 3, "test");
			
			//Test Method
			ts.readFiletoList("");
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
			ts.readListToArr();
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
		
	//POSITIVE CASE
	@Test
    public void displayTable_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--displayTable_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(3, 3, "test");
			
			//Test Method
			ts.displayTable();
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//NEGATIVE CASE
	@Test
    public void displayTable_withoutCreateTable_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--displayTable_withoutCreateTable_shouldRunWithoutExceptionOrError()");
		try {
			//Commented for negative case
			//ts.createTable(3, 3, "test");
			
			//Test Method
			ts.displayTable();
			
		} catch(Exception e) {
			fail("Should initiate createTable() method first before displaying it.");
		}
			
    }
	
	//POSITIVE CASE
	@Test
    public void saveUpdatedTable_withTestTypeParameter_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--saveUpdatedTable_withTestTypeParameter_shouldRunWithoutExceptionOrError()");
		try {
			ts.saveUpdatedTable("test");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//POSITIVE CASE
	@Test
    public void sortSelectedRow_withSelectedRowAndTestTypeParameter_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--sortSelectedRow_withSelectedRowAndTestTypeParameter_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(3, 3, "test");
			
			//Test Method
			ts.sortSelectedRow(2, "test");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}	
    }
	
	//NEGATIVE CASE
	@Test
    public void sortSelectedRow_withSelectedRowZeroAndTestTypeParameter_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--sortSelectedRow_withSelectedRowZeroAndTestTypeParameter_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(3, 3, "test");
			
			//Test Method
			ts.sortSelectedRow(0, "test");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}	
    }
	
	//NEGATIVE CASE
	@Test
    public void sortSelectedRow_withSelectedRowNegativeValueAndTestTypeParameter_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--sortSelectedRow_withSelectedRowNegativeValueAndTestTypeParameter_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(3, 3, "test");
			
			//Test Method
			ts.sortSelectedRow(-4, "test");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}	
    }
	
	//POSITIVE CASE
	@Test
    public void insertRow_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--insertRow_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(3, 3, "test");
			ts.insertRow();
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//NEGATIVE CASE
	@Test
    public void insertRow_withoutCreatingTable_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--insertRow_withoutCreatingTable_shouldRunWithoutExceptionOrError()");
		try {
			//ts.createTable(3, 3, "test");
			ts.insertRow();
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//POSITIVE CASE
	@Test
    public void resetTable_withRowsAndCols_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--resetTable_withRowsAndCols_shouldRunWithoutExceptionOrError()");
		try {
			ts.resetTable(4, 4);
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//NEGATIVE CASE
	@Test
    public void resetTable_withZeroRowsAndCols_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--resetTable_withZeroRowsAndCols_shouldRunWithoutExceptionOrError()");
		try {
			ts.resetTable(0, 0);
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//NEGATIVE CASE
	@Test
    public void resetTable_withNegativeRowsAndCols_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--resetTable_withNegativeRowsAndCols_shouldRunWithoutExceptionOrError()");
		try {
			ts.resetTable(-90, -9);
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//POSITIVE CASE
	@Test
    public void updateCellTable_withSelectedRowandColandNewValue_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--updateCellTable_withSelectedRowandColandNewValue_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(3, 3, "test");
			ts.updateCellTable(2, 2, "TST");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//NEGATIVE CASE
	@Test
    public void updateCellTable_withZeroSelectedRowandColandNewValue_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--updateCellTable_withZeroSelectedRowandColandNewValue_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(3, 3, "test");
			ts.updateCellTable(0, 0, "TST");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//NEGATIVE CASE
	@Test
    public void updateCellTable_withNegativeSelectedRowandColandNewValue_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--updateCellTable_withNegativeSelectedRowandColandNewValue_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(3, 3, "test");
			ts.updateCellTable(-90, -9, "TST");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//POSITIVE CASE
	@Test
    public void searchTable_withSearchQuery_shouldRunWithoutExceptionOrError() {
		System.out.println("[POSITIVE]TEST--searchTable_withSearchQuery_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(7, 7, "test");
			ts.searchTable("4");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
	
	//NEGATIVE CASE
	@Test
    public void searchTable_withoutSearchQuery_shouldRunWithoutExceptionOrError() {
		System.out.println("[NEGATIVE]TEST--searchTable_withoutSearchQuery_shouldRunWithoutExceptionOrError()");
		try {
			ts.createTable(7, 7, "test");
			ts.searchTable("");
			
		} catch(Exception e) {
			fail("Should not have thrown an exception");
		}
			
    }
}
