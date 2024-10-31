package exercices.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class Exo7Test {

    @Test
    void rocketStartup() {
        // given
        // when
        var result = Exo7.rocketStartup();
        assertNotNull(result);
        assertTrue(result instanceof LocalDateTime);

        LocalDateTime date = (LocalDateTime) result;

        // then
        LocalDateTime expected = LocalDateTime.now().plusDays(3).plusHours(5);
        Assertions.assertEquals(expected.getDayOfWeek(), date.getDayOfWeek());
        Assertions.assertEquals(expected.getHour(), date.getHour());
    }
}