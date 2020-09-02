package com.mytraining.app;

import static org.junit.Assert.*;

import org.junit.Test;
import org.apache.commons.lang3.CharSetUtils;

/**
 * Unit test for CharacterUtil class.
 */
public class CharacterUtilTest {
	CharacterUtil c = new CharacterUtil();
	
    @Test
    public void generateRandomCharacters_withInputedNumberofChars3_shouldGenerateThreeRandomChars() {
		int noOfRandomChars = c.generateRandomChars(3).length();		
        assertEquals(3, noOfRandomChars);
	}
	
    @Test
	public void generateRandomCharacters_withInputedNumberofCharsMoreThan3_shouldStillGenerateThreeRandomChars() {
		int noOfRandomChars = c.generateRandomChars(6).length();	
        assertEquals(3, noOfRandomChars);
    }
}
