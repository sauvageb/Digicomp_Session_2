package fr.sauvageboris.training.exercice10.exo3_Age_Capitaine;

public class AgeCapException extends Exception {

    public AgeCapException(int age) {
        super(age + " ans n'est pas un âge valide");
    }
}
