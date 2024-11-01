package exercices.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class Exo3Test {

    @Test
    public void test_getTrainingStartDate() {
        LocalDate result = Exo3.getTrainingStartDate();
        Assertions.assertNotNull(result);
    }
}
