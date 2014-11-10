package misc;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 5, 7, 2, 4, 6, 1, 8, 3 };
		recursiveMergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void recursiveMergeSort(int[] a) {
		if (a.length == 0 || null == a) {
			return;
		}
		recursiveMergeSort(a, 0, a.length - 1);
	}

	static void recursiveMergeSort(int[] a, int start, int last) {
		int mid = 0;
		if (last > start) {
			mid = (start + last) / 2;
		} else {
			return;
		}
		recursiveMergeSort(a, start, mid);
		recursiveMergeSort(a, mid + 1, last);
		mergeUsingExtraSpace(a, start, mid, last);
	}

	static void mergeUsingExtraSpace(int[] arr, int start, int mid, int last) {
		int p = start;
		int q = mid + 1;
		int[] temp = new int[last - start + 1];
		int j = 0;

		while (j < temp.length) {
			if (q > last && p <= mid) {
				temp[j] = arr[p];
				j++;
				p++;
				continue;
			}
			if (p > mid && q <= last) {
				temp[j] = arr[q];
				j++;
				q++;
				continue;
			}
			if (arr[p] < arr[q]) {
				temp[j] = arr[p];
				p++;
			} else {
				temp[j] = arr[q];
				q++;
			}
			j++;
		}

		p = start;
		j = 0;
		while (j < temp.length) {
			arr[p++] = temp[j++];
		}
	}
}
