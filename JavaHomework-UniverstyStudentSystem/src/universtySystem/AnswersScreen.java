package universtySystem;

import java.util.Scanner;

public class AnswersScreen {
	Scanner sc = new Scanner(System.in);
	IOSystem io=new IOSystem();
	
	public void ansverScreen() {
		System.out.println("\t~~ÖĞRENCİ BİLGİ SİSTEMİ~~"
				+("\n\n\tLütfen yapmak istediğiniz işlemi karşılık gelen rakamla tuşlayınız")
				+("\n1-Öğrenci Listesi")
				+("\n2-Öğrenci Ekleme")
				+("\n3-Öğrenci Sil (Numaraya göre)")
				+("\n4-Öğrenci Düzenle (Numaraya göre)")
				+("\n5-Yapılan İşlemleri Kaydet")
				+("\n6-Çıkış"));
		int select = sc.nextInt();
		switch (select) {
		case 1:
			System.out.println("~ÖĞRENCİ LİSTESİ~");
			io.readFile();
			break;
		case 2:
			System.out.println("~ÖĞRENCİ EKLEME EKRANI~");
			io.writeFile();
			break;
		case 3:
			System.out.println("~ÖĞRENCİ SİLME EKRANI~");
			io.deleteStudent();
			break;
		case 4:
			System.out.println("Öğrenci Düzenle (Numaraya göre)");
			break;
		case 5:
			System.out.println("~Yapılan İşlemleri Kaydet~");
			break;
		case 6:
			System.out.println("~ÇIKIŞ MENÜSÜ~");
			break;
		default:
			System.out.println("Hatalı işlem");
			break;
		}
		
	}
}
