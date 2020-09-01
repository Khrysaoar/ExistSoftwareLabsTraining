package com.mytraining.app;

import java.util.*;
import org.apache.commons.lang3.*;

class CharacterUtil {
	public String generateRandomChars(int charsNumber) {
		if(charsNumber > 3) {
			charsNumber = 3;
		}
		String randomChars = RandomStringUtils.randomAscii(charsNumber);
		randomChars = randomChars.replaceAll("\\s+","_");
		return randomChars;
	}
}