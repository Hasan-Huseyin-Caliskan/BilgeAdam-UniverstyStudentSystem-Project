package universtySystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class IOSystem {
	Scanner sc = new Scanner(System.in);
	HashMap<Integer, String> student=new HashMap<Integer, String>();
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	FileInputStream fis = null;
	ObjectInputStream ois = null;

	// Dosyaya yazma işlemleri
	public void writeFile() {
		System.out.println("Eklenecek öğrenci sayısını giriniz");
		int quantity = sc.nextInt();
		sc.nextLine();
		int counter = 1;
		while (quantity-- > 0) {
			System.out.println(counter + ". eklenecek öğrencinin;\nOkul Numarası");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.println("Adı ve Soyadı");
			String name = sc.nextLine();
			counter++;
			student.put(num, name);
		}
		try {
			fos=new FileOutputStream("StudentList.txt",true);
			oos=new ObjectOutputStream(fos);
			System.out.println("Yazma işlemine başlandı.");
			oos.writeObject(student);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Dosya bulunamadı!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Yazma ile ilgili bir sorun oluştu.");
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Ekleme işlemi tamamlandı!");
	}

	// Dosyayı okuma işlemleri
	public void readFile() {
		try {
			fis = new FileInputStream("StudentList.txt");
			ois = new ObjectInputStream(fis);
			student = (HashMap<Integer, String>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("Okunacak dosya bulunamadı.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Liste boş");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class bulunamadı.");
		}finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		Set set = student.entrySet();
		Iterator iterator;
		iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mEntry = (Map.Entry) iterator.next();
			System.out.print("\nOkul Numarası: " + mEntry.getKey() + " Öğrenci Adı: " + mEntry.getValue());
		}

	}

	// Öğrenci silme işlemleri
	public void deleteStudent() {
		try {
			fis = new FileInputStream("StudentList.txt");
			ois = new ObjectInputStream(fis);
			student = (HashMap) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("Okunacak dosya bulunamadı.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Liste boş");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class bulunamadı.");
		}finally {
			System.out.println("Silinecek öğrencinin numarası:");
			int dVal=sc.nextInt();
			student.remove(dVal);
			try {
				fos=new FileOutputStream("StudentList.txt");
				oos=new ObjectOutputStream(fos);
				oos.writeObject(student);
				fos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		Set set = student.entrySet();
		Iterator iterator;
		iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mEntry = (Map.Entry) iterator.next();
			System.out.print("\nOkul Numarası: " + mEntry.getKey() + " Öğrenci Adı: " + mEntry.getValue());
		}
	}
}
