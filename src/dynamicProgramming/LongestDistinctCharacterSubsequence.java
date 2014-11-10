//http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
//http://www.codechef.com/NOV14/problems/DISCHAR

//limiting input string contains only small alphabets
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestDistinctCharacterSubsequence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int testCase = Integer.parseInt(line);
		while (testCase > 0) {
			line = br.readLine();
			longestDistinctCharacterSubsequence(line);
		}
	}

	static void longestDistinctCharacterSubsequence(String str) {
		int lengthOfString = 0;
		// return if input string is null or length is 0
		if (null == str || (lengthOfString = str.length()) == 0) {
			return;
		}

		/*
		 * initialize each element of dp table to -1, this table will store the
		 * index of the last occurrence of the character as well as the length
		 * of the subsequence Initialized this table with -1
		 */
		int[] dp = new int[26];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}

		int tempIndex = 0;
		int maxLength = 0;
		int startingIndex = 0;

		for (int i = 0; i < lengthOfString; i++) {
			if (dp[str.charAt(i) - 'a'] < 0) {
				dp[str.charAt(i) - 'a'] = i;

				if (i - tempIndex > maxLength) {
					maxLength = i - tempIndex;
					startingIndex = tempIndex;
				}
			} else {
				if (dp[str.charAt(i) - 'a'] >= tempIndex) {
					tempIndex = ++dp[str.charAt(i) - 'a'];
				} else if (dp[str.charAt(i) - 'a'] < tempIndex) {
					if (i - tempIndex > maxLength) {
						maxLength = i - tempIndex;
						startingIndex = tempIndex;
					}
				}
				dp[str.charAt(i) - 'a'] = i;
			}
		}
		System.out.println(str.substring(startingIndex, maxLength
				+ startingIndex + 1));
	}
}
