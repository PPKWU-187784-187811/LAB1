import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String firstString;
		String secondString;
		String thirdString;

		Scanner odczyt = new Scanner(System.in);

		System.out.println("Podaj nazwe pliku:");
		firstString = odczyt.nextLine();
		System.out.println("Podaj poprawny:");
		secondString = odczyt.nextLine();
		System.out.println("Podaj niepoprawny:");
		thirdString = odczyt.nextLine();
	}

	private void saveToFile(String fileName, String secondString, String thirdString,Callback callback) {

		FileOutputStream oFile = null;
		try {
			File file = new File(fileName);
			file.createNewFile();
			oFile = new FileOutputStream(file, false);
			oFile.write("Hello world!".getBytes());
			callback.getResult(secondString);
			System.out.println("poprawny");
		} catch (IOException e) {
			System.out.println("niepoprawny");
			callback.getResult(thirdString);
			e.printStackTrace();
		}

	}
}

