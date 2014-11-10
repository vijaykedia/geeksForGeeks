//http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
package dynamicProgramming;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		System.out.print("Enter number of elements : ");
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		System.out.println("Enter Numbers :");
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = in.nextInt();
		}

		int[] dp = new int[size];
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (numbers[i] > numbers[j]) {

				}
			}
		}

		in.close();
	}
}
