package ua.edu.sumdu;


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

    public Phone(Phone other) {
        this(other.brand, other.model, other.price, other.year, other.storage);
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
        if (price < 0) throw new IllegalArgumentException("Ціна не може бути від'ємною.");
        this.price = price;
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        if (year < 1900) throw new IllegalArgumentException("Невірний рік випуску.");
        this.year = year;
    }

    public int getStorage() { return storage; }
    public void setStorage(int storage) {
        if (storage < 0) throw new IllegalArgumentException("Пам'ять не може бути від'ємною.");
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", storage=" + storage +
                '}';
    }

}