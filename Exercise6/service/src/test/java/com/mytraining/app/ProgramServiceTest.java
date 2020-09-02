package com.mytraining.app;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Unit test for ProgramServiceTest class.
 */
public class ProgramServiceTest {
	ProgramService programService = new ProgramService();
	MyFileService myFileService = new MyFileService();
	
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
		myFileService.initDeleteFile(dummyDirectory, dummyName);
	}
	
	//POSITIVE CASE
    @Test
    public void confirmTable_shouldreturnthatATableExist() {
		System.out.println("[POSITIVE]TEST--confirmTable_shouldreturnthatATableExist()");
		assertNotNull(programService.confirmTable("test"));
		
    }
	
	//POSITIVE CASE
	@Test
	public void validateInput_withRequireParametersAndTheTestType_inputtedParametersShouldExists() {
		System.out.println("[POSITIVE]TEST--validateInput_withRequireParameterAndTheTestType_inputtedParametersShouldExists()");
		assertSame(programService.validateInput("Columns", "test"), "true");
		assertSame(programService.validateInput("Rows", "test"), "true");
		assertSame(programService.validateInput("Search", "test"), "true");
		assertSame(programService.validateInput("Menu", "test"), "true");
		assertSame(programService.validateInput("Edit/Row", "test"), "true");
		assertSame(programService.validateInput("Edit/Column", "test"), "true");
		assertSame(programService.validateInput("Edit/Value", "test"), "true");
		assertSame(programService.validateInput("Sort", "test"), "true");
	}
	
	//NEGATIVE CASE
	@Test
	public void validateInput_withWrongParametersAndTheTestType_inputtedParametersShouldNotExists() {
		System.out.println("[NEGATIVE]TEST--validateInput_withWrongParameterAndTheTestType_inputtedParametersShouldNotExists()");
		assertSame(programService.validateInput(" ", "test"), "false");
		assertSame(programService.validateInput("", "test"), "false");
		assertSame(programService.validateInput("RANDOM", "test"), "false");
	}
}
