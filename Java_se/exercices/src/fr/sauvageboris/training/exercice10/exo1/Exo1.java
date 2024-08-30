package fr.sauvageboris.training.exercice10.exo1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exo1 {

    // Enoncé
    public static void main(String[] args) {
        enonce();
        //solution();
    }

    public static void enonce() {
        int a, b, res;
        Scanner clavier = new Scanner(System.in);
        a = clavier.nextInt();
        b = clavier.nextInt();
        res = a / b;
        System.out.println("le résultat de " + a + " divisé par " + b + " est " + res);
        System.out.println("Fin du programme");

    }

    private static void solution() {
        int a, b, res;
        // Utilisation du Try-With-Ressources (Java 7)
        try (Scanner clavier = new Scanner(System.in)) {
            a = clavier.nextInt();
            b = clavier.nextInt();
            res = a / b;
            System.out.println("le résultat de " + a + " divisé par " + b + " est " + res);
        } catch (ArithmeticException e) {
            System.out.println("oop ! un problème dans la division ");
            System.out.println("le message officiel est " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("oop ! un problème dans l'entrée des données... Essayez des nombres non nuls !");
            System.out.println("le message officiel est " + e.getMessage());
        } finally {
            System.out.println("le bloc finally sera toujours exécuté");
            System.out.println("et c'est là que l'on fermera par exemple les fichiers");
        }
        System.out.println("Fin du programme");
    }


//    a) Le programme s'est-il exécuté correctement ?
//    Non : Exception in thread "main"
//
//    b) Le message "Fin du programme" est-il apparu ?
//    Non.
//
//    c) Quelle exception a été levée par la machine Java ?
//    Exception in thread "main" java.lang.ArithmeticException
//
//    d) Le programme a t-il affiché qu'il y avait un problème dans la division ?
//    Oui
//
//    e) Le message "Fin du programme" est-il apparu ?
//    Oui
//
//    f) Quel est le message d'erreur officiel correspondant à une telle exception ?
//            "/ by zero"
//
//    g) Le bloc finally a t-il été exécuté ?
//    Oui.
//
//    h) Le bloc finally a t-il été exécuté ?
//    Oui
//
//    i) L'exception a t-elle été traitée ?
//    Non.
//
//    "le bloc finally sera toujours exécuté
//    et c'est là que l'on fermera par exemple les fichiers
//    Exception in thread "main" java.lang.ArithmeticException: / by zero
//    at com.training.exception.EssaiException.main(EssaiException.java:36)"
//
//    j) Que se passe t-il ?
//    Ça plante
//
//    k) Quelle exception a été lancée ?
//    Exception in thread "main" java.util.InputMismatchException

}
