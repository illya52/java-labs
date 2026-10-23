package ua.edu.sumdu;

import java.util.Objects;

public class Phone {
    private String brand;
    private String model;
    private double price;
    private int year;
    private int storage;

    public Phone(String brand, String model, double price, int year, int storage) {
        setBrand(brand);
        setModel(model);
        setPrice(price);
        setYear(year);
        setStorage(storage);
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Бренд не може бути порожнім.");
        }
        this.brand = brand;
    }

    public String getModel() { return model; }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Модель не може бути порожньою.");
        }
        this.model = model;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Ціна повинна бути більшою за нуль.");
        }
        this.price = price;
    }

    public int getYear() { return year; }

    public void setYear(int year) {
        if (year < 1990 || year > 2026) {
            throw new IllegalArgumentException("Некоректний рік випуску (від 1990 до 2026).");
        }
        this.year = year;
    }

    public int getStorage() { return storage; }

    public void setStorage(int storage) {
        if (storage <= 0) {
            throw new IllegalArgumentException("Об'єм пам'яті повинен бути більшим за 0.");
        }
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", storage=" + storage + "GB" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Double.compare(phone.price, price) == 0 &&
                year == phone.year &&
                storage == phone.storage &&
                Objects.equals(brand, phone.brand) &&
                Objects.equals(model, phone.model);
    }
}