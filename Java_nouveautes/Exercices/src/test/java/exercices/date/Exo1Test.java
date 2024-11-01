package exercices.date;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Exo1Test {

        @Test
        public void testGetToday() {
            String today = Exo1.getToday();
            String regex = "^[A-Za-z]{3} [A-Za-z]{3} \\d{2} \\d{2}:\\d{2}:\\d{2} [A-Z]{1,} \\d{4}$";

            assertTrue(today.matches(regex), "The date string format is incorrect.");
        }

        @Test
        public void testGetTodayWithJava8() {
            var today = Exo1.getTodayWithJava8();
            assertNotNull(today);
            String regex = "^[A-Za-z]{3} [A-Za-z]{3} \\d{2} \\d{2}:\\d{2}:\\d{2} [A-Z]{1,} \\d{4}$";

            assertTrue(today.matches(regex), "The date string format is incorrect.");
        }

}
