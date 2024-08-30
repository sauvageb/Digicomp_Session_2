package fr.sauvageboris.training.exercice10.exo4_Login;

public class WrongLoginException extends Exception {

    public WrongLoginException() {
        super("Wrong login");
    }
}
