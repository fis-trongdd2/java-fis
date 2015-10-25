import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lop tu dien, voi cac chuc nang them tu, tim kiem, chinh sua tu.
 */
public class Dictionary {
	ArrayList<Word> dictionary = new ArrayList<Word>();
	/*
	 * Contructor : doc file luu cac tu co san
	 * File .txt luu keyword(tu) va value(nghia cua tu) tren cac dong rieng biet. 
	 */
	public Dictionary(String file) {
		FileInputStream f = null;
		String keyword;
		String value;
		ArrayList<String> arr = new ArrayList<String>();
		try {
			f = new FileInputStream(file);
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				keyword = sc.nextLine();
				value = sc.nextLine();
				dictionary.add(new Word(value,keyword));
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	/*
	 * them tu vao tu dien
	 */
	public void addWord(Word word) {
		int i;
		boolean check = false;
		for(i = 0; i < dictionary.size(); i++) {
			if (dictionary.get(i).equals(word)) {
				check = true;
				break;
			}
		}
		if (check) {
			System.out.println("Word existing!");
		}
		else {
			dictionary.add(word);
		}
		saveWord("dictionary.txt", word);
	}
	/*
	 * tim tu trong tu dien
	 */
	public void findWord(String key) {
		int i;
		int index;
		boolean check = false;
		for (i = 0; i < dictionary.size(); i++) {
			if (dictionary.get(i).getKeyword().equals(key)) {
				check = true;
				index = i;
				break;
			}
		}
		if (check) {
			System.out.println("Value : " + dictionary.get(i).getValue());
		}
		else {
			System.out.println("Not found !");
		}
	}
	/*
	 * chinh sua tu trong tu dien
	 */

	public void updateWord(Word word) {
		int i;
		boolean check = false;
		int index = 0;
		for(i = 0; i < dictionary.size(); i++) {
			if (dictionary.get(i).getKeyword().equals(word.getKeyword())) {
				check = true;
				index = i;
				break;
			}
		}
		if (check) {
			dictionary.set(index, word);
			PrintWriter writer = null;
			try {
				writer = new PrintWriter("dictionary.txt");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			writer.print("");
			writer.close();	
			for (int j = 0; j < dictionary.size(); j++) {
				saveWord("dictionary.txt", dictionary.get(j));
			}
		}
		else {
			System.out.println("Not found !");
		}
	}
	/*
	 * luu tu them hoac sua vao file
	 */

	public void saveWord(String file, Word word) {
		File f = new File(file);
		FileWriter fw = null;
		try {
			fw = new FileWriter(f.getName(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write(word.getKeyword() + "\n");
			bw.write(word.getValue() + "\n");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * doc keyword va value tu ban phim
	 */
	public Word readWord() {
		System.out.println("Key word : ");
		Scanner k = new Scanner(System.in);
		String keyword = k.nextLine();
		System.out.println("Value : ");
		Scanner v = new Scanner(System.in);
		String value = v.nextLine();
		return new Word(value, keyword);
	}
	public static void main(String []args) {
		Dictionary d = new Dictionary("dictionary.txt");
		Word word = new Word();
		while (true) {
			System.out.println("1. Add word");
			System.out.println("2. Find word");
			System.out.println("3. Update word");
			System.out.println("4. Exit");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1: 
				System.out.println("Add word : ");
				word = d.readWord();
				d.addWord(word);
				break;
			case 2:
				System.out.println("Find word : ");
				System.out.println("Key word : ");	
				Scanner k = new Scanner(System.in);
				String key = k.nextLine();
				d.findWord(key);
				break;
			case 3: 
				System.out.println("Update word : ");
				word = d.readWord();
				d.updateWord(word);
				break;
			case 4:
				System.exit(1);
				break;
			}
		}
	}
}
/**
 * Lop Word la kieu tu trong tu dien voi thuoc tinh keyword va value.
 */
class Word {
	String keyword;
	String value;
	public Word() {
		
	}
	public Word(String nValue, String nKeyword) {
		this.value = nValue;
		this.keyword = nKeyword;
	}
	public String getValue() {
		return value;
	}
	public String getKeyword() {
		return keyword;
	}
}

 