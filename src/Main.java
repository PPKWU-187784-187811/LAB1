import utils.Info;
import utils.callbacks.Callback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static final String TEXT_TO_SAVE = "Hello world!";
    public static final String SUCCESS = "success";
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

        saveToFile(fileName, successString, failureString, result -> {
            if (!isSuccess(successString, result)) {
                return questionAboutFile(scanner);
            }
            return Optional.empty();
        });
    }

    private static void saveToFile(String fileName, String successString, String failureString, Callback callback) {
        try {
            writeToFile(fileName);
            System.out.println(SUCCESS);
            callback.getResult(result -> {

            });
        } catch (IOException e) {
            System.out.println(FAILURE);
            callback.getResult(result -> {

            }).ifPresent(newPath -> {
                try {
                    writeToFile(newPath + File.separator + fileName);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            e.printStackTrace();
        }
    }

    private static void writeToFile(String fileName) throws IOException {
        FileOutputStream fileOutputStream = createFileToSave(fileName);
        fileOutputStream.write(TEXT_TO_SAVE.getBytes());
        fileOutputStream.close();
    }

    private static boolean isSuccess(String successString, String result) {
        return successString.equals(result);
    }

    private static FileOutputStream createFileToSave(String fileName) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
        return new FileOutputStream(file, false);
    }

    private static Optional<String> questionAboutFile(Scanner scanner) {
        System.out.println("Czy chcesz storzyć nową sciezke (T/N)?");
        if (isSuccess("T", scanner.nextLine())) {
            System.out.print("Podaj nowa sciezke:");
            return Optional.ofNullable(scanner.nextLine());
        }
        return Optional.empty();
    }
}

