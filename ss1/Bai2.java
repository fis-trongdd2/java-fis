import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bai2 {
	/*
	 * Hàm tạo mảng a[n] với các a[i] có giá trị 0 hoặc 1 
	 * biễu diễn các tập con của tập arr[n]
	 */
	public static void nextSet(int a[]) {
		int j;
		for (j = a.length - 1 ; j >= 0; j--) {
			if (a[j] == 1)
				a[j] = 0;
			else {
				a[j] = 1;
				break;
			}
		}
	}
	/*
	 * Hàm tính số cách để dùng phép tính cal 
	 * với các số trong ArrayList arr sinh ra được số m.
	 * Trong hàm này, cal là phép cộng (+) hoặc (*)
	 * 
	 */
	public static int countAdd(ArrayList<Integer> arr, int m, char cal) {
		int i,j;
		int count = 0;
		int t;
		int n = arr.size();
		int a[] = new int[n];
		int max = (int) Math.pow(2, n);
		for (i = 0; i < n; i++) {
			a[i] = 0;
		}
		if (cal == '+') {
			t = 0;
		}
		else {
			t = 1;
		}
		for (i = 0; i < max; i++) {
			nextSet(a);
			for (j = 0; j < n; j++) {
				if (a[j] == 1) {
					if (cal == '+')
						t += arr.get(j);
					if (cal == '*')
						t *= arr.get(j);
				}
			}
			if (t == m) {
				count++;
			}
			if (cal == '+') {
				t = 0;
			}
			if (cal == '*') {
				t = 1;
			}
		}
		return count;
	}
	/*
	 * Hàm tính số cách để dùng phép tính cal 
	 * với các số trong ArrayList arr sinh ra được số m.
	 * Trong hàm này, cal là phép cộng (-) hoặc (/)
	 * 
	 */
	public static int countSub(ArrayList<Integer> arr, int m, char cal) {
		int count = 0;
		int i;
		ArrayList<Integer> temp = new ArrayList<Integer>() ;
		for (i = 0; i < arr.size(); i++){
			for (Integer in : arr){
				temp.add(in);
			} 
			temp.remove(i);
			if (cal == '-') {
				count += countAdd(temp, arr.get(i) - m, '+');
			}
			else {
				count += countAdd(temp, arr.get(i) / m, '*');
			}
			temp.clear();
		}
		return count;
	}	

	public static void main(String []args) throws FileNotFoundException {
		File file = new File("Bai2.txt");
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		sc.close();

		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (Integer i : a){
			arr.add(i);
		}
		System.out.println(countAdd(arr, m, '+'));
		System.out.println(countSub(arr, m, '-'));
		System.out.println(countAdd(arr, m, '*'));
		System.out.println(countSub(arr, m, '/'));
	}
}
