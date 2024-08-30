package fr.sauvageboris.training.exercice4;

import java.util.Scanner;


//Demander à l’utilisateur de saisir un mot ou une phrase
//Indiquez ensuite si la saisie est un Palindrome ou non

//  REMARQUE :
//  La classe Scanner et la méthode charAt() seront vos meilleurs alliés
public class Palindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez une phrase : ");
        String sentence = sc.nextLine();
        String sentenceReversed = "";

        for (int i = sentence.length() - 1; i >= 0; i--) {
            sentenceReversed += sentence.charAt(i);
        }

        if (sentence.equals(sentenceReversed)) {
            System.out.println("La phrase est un palindrome !");
        } else {
            System.out.println("La phrase n'est pas un palindrome.");
        }
    }

}