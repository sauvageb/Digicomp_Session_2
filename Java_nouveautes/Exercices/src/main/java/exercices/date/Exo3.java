package exercices.date;

import java.time.LocalDate;

/*
 ** Consigne **
 *
 * Définir une date spécifique avec l'API Date Java 8 et l'afficher
 * Exemple : la date du premier jour de votre formation Java 8
 *
 *************
 *
 * Resultat attendu :
 */
class Exo3 {

    public static void main(String[] args) {
        LocalDate date = getTrainingStartDate();
        System.out.println("Date du premier jour de ma formation java 8" + date);
    }

    public static LocalDate getTrainingStartDate() {
        // TODO
        return LocalDate.now();
    }


}
