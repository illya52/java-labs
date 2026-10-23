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
            System.out.println("3. Завершити роботу");
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

                        Phone phone = new Phone(brand, model, price, year, storage);
                        phones.add(phone);
                        System.out.println("Телефон успішно додано!");

                    } catch (NumberFormatException e) {
                        System.out.println("Помилка: Введено не число!");
                    } catch (IllegalArgumentException e) {
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