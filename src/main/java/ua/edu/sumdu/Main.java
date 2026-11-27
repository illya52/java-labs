package ua.edu.sumdu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Phone> phoneList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Додати звичайний Phone");
            System.out.println("2. Додати SmartPhone");
            System.out.println("3. Додати KeypadPhone");
            System.out.println("4. Показати всі телефони (поліморфізм)");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            String choiceStr = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Будь ласка, введіть число!");
                continue;
            }

            switch (choice) {
                case 1:
                    addPhone();
                    break;
                case 2:
                    addSmartPhone();
                    break;
                case 3:
                    addKeypadPhone();
                    break;
                case 4:
                    showAllPhones();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }

        System.out.println("Програма завершена.");
    }

    private static void addPhone() {
        try {
            System.out.print("Бренд: ");
            String brand = scanner.nextLine();
            System.out.print("Модель: ");
            String model = scanner.nextLine();
            System.out.print("Ціна: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Рік випуску: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Пам'ять (ГБ): ");
            int storage = Integer.parseInt(scanner.nextLine());

            phoneList.add(new Phone(brand, model, price, year, storage));
            System.out.println("Phone успішно додано!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static void addSmartPhone() {
        try {
            System.out.print("Бренд: ");
            String brand = scanner.nextLine();
            System.out.print("Модель: ");
            String model = scanner.nextLine();
            System.out.print("Ціна: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Рік випуску: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Пам'ять (ГБ): ");
            int storage = Integer.parseInt(scanner.nextLine());

            System.out.print("Операційна система: ");
            String os = scanner.nextLine();
            System.out.print("Діагональ екрану (дюйми): ");
            double screenSize = Double.parseDouble(scanner.nextLine());

            phoneList.add(new SmartPhone(brand, model, price, year, storage, os, screenSize));
            System.out.println("SmartPhone успішно додано!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static void addKeypadPhone() {
        try {
            System.out.print("Бренд: ");
            String brand = scanner.nextLine();
            System.out.print("Модель: ");
            String model = scanner.nextLine();
            System.out.print("Ціна: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Рік випуску: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Пам'ять (ГБ): ");
            int storage = Integer.parseInt(scanner.nextLine());

            System.out.print("Є фізичні кнопки? (true/false): ");
            boolean hasButtons = Boolean.parseBoolean(scanner.nextLine());
            System.out.print("Тип екрану: ");
            String screenType = scanner.nextLine();

            phoneList.add(new KeypadPhone(brand, model, price, year, storage, hasButtons, screenType));
            System.out.println("KeypadPhone успішно додано!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static void showAllPhones() {
        if (phoneList.isEmpty()) {
            System.out.println("Список порожній.");
            return;
        }

        System.out.println("\n=== СПИСОК УСІХ ТЕЛЕФОНІВ ===");
        for (Phone p : phoneList) {
            System.out.println(p.toString());
        }
    }
}