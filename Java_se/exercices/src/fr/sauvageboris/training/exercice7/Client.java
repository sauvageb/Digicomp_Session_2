package fr.sauvageboris.training.exercice7;

public class Client {
    private static final int MAX_NB_COMPTES = 100;

    private String nom;
    private Compte[] comptes;
    private int nbComptes;

    public Client(String nomDuClient) {
        this.nom = nomDuClient;
        this.comptes = new Compte[MAX_NB_COMPTES];
        this.comptes[nbComptes] = new Compte();
        this.nbComptes = this.nbComptes + 1;
    }

    public Compte getCompteCourant() {
        return this.comptes[0];
    }

    public float getSolde() {
        float sommeSolde = 0;
        for (int i = 0; i < nbComptes; i++) {
            sommeSolde += comptes[i].getSolde();
        }
        return sommeSolde;
    }

    public void afficherSolde() {
        System.out.println("Solde total du client " + nom + " : " + getSolde());
    }

    public void ajouterCompte() {
        if (nbComptes < MAX_NB_COMPTES) {
            comptes[nbComptes] = new Compte();
            nbComptes++;
            System.out.println("Nouveau compte ajouté pour le client " + nom);
        } else {
            System.out.println("Nombre maximum de comptes atteint pour le client " + nom);
        }
    }

    public String getNom() {
        return nom;
    }

}
