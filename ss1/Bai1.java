import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Bài tập sắp xếp, tìm min, max của mảng nguyên
 */
public class Bai1 {
	private int array[];
	/*
	 *Hàm contructor 
	 */
	Bai1(int arr[]) {
		this.array = arr;
	}
	/*
	 * phương thức in mảng
	 */
	public void printArray() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] +" ");
		}
		System.out.println();
	}
	/*
	 * Sắp xếp tăng
	 */
	public void increaseSort() {
		int i = 0;
		int j;
		int temp;
		int n = array.length;
		for (i = 0; i < n; i++) {
			for (j = i + 1; j < n; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	/*
	 * Sắp xếp giảm
	 */
	public void decreaseSort() {
		int i = 0;
		int j;
		int temp;
		int n = array.length;
		for (i = 0; i < n; i++) {
			for (j = i + 1; j < n; j++) {
				if (array[i] < array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
	}
	/*
	 * Tìm  max
	 */
	public int findMax () {
		int max;
		max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
	/*
	 * tìm min
	 */
	public int findMin () {
		int min;
		min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;

	}
	
	public static void main(String[]args) {
		File file = null;
		try{
			file = new File("Bai1.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		Bai1 a = new Bai1(arr);
		a.increaseSort();
		a.printArray();
		a.decreaseSort();
		a.printArray();
		System.out.println(a.findMax());
		System.out.println(a.findMin());
	}
}
