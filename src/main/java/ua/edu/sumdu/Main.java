package ua.edu.sumdu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Phone> phones = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Створити новий об'єкт Phone");
            System.out.println("2. Вивести інформацію про всі об'єкти");
            System.out.println("3. Скопіювати останній доданий телефон");
            System.out.println("4. Завершити роботу");
            System.out.print("Оберіть дію: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Введіть бренд: ");
                        String brand = scanner.nextLine();

                        System.out.print("Введіть модель: ");
                        String model = scanner.nextLine();

                        System.out.print("Введіть ціну: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        System.out.print("Введіть рік випуску: ");
                        int year = Integer.parseInt(scanner.nextLine());

                        System.out.print("Введіть об'єм пам'яті (ГБ): ");
                        int storage = Integer.parseInt(scanner.nextLine());

                        System.out.println("Оберіть ОС (1-ANDROID, 2-IOS, 3-HARMONYOS, 4-WINDOWS_PHONE, 5-OTHER): ");
                        int osChoice = Integer.parseInt(scanner.nextLine());
                        PhoneOS os = PhoneOS.values()[osChoice - 1];

                        System.out.print("Введіть модель процесора: ");
                        String procModel = scanner.nextLine();

                        System.out.print("Введіть кількість ядер процесора: ");
                        int procCores = Integer.parseInt(scanner.nextLine());

                        Processor processor = new Processor(procModel, procCores);
                        Phone phone = new Phone(brand, model, price, year, storage, os, processor);
                        phones.add(phone);

                        System.out.println("Додано! Всього створено об'єктів: " + Phone.getInstanceCount());
                    } catch (NumberFormatException e) {
                        System.out.println("Помилка: Введено не число!");
                    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Помилка валідації: " + e.getMessage());
                    }
                    break;

                case "2":
                    if (phones.isEmpty()) {
                        System.out.println("Список порожній.");
                    } else {
                        System.out.println("\n--- Список телефонів ---");
                        for (Phone p : phones) {
                            System.out.println(p.toString());
                        }
                    }
                    break;

                case "3":
                    if (phones.isEmpty()) {
                        System.out.println("Немає що копіювати. Спочатку створіть телефон.");
                    } else {
                        Phone lastPhone = phones.get(phones.size() - 1);
                        Phone copy = new Phone(lastPhone);
                        phones.add(copy);
                        System.out.println("Останній телефон успішно скопійовано!");
                        System.out.println("Всього створено об'єктів: " + Phone.getInstanceCount());
                    }
                    break;

                case "4":
                    running = false;
                    System.out.println("Програму завершено.");
                    break;

                default:
                    System.out.println("Некоректний пункт меню. Спробуйте ще раз.");
            }
        }
        scanner.close();
    }
}