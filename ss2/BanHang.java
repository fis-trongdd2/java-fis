import java.util.Scanner;

public class BanHang {
	public static void main(String []args){
		BanHang a = new BanHang();
		a.Login();
	}
	public void Login() {
		int count = 0;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Ten tai khoan : ");
			String user = sc.nextLine();
			System.out.println("Mat khau : ");
			String password = sc.nextLine();
			if (user.equals("trongdinh") && password.equals("1234")) {
				count = 0;
				showMenu();
			}	 
			else {
				System.out.println("sai mat khau");
				count++;
				if (count < 3) {
					continue;
				}
				else {
					System.out.println("sai mat khau qua 3 lan. Dang nhap lai sau 1 phut");
					try {
						Thread.sleep(60000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count = 0;
					continue;
				}
			}
		
		}
	}
	public void showMenu() {
		System.out.println("1. Nhap kho");
		System.out.println("2. Xuat kho");
		System.out.println("3. Quan ly Gia");
		System.out.println("4. In hoa don");
		System.out.println("5. Thoat");
		System.out.println("----------------------------------");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			nhapKho();
			break;
		case 2:
			xuatKho();
			break;
		case 3:
			quanLiGia();            
			break;
		case 4:
			inHoaDon();
			break;
		case 5:
			Thoat();
			break;
		}
	}
	public void nhapKho() {
		System.out.println("1.Nhap so luong mot don vi");
		System.out.println("1. Nhap kho so luong 1 don vi.");        
		System.out.println("2. Nhap theo thung 20 don vi.");        
		System.out.println("3. Nhap thoe ta 10 don vi.");
		System.out.println("4. Chinh sua so luong.");
		System.out.println("5. Quay lai menu 1.");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 5:
			showMenu();
			break;
		}
	}
	public void xuatKho() {
		System.out.println("1. Xuat theo 1 don vi.");
		System.out.println("2. Xuat theo thung.");
		System.out.println("3. Xuat theo ta");
		System.out.println("4. Chinh sua so luong.");
		System.out.println("5. Kiem tra so luong");        
		System.out.println("6. Quay lai menu 1.");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 6:
			showMenu();
			break;
		}
	}
	public void quanLiGia() {
		System.out.println("1. Hien thi gia.");
		System.out.println("2. Sua gia");
		System.out.println("3. Tong tien hang");
		System.out.println("4. Quay lai menu 1.");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 4:
			showMenu();
			break;
		}
	}
	public void inHoaDon() {
		System.out.println("1. In theo luong hang.");
		System.out.println("2. In theo gia.");
		System.out.println("3. In theo ca hang va gia.");
		System.out.println("4. Quay lai menu 1.");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 4:
			showMenu();
			break;
		}
	}
	public void Thoat() {
		System.out.println("Thoat chuong trinh ??? (Y/N)");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (s.equals("y")) {
			System.exit(1);
		}
		else {
			if (s.equals("n")) {
				showMenu();
			}
		}
	}
}
