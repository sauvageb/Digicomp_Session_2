package fr.sauvageboris.training.exercice6;

import java.util.Scanner;

//Reprendre l’algorithme précédent Exercice5.
//        Écrire un algorithme qui vous demande de saisir une note et un prénom pour chacun de vos élèves. La saisie s’arrête dès que l’utilisateur saisit -1. Veuillez ensuite afficher la note de chaque élèves
//        Déclarer une classe Student
//        contenant un prénom, un nom, une note, un age
//        Revisitez votre exercice avec la programmation orientée objet
public class Main {

    public static void main(String[] args) {
        final int MAX_STUDENTS = 100;
        int nbStudents = 0;
        Student[] students = new Student[MAX_STUDENTS];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saississez le prénom et la note de chaque élèves :");

        do {
            System.out.println("Prénom :");
            String firstName = scanner.next();
            if (firstName.equals("-1")) {
                break;
            }
            System.out.println("Note :");
            double mark = scanner.nextDouble();
            if (mark == -1) {
                break;
            }
            students[nbStudents] = new Student(firstName, mark);

            nbStudents++;
        } while (nbStudents < MAX_STUDENTS);

        scanner.close();

       display(students);
    }

    static void display(Student[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                break;
            }
            System.out.println(array[i].firstName+":"+array[i].mark);
        }
    }
}