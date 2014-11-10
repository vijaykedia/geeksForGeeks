package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintAllPalindromicAnagrams {
	public static void main(String[] args) {
		String str = "aassddfff";
		System.out.println(countPalindromicAnagrams(str));
		printAllPalindromicAnagrams(str);
	}

	static int countPalindromicAnagrams(String str) {
		if (canCreatePalindrome(str) == false) {
			return 0;
		}
		Map<Character, Integer> _lookup = getCharacterMap(str);
		int numerator = str.length() / 2;
		int result = fact(numerator);
		for (Character c : _lookup.keySet()) {
			result /= fact(_lookup.get(c).intValue() / 2);
		}
		return result;
	}

	static void printAllPalindromicAnagrams(String str) {
		if (canCreatePalindrome(str) == false) {
			System.out.println("No Palindromic String exists");
			return;
		}
		Map<Character, Integer> _lookup = getCharacterMap(str);
		char[] charList = new char[str.length() / 2];
		int i = 0;
		char middle = '\0';
		for (Character c : _lookup.keySet()) {
			int value = _lookup.get(c).intValue();
			if (value % 2 != 0) {
				if (value == 1) {
					middle = c;
					continue;
				}
				middle = c;
			}

			int j = 0;
			while (j < value / 2) {
				charList[i++] = c;
				j++;
			}
		}

		List<String> anagrams = permute(charList);

		// storing the output in set because reverse operation will cause a
		// couple of duplicates
		Set<String> output = new HashSet<String>();
		for (String s : anagrams) {
			output.add(s + middle + new StringBuffer(s).reverse().toString());
			output.add(new StringBuffer(s).reverse().toString() + middle + s);
		}

		// printing the final output
		for (String s : output) {
			System.out.println(s);
		}
	}

	static boolean canCreatePalindrome(String str) {
		Map<Character, Integer> _lookup = getCharacterMap(str);
		int count = 0;
		for (Character c : _lookup.keySet()) {
			if (_lookup.get(c).intValue() % 2 != 0) {
				count++;
			}
		}
		if (count == 1 || count == 0) {
			return true;
		}
		return false;
	}

	static Map<Character, Integer> getCharacterMap(String str) {
		Map<Character, Integer> _lookup = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (_lookup.containsKey(str.charAt(i))) {
				_lookup.put(str.charAt(i), _lookup.get(str.charAt(i)) + 1);
			} else {
				_lookup.put(str.charAt(i), 1);
			}
		}
		System.out.println(_lookup);
		return _lookup;
	}

	static List<String> permute(char[] str) {
		List<String> result = new ArrayList<String>();
		String temp;
		StringBuilder builder;
		for (int i = 0; i < str.length; i++) {
			swap(str, 0, i);
			temp = new String(str);
			builder = new StringBuilder(temp);
			builder.append(temp);

			for (int j = 0; j < str.length; j++) {
				result.add(builder.substring(j, str.length + j));
			}
			swap(str, 0, i);
		}
		return result;
	}

	static void swap(char[] str, int a, int b) {
		char temp = str[a];
		str[a] = str[b];
		str[b] = temp;
	}

	static int fact(int num) {
		if (num == 0 || num == 1) {
			return 1;
		}
		return num * fact(num - 1);
	}
}
