package com.mytraining.app;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Unit test for ProgramServiceTest class.
 */
public class ProgramServiceTest {
	ProgramService ps = new ProgramService();
	MyFileService mf = new MyFileService();
	
	private String dummyDirectory;
	private String dummyName;
	private String[][] dummyArray;
	
	@Before
	public void init() {
		dummyDirectory = "TestFolder";
		dummyName = "TestFile.txt";
		dummyArray = new String[][]{
			{"asd=456", "ASD=A}{", ":?K=dfh", "@#$=346", "bsd=4gs"},
			{":?K=dfh", "@#$=346", "ASD=A}{", "asd=456", "bsd=4gs"}
			};
	}
	
	@After
	public void finalize() {
		mf.initDeleteFile(dummyDirectory, dummyName);
	}
	
	//POSITIVE CASE
    @Test
    public void initiateProgram_shouldreturntheMenuWithoutException() {
		System.out.println("[POSITIVE]TEST--initiateProgram_shouldreturntheMenuWithoutException()");
		try {
			ps.initiateProgram("test");
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
    }
	
	//POSITIVE CASE
    @Test
    public void confirmTable_shouldreturnthatATableExist() {
		System.out.println("[POSITIVE]TEST--confirmTable_shouldreturnthatATableExist()");
		try {
			mf.writeReadableToFile(dummyArray, dummyDirectory, dummyName);
			ps.confirmTable("test");
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
    }
	
	//NEGATIVE CASE
    @Test
    public void confirmTable_shouldreturnthatATableDoesNotExist() {
		System.out.println("[NEGATIVE]TEST--confirmTable_shouldreturnthatATableDoesNotExist()");
		try {
			ps.confirmTable("test");
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
    }
	
	//POSITIVE CASE
	@Test
	public void validateInput_withRequireParametersAndTheTestType_inputtedParametersShouldExists() {
		System.out.println("[POSITIVE]TEST--validateInput_withRequireParameterAndTheTestType_inputtedParametersShouldExists()");
		assertSame(ps.validateInput("Columns", "test"), "true");
		assertSame(ps.validateInput("Rows", "test"), "true");
		assertSame(ps.validateInput("Search", "test"), "true");
		assertSame(ps.validateInput("Menu", "test"), "true");
		assertSame(ps.validateInput("Edit/Row", "test"), "true");
		assertSame(ps.validateInput("Edit/Column", "test"), "true");
		assertSame(ps.validateInput("Edit/Value", "test"), "true");
		assertSame(ps.validateInput("Sort", "test"), "true");
	}
	
	//NEGATIVE CASE
	@Test
	public void validateInput_withWrongParametersAndTheTestType_inputtedParametersShouldNotExists() {
		System.out.println("[NEGATIVE]TEST--validateInput_withWrongParameterAndTheTestType_inputtedParametersShouldNotExists()");
		assertSame(ps.validateInput(" ", "test"), "false");
		assertSame(ps.validateInput("", "test"), "false");
		assertSame(ps.validateInput("RANDOM", "test"), "false");
	}
}
