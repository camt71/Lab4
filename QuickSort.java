package lab4;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	// sort by ascending order
	public static void quickSort(int[] array) {
		supportQuickSort(array, 0, array.length - 1);
	}

	private static void supportQuickSort(int[] array, int left, int right) {
		if (left < right) {
			int pivot = getPivot(array, left, right);
			int partitionIndex = partition(array, left, right, pivot);

			supportQuickSort(array, left, partitionIndex - 1);
			supportQuickSort(array, partitionIndex + 1, right);
		}
	}

	private static int partition(int[] array, int left, int right, int pivot) {
		int pivotValue = array[pivot];
		swap(array, pivot, right);
		for (int i = left; i < right; i++) {
			if (array[i] <= pivotValue) {
				swap(array, i, left);
				left++;
			}
		}
		swap(array, left, right);
		return left;
	}

	private static int getPivot(int[] array, int left, int right) {
		// Thực hiện lựa chọn các pivot khác nhau
		// Ví dụ: getPivot_First, getPivot_Last, getPivot_Random hoặc
		// getPivot_MedianOfThree
		// Có thể thay thế việc chọn các pivot
		return getPivot_Random(array, left, right);
	}

	// select pivot element based on the median of three strategy
	private static int getPivot_MedianOfThree(int[] array, int left, int right) {
		// Chọn điểm trung bình của phần tử đầu tiên, giữa và cuối cùng làm pivot
		int mid = (left + right) / 2;
		int l = array[left];
		int m = array[mid];
		int r = array[right];

		if (l > m) {
			if (m > r) {
				return mid;
			} else if (l > r) {
				return right;
			} else {
				return left;
			}
		} else {
			if (l > r) {
				return left;
			} else if (l > r) {
				return right;
			} else {
				return mid;
			}
		}
	}

	// select pivot element based on the first element in the array
	private static int getPivot_First(int[] array, int left, int right) {
		return left; // dùng element đầu tiên làm pivot
	}

	// select pivot element based on the last element in the array
	private static int getPivot_Last(int[] array, int left, int right) {
		return right; // dùng element cuối làm pivot
	}

	// select pivot element based on choosing a randomly element in the array
	private static int getPivot_Random(int[] array, int left, int right) {
		Random random = new Random();
		return random.nextInt(right - left + 1) + left; // random một pivot
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 8, 0, 6, -8, -34, 67, 45 };
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(getPivot_MedianOfThree(arr, 0, arr.length - 1));
		System.out.println(getPivot_First(arr, 0, arr.length - 1));
		System.out.println(getPivot_Last(arr, 0, arr.length - 1));
		System.out.println(getPivot_Random(arr, 0, arr.length - 1));
	}
}
