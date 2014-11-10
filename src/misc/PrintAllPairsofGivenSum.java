//http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
//this includes a little modification where input array can have duplicates
package misc;

import java.util.Arrays;

public class PrintAllPairsofGivenSum {
	public static void main(String[] args) {
		int[] arr = { 3, 3, 3, 4, 4, 5, 5, 6, 7, 7 };
		int sum = 10;
		printAllPairsofGivenSum(arr, sum);
	}

	static void printAllPairsofGivenSum(int[] arr, int sum) {
		Arrays.sort(arr);
		int i = 0, j = arr.length - 1;
		while (i < j) {
			if (arr[i] + arr[j] == sum) {
				int front = 1, back = 1;
				while (true) {
					if (i + 1 < j) {
						if (arr[i] == arr[i + 1]) {
							front++;
							i++;
						}
						if (arr[j] == arr[j - 1]) {
							back++;
							j--;
						}
						if (arr[i] != arr[i + 1] && arr[j] != arr[j - 1]) {
							break;
						}
					} else {
						break;
					}
				}
				int k = 1;
				while (k <= front * back) {
					System.out.println(arr[i] + "," + arr[j]);
					k++;
				}
				i++;
				j--;
			} else if (arr[i] + arr[j] < sum) {
				i++;
			} else {
				j--;
			}
		}
	}

}
