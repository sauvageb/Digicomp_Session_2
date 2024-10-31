package exercices.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class Exo4Test {

    @Test
    void test_identicalDates_return_false_when_date_are_null(){
        boolean result = Exo4.identicalDates(null, null);
        assertFalse(result);
    }

    @Test
    void test_identicalDates_return_true_when_date_are_same(){
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.now();
        boolean result = Exo4.identicalDates(date1, date2);
        assertTrue(result);
    }

}