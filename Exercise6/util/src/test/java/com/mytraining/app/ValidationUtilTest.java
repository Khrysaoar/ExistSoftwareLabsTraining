package com.mytraining.app;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for ValidationUtil class.
 */
public class ValidationUtilTest 
{
	ValidationUtil v = new ValidationUtil();
	
    @Test
    public void isThreeChars_withStringandOptionOne_shouldReturnTrue()
    {
        assertTrue( v.isThreeChars("aA", 1) );
    }
	
    @Test
    public void isThreeChars_withFourStringandOptionOne_shouldReturnFalse()
    {
        assertFalse( v.isThreeChars("aA__", 1) );
    }
	
    @Test
    public void isThreeChars_withThreeStringandOptionTwo_shouldReturnTrue()
    {
        assertTrue( v.isThreeChars("aA_", 2) );
    }
	
    @Test
    public void isThreeChars_withFourStringandOptionTwo_shouldReturnFalse()
    {
        assertFalse( v.isThreeChars("aA__", 2) );
    }
	
    @Test
    public void isThreeChars_withStringandOptionThree_shouldReturnFalse()
    {
        assertFalse( v.isThreeChars("aA_", 3) );
    }
	
}
