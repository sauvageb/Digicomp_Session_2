package exercices.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class Exo2Test {

    @Test
    public void test_get_today() {
       var result = Exo2.getToday();
       assertNotNull(result);
       assertTrue(result instanceof LocalDate, "return type must be LocalDate");

        LocalDate date = (LocalDate) result;
        assertEquals(LocalDate.now().getYear(),date.getYear());
        assertEquals(LocalDate.now().getMonth(),date.getMonth());
        assertEquals(LocalDate.now().getDayOfMonth(),date.getDayOfMonth());
    }
}
