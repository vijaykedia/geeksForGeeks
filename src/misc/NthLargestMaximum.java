package misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NthLargestMaximum {
	public static void main(String[] args) {
		int[] arr = { 5, 2, 3, 4, 1, 2, 3, 4 };
		System.out.println(nthLargestMaximum(arr, 3));
		System.out.println(nthLargestMaximumWithoutSorting(arr, 3));
	}

	static int nthLargestMaximum(int[] arr, int n) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] == arr[i - 1]) {
				continue;
			} else {
				count++;
			}
			if (count == n - 1) {
				return arr[i - 1];
			}
		}
		return -1;
	}

	static int nthLargestMaximumWithoutSorting(int[] arr, int n) {
		Set<Integer> unique = new HashSet<Integer>();
		for (int i : arr) {
			unique.add(i);
		}

		if (n > unique.size()) {
			return -1;
		}
		Integer[] sorted = new Integer[unique.size()];
		unique.toArray(sorted);
		Arrays.sort(sorted);
		return sorted[sorted.length - n];
	}
}