package misc;

//http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

public class SearchNumberInRotatedArray {
	public static void main(String[] args) {

		int[] arr = { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		System.out.println(getIndexInRotatedArray(arr, 9));

		int[] arr1 = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		System.out.println(getIndexInRotatedArray(arr1, 8));

		int[] arr2 = { 3, 4, 5, 1, 2 };
		System.out.println(getIndexInRotatedArray(arr2, 4));
		System.out.println(getIndexInRotatedArray(arr2, 1));

		int[] arr3 = { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println(getIndexInRotatedArray(arr3, 0));

		int[] arr4 = { 2, 3, 0, 2, 2, 2, 2, 2, 2, 2 };
		System.out.println(getIndexInRotatedArray(arr4, 3));
		System.out.println(getIndexInRotatedArray(arr4, 0));
		System.out.println(getIndexInRotatedArray(arr4, 2));

		int[] arr5 = { 1, 2, 3, 4 };
		System.out.println(getIndexInRotatedArray(arr5, 3));

		int[] arr6 = { 3, 4, 4, 5, 5, 1, 1, 2, 2, 3 };
		System.out.println(getIndexInRotatedArray(arr6, 9));
	}

	static int getIndexInRotatedArray(int[] arr, int number) {
		int pivot = findPivot(arr, 0, arr.length - 1);
		if (pivot == -1) {
			return findElement(arr, 0, arr.length - 1, number);
		}
		if (number > arr[pivot]) {
			return -1;
		} else if (number == arr[pivot]) {
			return pivot;
		} else if (number >= arr[0]) {
			return findElement(arr, 0, pivot - 1, number);
		} else {
			return findElement(arr, pivot + 1, arr.length - 1, number);
		}
	}

	static int findPivot(int[] arr, int start, int end) {
		if (arr[start] < arr[end]) {
			return -1;
		}
		if (start == end) {
			return start;
		}
		int mid = (start + end) / 2;

		if (mid < end && arr[mid] > arr[mid + 1]) {
			return mid;
		}
		if (mid > start && arr[mid - 1] > arr[mid]) {
			return mid - 1;
		}

		if (arr[mid] > arr[end]) {
			return findPivot(arr, mid + 1, end);
		} else {
			return findPivot(arr, start, mid - 1);

		}
	}

	static int findElement(int[] arr, int start, int end, int number) {
		if (end < start) {
			return -1;
		}
		if (end == start && arr[start] == number) {
			return start;
		}
		int mid = (start + end) / 2;
		if (arr[mid] == number) {
			return mid;
		} else if (arr[mid] < number) {
			return findElement(arr, mid + 1, end, number);
		} else {
			return findElement(arr, start, mid - 1, number);
		}
	}

	static boolean searchNumberInRotatedArray(int[] arr, int n) {
		return searchNumberInRotatedArray(arr, 0, arr.length - 1, n);
	}

	static boolean searchNumberInRotatedArray(int[] arr, int start, int end,
			int number) {
		if (start > end) {
			return false;
		}

		if (start == end) {
			if (arr[start] != number) {
				return false;
			} else {
				return true;
			}
		}

		while (true) {
			if (arr[start] == arr[start + 1]) {
				start++;
				continue;
			}
			if (arr[end] == arr[end - 1]) {
				end--;
				continue;
			}
			if (arr[start] == arr[end]) {
				if (arr[start] == number) {
					return true;
				} else {
					start++;
					end--;
				}
			} else {
				break;
			}
		}

		int mid = (start + end) / 2;
		if (arr[mid] == number) {
			return true;
		}

		if (arr[start] < arr[end]) {
			if (number < arr[mid]) {
				return searchNumberInRotatedArray(arr, start, mid - 1, number);
			} else {
				return searchNumberInRotatedArray(arr, mid + 1, end, number);
			}
		}

		if (arr[mid] < arr[end]) {
			if (number > arr[mid] && number <= arr[end]) {
				return searchNumberInRotatedArray(arr, mid + 1, end, number);
			} else {
				return searchNumberInRotatedArray(arr, start, mid - 1, number);
			}
		} else {
			if (number < arr[mid] && number >= arr[start]) {
				return searchNumberInRotatedArray(arr, start, mid - 1, number);
			} else {
				return searchNumberInRotatedArray(arr, mid + 1, end, number);
			}
		}
	}
}