package fr.sauvageboris.training.exercice5;

import java.util.Scanner;

//un algorithme qui vous demande de saisir une note et un prénom pour chacun de vos élèves
//        La saisie s’arrête dès que l’utilisateur saisit -1
//        Veuillez ensuite afficher la note de chaque élèves
public class Exercice5 {

    public static void main(String[] args) {
        final int MAX_STUDENTS = 100;
        int nbStudents = 0;
        String[] firstNames = new String[MAX_STUDENTS];
        double[] marks = new double[MAX_STUDENTS];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saississez le prénom et la note de chaque élèves :");

        do {
            System.out.println("Prénom :");
            String firstName = scanner.next();
            if(firstName.equals("-1")) {
                break;
            }
            System.out.println("Note :");
            double mark = scanner.nextDouble();
            if(mark == -1) {
                break;
            }
            firstNames[nbStudents] = firstName;
            marks[nbStudents] = mark;
            nbStudents++;
        }while (nbStudents < MAX_STUDENTS);

        scanner.close();

        Exercice5.display(firstNames, marks);
    }

         static void display(String[] firstNames, double[] marks) {
        for (int i = 0; i < firstNames.length; i++) {
            if(firstNames[i] == null) {
                break;
            }
            System.out.println(firstNames[i] + ":" + marks[i]);
        }
    }
}