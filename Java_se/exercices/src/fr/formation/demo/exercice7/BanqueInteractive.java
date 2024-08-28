package fr.sauvageboris.training.exercice7;

import java.util.Scanner;

public class BanqueInteractive {

    public static void main(String[] args) {
        BanqueInteractive banqueInteractive = new BanqueInteractive("Boris Bank");
        banqueInteractive.interaction();
    }

    private Banque banque;

    public BanqueInteractive(String nomBanque) {
        this.banque = new Banque(nomBanque);
    }

    public void interaction() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("Quelle opération voulez-vous effectuer ?");
            System.out.println("1) Ajouter un client");
            System.out.println("2) Effectuer une opération sur un client");
            System.out.println("3) Afficher un bilan général");
            System.out.print("- ");

            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    interactionAjoutClient(scanner);
                    break;
                case 2:
                    interactionOperationClient(scanner);
                    break;
                case 3:
                    banque.afficherBilan();
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }

        } while (choix != 3);

        scanner.close();
    }

    public void interactionAjoutClient(Scanner scanner) {
        System.out.println("Entrez le nom du client :");
        scanner.nextLine();
        String nomClient = scanner.nextLine();

        banque.ajouterClient(nomClient);
    }

    public void interactionOperationClient(Scanner scanner) {
        {
            System.out.println("Quel client ?");
            for (int i = 0; i < banque.getNbClients(); i++) {
                System.out.println((i + 1) + ") " + banque.getClient(i).getNom());
            }
            System.out.print("- ");
            int choixClient = scanner.nextInt();

            if (choixClient > 0 && choixClient <= banque.getNbClients()) {
                Client client = banque.getClient(choixClient - 1);

                System.out.println("Quelle opération voulez-vous effectuer sur le client " + client.getNom() + " ?");
                System.out.println("1) Afficher un bilan");
                System.out.println("2) Faire un retrait");
                System.out.println("3) Faire un dépôt");
                System.out.println("4) Faire un virement");
                System.out.print("- ");
                int choixOperation = scanner.nextInt();

                switch (choixOperation) {
                    case 1:
                        banque.bilanClient(client.getNom());
                        break;
                    case 2:
                        System.out.println("Montant du retrait : ");
                        System.out.print("- ");
                        float montantRetrait = scanner.nextFloat();
                        client.getCompteCourant().retrait(montantRetrait);
                        break;
                    case 3:
                        System.out.println("Montant du dépôt : ");
                        System.out.print("- ");
                        float montantDepot = scanner.nextFloat();
                        client.getCompteCourant().depot(montantDepot);
                        break;
                    case 4:
                        System.out.println("Montant du virement : ");
                        System.out.print("- ");
                        float montantVirement = scanner.nextFloat();

                        client.getCompteCourant().virer(montantVirement, client.getCompteCourant());
                        break;
                    default:
                        System.out.println("Choix invalide");
                        break;
                }
            } else {
                System.out.println("Client invalide");
            }
        }
    }
}
