import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Doc file va dem so lan xuat hien cua moi ki tu.
 */
public class CountCharacter {
	/*
	 * Phuong thuc static dem so lan xuat hien cua moi ki tu trong file
	 * 
	 */
	public static void countCharacter(String file) {
		char[] array;

		//doc file va luu doan van thanh 1 mang char
		FileInputStream f = null;
		try {
			f = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner sc = new Scanner(f);
		array = sc.nextLine().toCharArray();
		sc.close();
		
		//dem so lan xuat hien cua ki tu
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<Character> character = new ArrayList<Character>();
		int i;
		int j;
		for (i = 0; i < array.length; i++) {
			if (character.contains(array[i])) {
				//neu ki tu da co trong mang character, tang bien dem len 1.
				int a = character.indexOf(array[i]);
				count.set(a, count.get(a) + 1);
			}
			else {
				//neu ki tu chua co trong mang character, them vao mang, them bien dem 1.
				character.add(array[i]);
				count.add(1);
			}
		}
		//in ra ket qua
		for (i = 0; i < character.size(); i++) {
			System.out.println(character.get(i) + " : " + count.get(i));
		}
		
	}
	public static void main(String []args) {
		countCharacter("CountCharacter.txt");
	}
}
