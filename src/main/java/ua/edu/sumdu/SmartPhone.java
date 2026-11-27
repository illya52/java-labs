package ua.edu.sumdu;

public class SmartPhone extends Phone {
    private String os;
    private double screenSize;

    public SmartPhone(String brand, String model, double price, int year, int storage, String os, double screenSize) {
        super(brand, model, price, year, storage);
        this.os = os;
        this.screenSize = screenSize;
    }

    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }

    public double getScreenSize() { return screenSize; }
    public void setScreenSize(double screenSize) { this.screenSize = screenSize; }

    @Override
    public String toString() {
        return "SmartPhone [" + super.toString() +
                ", OS='" + os + '\'' +
                ", Screen=" + screenSize + " inches]";
    }
}