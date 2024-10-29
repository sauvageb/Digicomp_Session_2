package exercices.optional;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class Exo1Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Exo1 exo1 = new Exo1();

    @Test
    public void findPhoneNumberByName() {
        Optional<String> phoneNumber = exo1.findPhoneNumberByName("Jos de Vos");

        assertThat(phoneNumber.get()).isEqualTo("016/161616");
    }

    @Test
    public void findPhoneNumberByName_NotFound() {
        expectedException.expect(NoSuchElementException.class);

        Optional<String> phoneNumber = exo1.findPhoneNumberByName("Jos de Voss");

        phoneNumber.get();
    }

    @Test
    public void findNameByPhoneNumber() {
        Optional<String> name = exo1.findNameByPhoneNumber("016/161616");

        assertThat(name.get()).isEqualTo("Jos de Vos");
    }

    @Test
    public void findNameByPhoneNumber_NotFound() {
        expectedException.expect(NoSuchElementException.class);

        Optional<String> phoneNumber = exo1.findPhoneNumberByName("016/161619");
        phoneNumber.get();
    }
}
