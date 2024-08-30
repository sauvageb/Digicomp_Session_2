package fr.sauvageboris.training.exercice7;

public class Banque {
    private static final int MAX_NB_CLIENTS = 100;
    private String nom;
    private Client[] clients;
    private int nbClients;

    public Banque(String nomDeLaBanque) {
        nom = nomDeLaBanque;
        clients = new Client[MAX_NB_CLIENTS];
        nbClients = 0;
    }

    public void ajouterClient(String nomClient) {
        if (nbClients < MAX_NB_CLIENTS) {
            clients[nbClients] = new Client(nomClient);
            nbClients++;
            System.out.println("Le client " + nomClient + " a été ajouté à la banque " + nom);
        } else {
            System.out.println("Nombre maximum de clients atteint pour la banque " + nom);
        }
    }

    public void bilanClient(String nomClient) {
        for (int i = 0; i < nbClients; i++) {
            if (clients[i].getNom().equals(nomClient)) {
                System.out.println("Bilan du client " + nomClient);
                clients[i].afficherSolde();
                return;
            }
        }
        System.out.println("Client non trouvé : " + nomClient);
    }

    public void afficherBilan() {
        System.out.println("Bilan général de la banque " + nom);
        for (int i = 0; i < nbClients; i++) {
            System.out.println("Client : " + clients[i].getNom());
            clients[i].afficherSolde();
        }
    }

    public int getNbClients() {
        return nbClients;
    }

    public void setNbClients(int nbClients) {
        this.nbClients = nbClients;
    }

    public Client getClient(int index) {
        return clients[index];
    }

}
