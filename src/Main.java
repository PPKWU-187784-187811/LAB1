import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
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

		saveToFile(firstString, secondString, thirdString, result -> {
			if (!secondString.equals(result)) {
				return questionAboutFile(odczyt);
			} else {
				return Optional.empty();
			}
		});
	}

	private static void saveToFile(String fileName, String secondString, String thirdString, Callback callback) {
		try {
			File file = new File(fileName);
			file.createNewFile();
			FileOutputStream oFile =  oFile = new FileOutputStream(file, false);
			oFile.write("Hello world!".getBytes());
			oFile.close();
			System.out.println("poprawny");
			callback.getResult(secondString);
		} catch (IOException e) {
			System.out.println("niepoprawny");
			callback.getResult(thirdString).ifPresent(newPath ->{
				try {
					File newFile = new File(newPath + '\\' + fileName);
					newFile.createNewFile();
					FileOutputStream newFileOutput = new FileOutputStream(newFile);
					newFileOutput.write("Hello world!".getBytes());
					newFileOutput.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			});
			e.printStackTrace();
		}
	}

	private static Optional<String> questionAboutFile(Scanner scanner) {
		System.out.println("Czy chcesz storzyć nową sciezke (T/N)?");
		if ("T".equals(scanner.nextLine())) {
			System.out.print("Podaj nowa sciezke:");
			return Optional.ofNullable(scanner.nextLine());
		}
		return Optional.empty();
	}
}

