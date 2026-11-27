package ua.edu.sumdu;

public class KeypadPhone extends Phone {
    private boolean hasPhysicalButtons;
    private String screenType;

    public KeypadPhone(String brand, String model, double price, int year, int storage, boolean hasPhysicalButtons, String screenType) {
        super(brand, model, price, year, storage);
        this.hasPhysicalButtons = hasPhysicalButtons;
        this.screenType = screenType;
    }

    public boolean isHasPhysicalButtons() { return hasPhysicalButtons; }
    public void setHasPhysicalButtons(boolean hasPhysicalButtons) { this.hasPhysicalButtons = hasPhysicalButtons; }

    public String getScreenType() { return screenType; }
    public void setScreenType(String screenType) { this.screenType = screenType; }

    @Override
    public String toString() {
        return "KeypadPhone [" + super.toString() +
                ", HasButtons=" + hasPhysicalButtons +
                ", ScreenType='" + screenType + '\'' + "]";
    }
}