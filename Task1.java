package lab4;

import java.util.Arrays;

public class Task1 {
//task 1.1
	// selectionSort
	// sort by descending order
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int index = i;
			// tim phan tu nho nhat
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[index]) {
					index = j;
				}
			}
			// swap
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}

//task 1.2
	// bubbleSort
	// sort by descending order
	public static void bubbleSort(int[] array) {
		boolean stop = true;
		for (int i = 0; i < array.length - 1; i++) {
			// tru i vi moi lan swap xong nhung so o sau da duoc kiem tra
			// thuat toan it phuc tap
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					// swap array[j+1] va array[j]
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					stop = false;
				}
				if (stop)
					break;
			}

		}
	}

//task 1.3	
	// insertionSort
	// sort by descending order
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i;
			// Di chuyển qua các phần tử bên trái
			// và đẩy các phần tử lớn hơn ra bên phải.
			while (j > 0 && array[j - 1] < temp) {
				// swap
				array[j] = array[j - 1];
				j--;
			}
			// Đặt giá trị hiện tại vào vị trí đúng của nó
			// trong mảng sắp xếp.

			array[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 7, 34, 0, -12 };
//		bubbleSort(arr);
//		System.out.println(Arrays.toString(arr));
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
