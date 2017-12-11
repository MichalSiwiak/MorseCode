package com.domain.java;

import static org.junit.Assert.*;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

public class DecodeMorseCodeTest {

	@Test
	public void test1() {

		Set<String> set = new LinkedHashSet<>();
		String textInput = ".-.-...---.--.-----.-";
		String textOutput = "ALAMAKOTA";
		set = DecodeMorseCode.decodeMorse(textInput);
		assertEquals(true, set.contains(textOutput));
	}

	@Test
	public void test2() {

		String textInput = "LUBIEPROGRAMOWAC";
		String textOutput = ".-....--.......--..-.-----..-..------.--.--.-.";
		assertEquals(textOutput, DecodeMorseCode.codeMorse(textInput));
	}

}
