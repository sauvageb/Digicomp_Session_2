package fr.sauvageboris.training.exercice3;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PriceTTCWithScanner {

    // Ecrire un programme qui demande à l'utilisateur de saisir le prix HT
    // d'un objet et qui donne sa valeur TTC
    public static void main(String[] args) {
        InputStream source = System.in;
        Scanner myScanner = new Scanner(source);
        BigDecimal value = myScanner.nextBigDecimal();
        BigDecimal tva = new BigDecimal("1.2");
        BigDecimal result = value
                .multiply(tva)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.println(result);

        myScanner.close();
    }

}