package lab4;

import java.util.Arrays;

public class MergeSort {

	// sort by descending order
	public static void mergeSort(int[] array) {
		if (array.length > 1) {
			int middle = array.length / 2;// chia mang ra lam 2 phan
			int[] leftHalfArray = Arrays.copyOfRange(array, 0, middle);
			int[] rightHalfArray = Arrays.copyOfRange(array, middle, array.length);
			mergeSort(leftHalfArray);
			mergeSort(rightHalfArray);
			supportMergeSort(array, leftHalfArray, rightHalfArray);

		}
	}

	public static void supportMergeSort(int[] array, int[] left, int[] right) {
		int leftLength = left.length;
		int rightLength = right.length;
		int i = 0, j = 0, k = 0;
		while (i < leftLength && j < rightLength) {
			if (left[i] >= right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < leftLength) {
			array[k] = left[i];
			i++;
			k++;
		}
		while (j < rightLength) {
			array[k] = right[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 6, 0, 48, -23, 76 };
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
