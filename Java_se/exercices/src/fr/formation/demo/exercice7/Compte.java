package fr.sauvageboris.training.exercice7;

public class Compte {
    private static int sequenceCompte;
    private int numero;
    private float solde;

    public Compte(float solde) {
        this.numero = ++sequenceCompte;
        this.depot(solde);
    }

    public Compte() {
        this.numero = ++sequenceCompte;
        this.solde = 0;
    }

    public void depot(float valeur) {
        solde += valeur;
    }
    
    public void retrait(float valeur) {
        if (solde >= valeur) {
            solde -= valeur;
        } else {
            System.out.println("Solde insuffisant");
        }
    }

    public void virer(float valeur, Compte destinataire) {
        if (this.solde >= valeur) {
            this.retrait(valeur);
            destinataire.depot(valeur);
        } else {
            System.out.println("Solde insuffisant pour effectuer le virement");
        }
    }

    public float getSolde() {
        return solde;
    }
    
    public void afficherSolde() {
        System.out.println("Solde : " + solde);
    }
    

}
