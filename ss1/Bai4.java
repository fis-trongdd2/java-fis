import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai4 {
	/*
	 * Phương thức static trả về chuỗi đảo ngược của 1 chuỗi.
	 */
	public static String reverseArray(String str) {
		if(str == null || str.length() == 0) {
			return null; 
		}

		String result = "";
		int i;
		int n = str.length();
		char c[] = new char[n];
		
		for (i = 0; i < n; i++){
			c[i] = str.charAt(i);
		}
		
		for (i = 0; i <= (n / 2); i++) {
			char temp = c[i];
			c[i] = c[n - i - 1];
			c[n - i - 1] = temp;
		}
		
		for (i = 0; i < n; i++){
			result += c[i];
		}
		
		return result;
		}
	/*
	 * Phương thức tính số lần xuất hiện của word 
	 * trong mảng 2 chiều array, theo chiều dọc, từ trên xuống
	 * 
	 */
	public static int countD(char array[][], int m, int n, String word) {
		int count = 0;
		int i;
		int j;
		
		for (i = 0; i < n; i++){
			for (j = 0; j < m; j++){
				if ( (array[i][j] == word.charAt(0)) && (i <= n - word.length())) {
					boolean flag = true;
					for (int k = 1; k < word.length(); k++) {
						if (array[i + k][j] != word.charAt(k)) {
							i += k;
							flag = false;
							break;
						}
					}
					if (flag == true) {
						count++;
					}
				}
			}
		}
		
		return count; 
	}
	/*
	 * Phương thức tĩnh tính số lần xuất hiện của word 
	 * trong mảng 2 chiều array, theo chiều ngang, trái sang phải
	 * 
	 */
	public static int countN(char array[][], int m, int n, String word) {
		int count = 0;
		int i;
		int j;
		for (i = 0; i < n; i++){
			for (j = 0; j < m; j++){
				if ((array[i][j] == word.charAt(0)) && (j <= m - word.length())) {
					boolean flag = true;
					for (int k = 1; k < word.length(); k++) {
						if (array[i][j + k] != word.charAt(k)) {
							flag = false;
							j += k;
							break;
						}
					}
					if (flag == true) {
						count++;
					}
				}
			}
		}
		return count; 

	}
	/*
	 * Phương thức tĩnh tính số lần xuất hiện của word 
	 * trong mảng 2 chiều array, theo đường chéo,
	 * trái sang phải, từ trên xuống và từ dưới lên
	 * 
	 */
	public static int countC(char array[][], int m, int n,String word) {
		int count = 0;
		int i;
		int j;
		for (i = 0; i < n; i++){
			for (j = 0; j < m; j++){
				if ((array[i][j] == word.charAt(0)) 
						&& (i <= n - word.length()) 
						&& (j <= m - word.length())) {
					boolean flag = true;
					for (int k = 1; k < word.length(); k++) {
						if (array[i + k][j + k] != word.charAt(k)) {
							flag = false;
							j += k;
							i += k;
							break;
						}
					}
					if (flag == true) {
						count++;
					}
							
				}
			}
		}
		for (i = n - 1; i >= 0; i--){
			for (j = 0; j < m; j++){
				if ((array[i][j] == word.charAt(0)) 
						&& (i >= word.length() - 1) 
						&& (j <= m - word.length())) {
					boolean flag = true;
					for (int k = 1; k < word.length(); k++) {
						if (array[i - k][j + k] != word.charAt(k)) {
							flag = false;
							j += k;
							i -= k;
							break;
						}
					}
					if (flag == true) {
						count++;
					}
							
				}
			}
		}
		return count;
	}
	
	public static void main(String []args) throws FileNotFoundException{
		File file = new File("Bai4.txt");
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char array[][] = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				array[i][j] = sc.next().charAt(0);
			}
		}
		sc.nextLine();
		String word = sc.nextLine();
		sc.close();

		System.out.println(countD(array, m, n, word) + countD(array, m, n, reverseArray(word)));
		System.out.println(countN(array, m, n, word) + countN(array, m, n, reverseArray(word)));
		System.out.println(countC(array, m, n, word) + countC(array, m, n, reverseArray(word)));
	}
}
