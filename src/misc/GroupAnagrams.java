package misc;

//http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
	public static void main(String[] args) {
		// String[] input = {"asdf", "dsaf", "abhgdf", "jhbhkhjkb"};
		String[] input = { "cat", "dog", "tac", "god", "act" };
		groupAnagrams(input);
	}

	static List<List<String>> groupAnagrams(String[] input) {
		List<List<String>> output = new ArrayList<List<String>>();
		List<String> next = null;

		String[] sortedStrings = new String[input.length];
		for (int i = 0; i < input.length; i++) {
			char[] temp = input[i].toCharArray();
			Arrays.sort(temp);
			sortedStrings[i] = new String(temp);
		}

		List<Integer> index = new ArrayList<Integer>();

		for (int i = 0; i < input.length; i++) {
			if (index.isEmpty()) {
				index.add(i);
				next = new ArrayList<String>();
				next.add(input[i]);
				output.add(next);
				continue;
			}

			boolean flag = false;
			for (int j = 0; j < index.size(); j++) {
				if (sortedStrings[i].compareTo(sortedStrings[index.get(j)]) == 0) {
					output.get(j).add(input[i]);
					flag = true;
					break;
				}
			}
			if (flag == false) {
				index.add(i);
				next = new ArrayList<String>();
				next.add(input[i]);
				output.add(next);
			}
		}

		System.out.println(output);
		return output;
	}
}
