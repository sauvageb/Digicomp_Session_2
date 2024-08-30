package fr.sauvageboris.training.exercice10.exo2_Oubli_Stupide;

public class Exo2 {

    public static void main(String[] args) {
        int[] tab = null;
        try {
            System.out.println(tab[2]);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
