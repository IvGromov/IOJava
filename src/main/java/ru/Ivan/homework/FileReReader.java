package ru.Ivan.homework;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileReReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Список доступных текстовых файлов в текущем каталоге:");
        String currentDirectory = System.getProperty("user.dir");
        Path FolderPath = Paths.get(currentDirectory, "src", "main", "java", "ru", "Ivan", "homework");
        try {
            Files.list(FolderPath)
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".txt"))
                    .forEach(path -> System.out.println(path.getFileName()));
        } catch (IOException e) {
            System.out.println("Ошибка при чтении каталога: " + e.getMessage());
            return;
        }
        System.out.println("Введите имя файла: ");
        String filePath = FolderPath + "\\" + scanner.nextLine();
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Файл не найден");
            return;
        }

        System.out.println("Содержимое файла:");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        System.out.print("\nВведите строку для записи в файл: ");
        String input = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(input);
            writer.newLine(); // Добавить перевод строки
            System.out.println("Строка успешно записана в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        scanner.close();
    }
}
