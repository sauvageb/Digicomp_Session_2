package exercices.optional;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class Exo1Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final Exo1 exo1 = new Exo1();

    @Test
    public void find_PhoneNumber_ByName() {
        String phoneNumber = exo1.findPhoneNumberByName("Jos de Vos");
        assertThat(phoneNumber).isEqualTo("016/161616");
    }

    @Test
    public void find_PhoneNumber_ByName_Optional() {
        Optional<String> phoneNumber = exo1.findPhoneNumberByNameWithOptional("Jos de Vos");
        Assertions.assertTrue(phoneNumber.isPresent());
        assertThat(phoneNumber.get()).isEqualTo("016/161616");
    }


    @Test
    public void find_PhoneNumber_ByName_NotFound() {
        String phoneNumber = exo1.findPhoneNumberByName("Jos de Voss");
        Assertions.assertNull(phoneNumber);
    }

    @Test
    public void find_PhoneNumber_ByName_Optional_NotFound() {
        Optional<String> phoneNumber = exo1.findPhoneNumberByNameWithOptional("Jos de Voss");
        assertThat(phoneNumber).isEmpty();
    }

    @Test
    public void find_Name_ByPhoneNumber() {
        String name = exo1.findNameByPhoneNumber("016/161616");
        assertThat(name).isEqualTo("Jos de Vos");
    }

    @Test
    public void find_Name_ByPhoneNumber_Optional() {
        Optional<String> name = exo1.findNameByPhoneNumberWithOptional("016/161616");
        assertThat(name.isPresent()).isTrue();
        assertThat(name.get()).isEqualTo("Jos de Vos");
    }

    @Test
    public void find_Name_ByPhoneNumber_NotFound() {
       String phoneNumber = exo1.findPhoneNumberByName("016/161619");
        Assertions.assertNull(phoneNumber);
    }


    @Test
    public void find_Name_ByPhoneNumber_Optional_NotFound() {
        Optional<String> phoneNumber = exo1.findPhoneNumberByNameWithOptional("016/161619");
        assertThat(phoneNumber).isEmpty();
    }


}
