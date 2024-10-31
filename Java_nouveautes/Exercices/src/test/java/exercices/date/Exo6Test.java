package exercices.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exo6Test {

    @Test
    void getTime() {
        var result = Exo6.getTime();
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result instanceof String);
        String regex = "^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$";
        assertTrue(result.matches(regex), "The date string format is incorrect.");
    }
}