//http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumContiguousSubsequence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter numbers in an array :");
		int size = in.nextInt();
		int[] numbers = new int[size];
		System.out.println("Enter numbers :");
		for (int i = 0; i < size; i++) {
			numbers[i] = in.nextInt();
		}
		int[] dp = new int[size];
		dp[0] = numbers[0];
		for (int i = 1; i < size; i++) {
			dp[i] = numbers[i];
			if (dp[i] < dp[i - 1] + numbers[i]) {
				dp[i] = dp[i - 1] + numbers[i];
			}
		}
		System.out.println(Arrays.toString(dp));
		Arrays.sort(dp);
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[size - 1]);
		in.close();
	}
}
