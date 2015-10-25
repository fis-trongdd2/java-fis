import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bai tap: Mot so thao tac voi chuoi
 */
public class StringHandle {
	/*
	 * phuong thuc static dao nguoc chuoi
	 */
	public static String reverseString(String str) {
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
	 * phuong thuc static viet hoa chu dau chuoi
	 */
	public static String upperOneFirstLetter(String str) {
		return str.substring(0,1).toUpperCase() + str.substring(1, str.length());
	} 
	/*
	 * phuc thuc static viet hoa chu dau cac tu trong chuoi
	 */
	public static String upperAllFirstLetter(String str) {
		String []a = str.split(" ");
		String result = "";
		int i;
		result += upperOneFirstLetter(a[0]);
		for (i = 1; i < a.length; i++) {
			upperOneFirstLetter(a[i]);
			result += " " + upperOneFirstLetter(a[i]);
		}
		
		return result;
	}
	/*
	 * phuong thuc static in chuoi gom cac ki tu viet hoa
	 */
	public static String printUpperLetter(String str) {
		String result = "";
		int i;
		int n = str.length();
		char c[] = new char[n];	
		for (i = 0; i < n; i++){
			c[i] = str.charAt(i);
		}
		for (i = 0; i < n; i++){
			if ( c[i] >= 65 && c[i] <= 90){
				result += c[i];
			}
		}
		return result;
	}
	/*
	 * phuong thuc static tra ve chuoi ma hoa lech 1 ki tu
	 */
	public static String deviationString(String str) {
		String result = "";
		int i;
		int n = str.length();
		char c[] = new char[n];	
		for (i = 0; i < n; i++){
			c[i] = str.charAt(i);
		}
		for (i = 0; i < n; i++){
			c[i] = (char) (c[i] + 1);
			result += c[i];
		}
		return result;
	}
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		while (true){
			System.out.println("1. Nhap vao 1 chuoi in ra chuoi nghich dao");
			System.out.println("2. Nhap vao 1 chuoi in ra chuoi co chu dau thanh chu hoa");
			System.out.println("3. Nhap vao 1 chuoi in ra chuoi co chu dau tung tu la chu hoa");
			System.out.println("4. Nhap vao 1 chuoi in ra chuoi la chu hoa trong chuoi");
			System.out.println("5. Nhap vao 1 chuoi in ra chuoi ma hoa lech 1 ki tu");
			System.out.println("6. Thoat");
			choice = sc.nextInt();
			System.out.println(choice);
			
			if (choice == 6) {
				System.exit(1);
			}
			else{
				System.out.println("Nhap chuoi : ");
				Scanner input = new Scanner(System.in);
				String string = input.nextLine();
				switch (choice) {
 				case 1:
					System.out.println(reverseString(string));
					break;
 				
 				case 2:
					System.out.println(upperOneFirstLetter(string));
					break;
					
 				case 3:
					System.out.println(upperAllFirstLetter(string));
					break;
					
 				case 4:
					System.out.println(printUpperLetter(string));
					break;
					
 				case 5:
 					System.out.println(deviationString(string));		
 					break;
				}

			}
		}
	}
}
