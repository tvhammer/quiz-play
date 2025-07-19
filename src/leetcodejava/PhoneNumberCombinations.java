package leetcodejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneNumberCombinations {
	
	public static List<String> letterCombinations(String digits) {
		char[][] code = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
		
		List<char[]> inputDecoded = new ArrayList<>();
		
		for (char c : digits.toCharArray()) {
			var num = Integer.valueOf(String.valueOf(c)) - 2;
			inputDecoded.add(code[num]);
		}
		
		return addCharToCombination(inputDecoded, new ArrayList<>());
		
	}
	
	
	private static List<String> addCharToCombination(List<char[]> in, List<String> previous) {
		var result = new ArrayList<String>();
		if (in.size() > 0) {
			var chars = in.remove(in.size() - 1);
			for (char c : chars) {
				if (previous.size() == 0) {
					result.add(String.valueOf(c));
				} else {
					for (String word : previous) {
						result.add(c + word);
					}
				}
			}
			return addCharToCombination(in, result);
		} else {
			return previous;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(letterCombinations("248"));
	}
}
