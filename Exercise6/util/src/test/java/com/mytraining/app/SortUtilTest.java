package com.mytraining.app;

import static org.junit.Assert.*;

import org.junit.*;
import java.util.*;

/**
 * Unit test for SortUtil class.
 */
public class SortUtilTest {
	private SortUtil s = new SortUtil();
	private String[] dummyArrayStrings1;
	private String[] dummyArrayStrings2;
	private String[] dummyArrayStringsN1;
	private String[] dummyArrayStringsN2;
	private String[] dummyArrayStringsN3;
	private String[] dummyArrayStringsN4;
	private String[] dummyArrayStringsSorted;
	private String[] dummyArrayStringsUnsorted;
	private String[] dummyArrayStringsSortedN;
	private String[] dummyArrayStringsUnsortedN;
	
	@Before
	public void init() {
		//positive cases
		dummyArrayStrings1 = new String[]{"asd=456", "ASD=A}{", ":?K=dfh", "@#$=346", "bsd=4gs"};
		dummyArrayStrings2 = new String[]{"asd456", "ASDA}{", ":?Kdfh", "@#$346", "bsd4gs"};
		dummyArrayStringsSorted = new String[]{":?K=dfh", "@#$=346", "ASD=A}{", "asd=456", "bsd=4gs"};
		dummyArrayStringsUnsorted = new String[]{"bsd=4gs", "asd=456", "ASD=A}{", "@#$=346", ":?K=dfh"};
		
		//negative cases
		dummyArrayStringsN1 = new String[]{"asd=56_", "ASD=A}{", null, "@#$=346", "bsd=4gs"};
		dummyArrayStringsN2 = new String[]{"asd56_", "ASDA}{", "______", "@#$346", "bsd4gs"};
		
		dummyArrayStringsN3 = new String[]{"asd=56_", "ASD=A}{", "___=___", "@#$=346", "bsd=4gs"};
		dummyArrayStringsN4 = new String[]{"asd56_", "ASDA}{", null, "@#$346", "bsd4gs"};
		
		dummyArrayStringsSortedN = new String[]{"@#$=346", "ASD=A}{", "___=___", "asd=56_", "bsd=4gs"};
		dummyArrayStringsUnsortedN = new String[]{"bsd=4gs", "asd=56_", "___=___", "ASD=A}{", "@#$=346"};
	}
	
	
    @Test
    public void concatKeyValue_withArrayOfStringKeyValuePair_shouldReturnTrue() {
		init();
		dummyArrayStrings1 = s.concatKeyValue(dummyArrayStrings1);
		
        assertTrue( Arrays.equals(dummyArrayStrings1, dummyArrayStrings2) );
    }
	
	@Test
    public void concatKeyValue_withArrayOfStringKeyValuePairWithNull_shouldReturnTrue() {
		init();
		dummyArrayStringsN1 = s.concatKeyValue(dummyArrayStringsN1);
		
        assertTrue( Arrays.equals(dummyArrayStringsN1, dummyArrayStringsN2) );
    }
	
    @Test
    public void reformatKeyValue_withArrayOfStringKeyValuePair_shouldReturnTrue() {
		init();
		dummyArrayStrings2 = s.reformatKeyValue(dummyArrayStrings2);
		
        assertTrue( Arrays.equals(dummyArrayStrings2, dummyArrayStrings1) );
    }
	
	@Test
    public void reformatKeyValue_withArrayOfStringKeyValuePairWithNull_shouldReturnTrue() {
		init();
		dummyArrayStringsN4 = s.reformatKeyValue(dummyArrayStringsN4);
		
        assertTrue( Arrays.equals(dummyArrayStringsN4, dummyArrayStringsN3) );
    }
	
    @Test
    public void sortRow_withArrayOfStringKeyValuePair_shouldReturnTrue() {
		init();
		dummyArrayStrings1 = s.sortRow(dummyArrayStrings1);
		
        assertTrue( Arrays.equals(dummyArrayStrings1, dummyArrayStringsSorted) );
    }
	
    @Test
    public void unsortRow_withArrayOfStringKeyValuePair_shouldReturnTrue() {
		init();
		dummyArrayStrings1 = s.unsortRow(dummyArrayStrings1);
		
        assertTrue( Arrays.equals(dummyArrayStrings1, dummyArrayStringsUnsorted) );
    }
	
    @Test
    public void isSorted_withArrayOfStringKeyValuePair_shouldReturnTrue() {
		init();
		
        assertTrue( s.isSorted(dummyArrayStringsSorted));
    } 
	
    @Test
    public void isSorted_withArrayOfStringKeyValuePair_shouldReturnFalse() {
		init();
		
        assertFalse( s.isSorted(dummyArrayStringsUnsorted));
    }
	
    @Test
    public void sortRow_withArrayOfStringKeyValuePairWithNull_shouldReturnTrue() {
		init();
		dummyArrayStringsN1 = s.sortRow(dummyArrayStringsN1);
		
        assertTrue( Arrays.equals(dummyArrayStringsN1, dummyArrayStringsSortedN) );
    }
	
    @Test
    public void unsortRow_withArrayOfStringKeyValuePairWithNull_shouldReturnTrue() {
		init();
		dummyArrayStringsN1 = s.unsortRow(dummyArrayStringsN1);
		
        assertTrue( Arrays.equals(dummyArrayStringsN1, dummyArrayStringsUnsortedN) );
    }
}
