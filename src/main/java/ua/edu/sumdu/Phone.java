package ua.edu.sumdu;

import java.util.Objects;

public class Phone {
    private static int instanceCount = 0;

    private String brand;
    private String model;
    private double price;
    private int year;
    private int storage;
    private PhoneOS os;
    private Processor processor;

    public Phone(String brand, String model, double price, int year, int storage, PhoneOS os, Processor processor) {
        setBrand(brand);
        setModel(model);
        setPrice(price);
        setYear(year);
        setStorage(storage);
        setOs(os);
        setProcessor(processor);
        instanceCount++;
    }

    public Phone(Phone other) {
        this(other.brand, other.model, other.price, other.year, other.storage, other.os,
                new Processor(other.processor.getModel(), other.processor.getCores()));
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) throw new IllegalArgumentException("Бренд не може бути порожнім.");
        this.brand = brand;
    }

    public String getModel() { return model; }
    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) throw new IllegalArgumentException("Модель не може бути порожньою.");
        this.model = model;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Ціна повинна бути більшою за нуль.");
        this.price = price;
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        if (year < 1990 || year > 2026) throw new IllegalArgumentException("Некоректний рік (1990-2026).");
        this.year = year;
    }

    public int getStorage() { return storage; }
    public void setStorage(int storage) {
        if (storage <= 0) throw new IllegalArgumentException("Об'єм пам'яті повинен бути > 0.");
        this.storage = storage;
    }

    public PhoneOS getOs() { return os; }
    public void setOs(PhoneOS os) {
        if (os == null) throw new IllegalArgumentException("ОС не може бути null.");
        this.os = os;
    }

    public Processor getProcessor() { return processor; }
    public void setProcessor(Processor processor) {
        if (processor == null) throw new IllegalArgumentException("Процесор не може бути null.");
        this.processor = processor;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", storage=" + storage + "GB" +
                ", os=" + os +
                ", processor=" + processor +
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
                Objects.equals(model, phone.model) &&
                os == phone.os &&
                Objects.equals(processor, phone.processor);
    }
}