package exercices.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class Exo2Test {

    private final Exo2 exo2 = new Exo2();

    // Exercices
    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFound_NameFound() {
        String phoneNumber = exo2.findPhoneNumberByNameAndPunishIfNothingFound("Jos de Vos");
        assertThat(phoneNumber).isEqualTo("016/161616");
    }

    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFound_NameNotFound() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> exo2.findPhoneNumberByNameAndPunishIfNothingFound("Boris Sauvage"))
                .withMessage("No phone number found");
    }

    // Optional version to really check
    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFoundWithOptional_NameNotFound() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> exo2.findPhoneNumberByNameAndPunishIfNothingFoundWithOptional("Boris Sauvage")
                        .orElseThrow(() -> new IllegalArgumentException("No phone number found")))
                .withMessage("No phone number found");
    }

    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFoundWithOptional_NameFound() {
        Optional<String> phoneNumber = exo2.findPhoneNumberByNameAndPunishIfNothingFoundWithOptional("Jos de Vos");
        assertThat(phoneNumber).isPresent();
        assertThat(phoneNumber.get()).isEqualTo("016/161616");
    }

}