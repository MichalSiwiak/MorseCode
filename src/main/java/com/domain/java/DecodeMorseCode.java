package com.domain.java;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DecodeMorseCode {

	public static void main(String[] args) {

		String textToCode = "LUBIEPROGRAMOWAC";
		System.out.println(codeMorse(textToCode));

		String textToDecode = ".-.-...---.--.-----.-";

		Set<String> set = new LinkedHashSet<>();
		set = decodeMorse(textToDecode);

		for (String string : set) {
			System.out.println(string);
		}
		System.out.println(set.size());

	}

	public static String codeMorse(String text) {

		StringBuilder result = new StringBuilder();

		for (int character = 0; character < text.length(); character++) {
			result.append(morseCode.get(text.charAt(character) + ""));
		}

		return result.toString();
	}

	public static Set<String> decodeMorse(String text) {

		int i = 0;
		int j = 0;
		boolean check = false;
		Set<String> firstSet = new LinkedHashSet<>();
		firstSet.add(text);
		Set<String> lastSet = new LinkedHashSet<>();

		do {
			for (String string : firstSet) {
				while (i < string.length()) {
					if (string.charAt(i) == '.' || string.charAt(i) == '-') {
						check = true;
						j = i;
						while (j <= string.length() - 1) {
							String temp = string.substring(i, j + 1);
							if (morseDecode.containsKey(temp)) {
								String textNew = string.substring(0, i) + morseDecode.get(temp)
										+ string.substring(j + 1);
								lastSet.add(textNew);
							}
							j++;
						}
						break;
					} else {
						check = false;
					}
					i++;
				}

				if (string.indexOf('-') != -1 | string.indexOf('.') != -1)
					lastSet.remove(string);
			}

			firstSet.clear();
			firstSet.addAll(lastSet);
		} while (check);
		return lastSet;
	}

	static Map<String, String> morseDecode = new LinkedHashMap<String, String>();

	static {
		morseDecode.put(".-", "A");
		morseDecode.put("-...", "B");
		morseDecode.put("-.-.", "C");
		morseDecode.put("-..", "D");
		morseDecode.put(".", "E");
		morseDecode.put("..-.", "F");
		morseDecode.put("--.", "G");
		morseDecode.put("....", "H");
		morseDecode.put("..", "I");
		morseDecode.put(".---", "J");
		morseDecode.put("-.-", "K");
		morseDecode.put(".-..", "L");
		morseDecode.put("--", "M");
		morseDecode.put("-.", "N");
		morseDecode.put("---", "O");
		morseDecode.put(".--.", "P");
		morseDecode.put("--.-", "Q");
		morseDecode.put(".-.", "R");
		morseDecode.put("...", "S");
		morseDecode.put("-", "T");
		morseDecode.put("..-", "U");
		morseDecode.put("...-", "V");
		morseDecode.put(".--", "W");
		morseDecode.put("-..-", "X");
		morseDecode.put("-.--", "Y");
		morseDecode.put("--..", "Z");
	}

	static Map<String, String> morseCode = new LinkedHashMap<String, String>();

	static {
		morseCode.put("A", ".-");
		morseCode.put("B", "-...");
		morseCode.put("C", "-.-.");
		morseCode.put("D", "-..");
		morseCode.put("E", ".");
		morseCode.put("F", "..-.");
		morseCode.put("G", "--.");
		morseCode.put("H", "....");
		morseCode.put("I", "..");
		morseCode.put("J", ".---");
		morseCode.put("K", "-.-");
		morseCode.put("L", ".-..");
		morseCode.put("M", "--");
		morseCode.put("N", "-.");
		morseCode.put("O", "---");
		morseCode.put("P", ".--.");
		morseCode.put("Q", "--.-");
		morseCode.put("R", ".-.");
		morseCode.put("S", "...");
		morseCode.put("T", "-");
		morseCode.put("U", "..-");
		morseCode.put("V", "...-");
		morseCode.put("W", ".--");
		morseCode.put("X", "-..-");
		morseCode.put("Y", "-.--");
		morseCode.put("Z", "--..");
	}

}
