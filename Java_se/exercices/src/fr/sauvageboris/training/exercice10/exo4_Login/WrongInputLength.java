package fr.sauvageboris.training.exercice10.exo4_Login;

public class WrongInputLength extends Exception {

    public WrongInputLength() {
        super("Login or password must contain no more than 10 characters");
    }
}
