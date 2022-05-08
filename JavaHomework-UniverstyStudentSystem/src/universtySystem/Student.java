package universtySystem;

import java.util.HashMap;
import java.util.Scanner;

public class Student {
	HashMap<Integer, String> student=null;
	Scanner sc = new Scanner(System.in);
	private String sName;

	public void addStudent() {
		System.out.println("Eklenecek Öğrenci Miktarı");
		int quantity = sc.nextInt();
		sc.nextLine();
		int counter = 1;
		while (quantity-- > 0) {
			System.out.println(counter + ". eklenecek öğrencinin;");
			System.out.println("Okul numarası");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.println("Öğrencinin isim ve soyisim");
			String name = sc.nextLine();
			counter++;
			student.put(number, name);
		}
	}

	public void deleteStudent() {
		System.out.println("Silinecek öğrencinin numarasını giriniz");
		String get=student.get(sc.nextInt());
		System.out.println(get);
		
	}

}
