package ua.edu.sumdu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Processor proc = new Processor("Snapdragon", 8);
        Phone phone = new Phone("Apple", "iPhone 15", 1000.0, 2023, 128, PhoneOS.IOS, proc);

        assertThrows(IllegalArgumentException.class, () -> phone.setPrice(-50.0));
        assertThrows(IllegalArgumentException.class, () -> phone.setModel("   "));
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        Processor proc = new Processor("Exynos", 8);

        assertThrows(IllegalArgumentException.class, () -> {
            new Phone("Samsung", "S24", 900.0, 2024, -64, PhoneOS.ANDROID, proc);
        });
    }

    @Test
    void shouldCopyObjectAndIncrementStaticCounter() {
        Processor proc = new Processor("A17", 6);
        Phone original = new Phone("Apple", "iPhone 15 Pro", 1200.0, 2023, 256, PhoneOS.IOS, proc);

        int countBefore = Phone.getInstanceCount();

        Phone copy = new Phone(original);

        assertEquals(original.getBrand(), copy.getBrand());
        assertEquals(original.getModel(), copy.getModel());
        assertEquals(countBefore + 1, Phone.getInstanceCount());
    }
}