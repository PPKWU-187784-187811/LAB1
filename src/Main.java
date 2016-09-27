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
}

