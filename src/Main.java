import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static final String TEXT_TO_SAVE = "Hello world!";
    public static final String SUCCESS = "poprawny";
    public static final String FAILURE = "niepoprawny";

    public static void main(String[] args) {
        String fileName;
        String successString;
        String failureString;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku:");
        fileName = scanner.nextLine();
        System.out.println("Podaj poprawny:");
        successString = scanner.nextLine();
        System.out.println("Podaj niepoprawny:");
        failureString = scanner.nextLine();

        saveToFile(fileName, successString, failureString, (result) -> {

            if (result.wasSavedCorrectly(fileName, successString, failureString)) {
                System.out.println("Zapisano plik");
            }
            System.out.println("Czy chcesz storzyć nową sciezke (T/N)?");
            if (userAgree(scanner.nextLine())) {
                System.out.print("Podaj nowa sciezke:");
                return Optional.of(scanner.nextLine());
            }
            return Optional.empty();
        });

    }

    private static boolean userAgree(String string) {
        return string.equalsIgnoreCase("T");
    }

    private static void saveToFile(String fileName, String successString, String failureString, Callback callback) {
        boolean success = false;
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            printWriter.write(TEXT_TO_SAVE);
            System.out.println(SUCCESS);
            success = true;
        } catch (IOException exception) {
            System.out.println(FAILURE);
        }
        boolean finalSuccess = success;
        callback.getResult((fName, successResult, failureResult) -> finalSuccess)
                .ifPresent(newPath -> saveToFile(newPath, successString, failureString, callback));
    }

}

