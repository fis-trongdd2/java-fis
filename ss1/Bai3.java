import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bai3 {
	public static void main(String []args) throws FileNotFoundException {
		File file = new File("Bai3.txt");
		Scanner sc = new Scanner(file);
		String input = sc.nextLine();
		sc.close();

		String a[] = input.split("[ .,]");
		ArrayList<String> arr = new ArrayList<String>();
		int i;
		int j;
		for (i = 0; i < a.length; i++) {
			if (a[i].equals("")) {
				continue;
			}
			else {
				arr.add(a[i].toLowerCase());
			}
		}
		int n = arr.size();
		int count[] = new int[n];
		for(i = 0; i < n; i++) {
			count[i] = 1;
		}
		for (i = 0; i < arr.size(); i++) {
			for (j = i+1; j < arr.size(); j++) {
				if (arr.get(i).equalsIgnoreCase(arr.get(j))) {
					count[i]++;
					arr.remove(j);
				}
			}
		}
		String temp;
		int t;
		for (i = 0; i < arr.size(); i++) {
			for (j = i+1; j < arr.size(); j++) {
				if (count[i] < count[j]) {
					temp = arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, temp);
					t = count[i];
					count[i] = count[j];
					count[j] = t;
				}
				if (count[i] == count[j]) {
					if (arr.get(i).compareTo(arr.get(j)) > 0 ) {
						temp = arr.get(i);
						arr.set(i, arr.get(j));
						arr.set(j, temp);
					}
				}
			}	
		}	
		for (i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i) + " " + count[i]);
		}
	}
}