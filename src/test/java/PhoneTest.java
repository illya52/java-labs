package ua.edu.sumdu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Phone phone = new Phone("Apple", "iPhone 15", 1000.0, 2023, 128);

        assertThrows(IllegalArgumentException.class, () -> {
            phone.setPrice(-50.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            phone.setModel("   ");
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Phone("Samsung", "S24", 900.0, 2024, -64);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Phone("Nokia", "3310", 50.0, 1900, 1);
        });
    }
}