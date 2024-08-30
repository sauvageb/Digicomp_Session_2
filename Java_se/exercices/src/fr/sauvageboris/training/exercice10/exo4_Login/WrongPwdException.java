package fr.sauvageboris.training.exercice10.exo4_Login;

public class WrongPwdException extends Exception {

    public WrongPwdException() {
        super("Wrong password");
    }
}
