package com.mytraining.app;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.*;
import org.junit.rules.ExpectedException;

/**
 * Unit test for MyFileService class.
 */
public class MyFileServiceTest {
	MyFileService myFileService = new MyFileService();
	
	private String dummyDirectory;
	private String dummyName;
	private String[][] dummyArray;
	private List<String> dummyList;
	
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
	
    @Test
    public void writeReadableToFile_withNulls_shouldReturnFalseIfNull() {
        assertFalse(myFileService.writeReadableToFile(null, dummyDirectory, dummyName));
        assertFalse(myFileService.writeReadableToFile(dummyArray, null, dummyName));
        assertFalse(myFileService.writeReadableToFile(dummyArray, dummyDirectory, null));
        assertFalse(myFileService.writeReadableToFile(null, null, null));
    }
	
    @Test
    public void writeReadableToFile_withDummyArrayDirectoryandName_shouldReturnTrueIfWrittenSuccessfully() {
        assertTrue(myFileService.writeReadableToFile(dummyArray, dummyDirectory, dummyName));
    }
	
	@Test
    public void getLatestFilefromDir_withDummyDirectory_shouldReturnTrueIfFileExists() {
		myFileService.writeReadableToFile(dummyArray, dummyDirectory, dummyName);
		File locatedDummyFile = myFileService.getLatestFilefromDir(dummyDirectory);
		
        assertTrue(locatedDummyFile.exists());
    }
	
	@Test
    public void getLatestFilefromDir_withoutDummyDirectory_shouldReturnNullIfFileDoesntExist() {
		File locatedDummyFile = myFileService.getLatestFilefromDir("");
		
        assertNull("File does not exist...", locatedDummyFile);
    }
	
    @Test
    public void readFile_withDummyDirectoryandName_shouldReturnTrueIfReadSuccessfully() {
		dummyList = new ArrayList<>(myFileService.readFile(dummyDirectory, dummyName));
		
        assertNotNull("File exist...", myFileService.readFile(dummyDirectory, dummyName));
        assertNotNull("File Content Successfully transferred to a List...", dummyList);
    }
	
    @Test
    public void readFile_withoutDummyDirectoryandNameAndBoth_shouldReturnTrueIfCatchedSuccessfully() {
        assertTrue(myFileService.readFile(dummyDirectory, "").isEmpty());
        assertTrue(myFileService.readFile("", dummyName).isEmpty());
        assertTrue(myFileService.readFile("", "").isEmpty());
		
    }
	
}
