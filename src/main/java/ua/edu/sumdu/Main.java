package ua.edu.sumdu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Phone> phones = new ArrayList<>();

        System.out.println("Введення даних для 5 телефонів:");

        for (int i = 0; i < 5; i++) {
            System.out.println("\nТелефон №" + (i + 1) + ":");

            System.out.print("Введіть бренд: ");
            String brand = scanner.next();
            scanner.nextLine();

            System.out.print("Введіть модель: ");
            String model = scanner.nextLine();

            System.out.print("Введіть ціну: ");
            double price = scanner.nextDouble();

            System.out.print("Введіть рік випуску: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            Phone phone = new Phone(brand, model, price, year);
            phones.add(phone);
        }

        System.out.println("\n--- Список усіх телефонів ---");
        for (Phone p : phones) {
            System.out.println(p.toString());
        }

        scanner.close();
    }
}