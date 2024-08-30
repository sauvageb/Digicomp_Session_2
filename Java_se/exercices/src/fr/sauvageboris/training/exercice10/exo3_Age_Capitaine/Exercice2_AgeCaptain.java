package fr.sauvageboris.training.exercice10.exo3_Age_Capitaine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercice2_AgeCaptain {

    public static void main(String[] args) {
        Exercice2_AgeCaptain exo2 = new Exercice2_AgeCaptain();
        Scanner scanner = new Scanner(System.in);
        boolean isOk = false;
        int nbTentatives = 0;
        while (!isOk) {
            try {
                exo2.getAgeCap(scanner);
                isOk = true;
            } catch (Exception e) {
                nbTentatives++;
                System.err.println("Essai infructueux nº" + nbTentatives + " : " + e.getMessage());
            }
        }
        scanner.close();
    }

    public void getAgeCap(Scanner scanner) throws Exception {
        try {
            System.out.println("Saisir l'âge du capitaine :");
            int age = scanner.nextInt();
            if (age < 18 || age > 65) {
                throw new AgeCapException(age);
            } else {
                System.out.println("L'âge du capitaine est : " + age);
            }
        } catch (InputMismatchException e) {
            scanner.next();
            throw new Exception("L'âge du capitaine doit être un entier");
        }
    }

}
