//http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
//http://www.geeksforgeeks.org/printing-longest-common-subsequence/

package dynamicProgramming;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String str1 = "ABCBDAB";
		String str2 = "BDCABA";
		int length1 = str1.length();
		int length2 = str2.length();
		// declare DP table of size (length1 + 1)(length2 + 1)
		int[][] dp = new int[length1 + 1][length2 + 1];
		// initialize DP table of size (length1 + 1)(length2 + 1)
		for (int i = 0; i <= length1; i++) {
			dp[i][length2] = 0;
		}
		for (int i = 0; i <= length2; i++) {
			dp[length1][i] = 0;
		}
		for (int i = length1 - 1; i >= 0; i--) {
			for (int j = length2 - 1; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j + 1];
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j]++;
				}
				if (dp[i + 1][j] > dp[i][j]) {
					dp[i][j] = dp[i + 1][j];
				}
				if (dp[i][j + 1] > dp[i][j]) {
					dp[i][j] = dp[i][j + 1];
				}
			}
		}
		System.out.println(dp[0][0]);

		StringBuffer stbuf = new StringBuffer();

		int i = 0, j = 0;
		while (i < length1 && j < length2) {
			if (dp[i][j] == dp[i + 1][j]) {
				i = i + 1;
			} else if (dp[i][j] == dp[i][j + 1]) {
				j = j + 1;
			} else if (dp[i][j] == dp[i + 1][j + 1] + 1) {
				stbuf.append(str1.charAt(i));
				i = i + 1;
				j = j + 1;
			}
		}
		System.out.println("subsequence : " + stbuf);
	}
}
