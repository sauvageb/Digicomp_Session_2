package fr.formation.demo;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        System.out.println("Projet JDBC (Connexion Java avec une bdd MySQL)");

        FruitDao fruitDao = new FruitDao();

        // Récupérer tous les fruits
        List<Fruit> fruitList = fruitDao.fetchAll();
        fruitList.forEach(f -> System.out.println(f));

        // Insertion d'un nouveau fruit
        Fruit fruitToSave = new Fruit("Poire", LocalDate.now());
        Fruit savedFruit = fruitDao.save(fruitToSave);
        System.out.println("Fruit inséré : " + savedFruit);


        // Récupération d'un fruit par ID
        Optional<Fruit> fruitOptional1 = fruitDao.fetchById(1L);
        fruitOptional1.ifPresent(fruit -> System.out.println("Fruit avec ID 1 : " + fruit.getName()));

        // Mise à jour d'un fruit
        fruitOptional1.ifPresent(fruit -> {
            fruit.setName("Poire mise à jour");
            Optional<Fruit> updatedFruit = fruitDao.update(fruit);
            updatedFruit.ifPresentOrElse(
                    f -> System.out.println("Fruit mis à jour : " + f),
                    () -> System.out.println("Erreur lors de la mise à jour du fruit.")
            );
        });

        // Suppression d'un fruit par ID
        boolean isDeleted = fruitDao.deleteById(1L);
        if (isDeleted) {
            System.out.println("Fruit avec ID 1 supprimé avec succès.");
        } else {
            System.out.println("Erreur lors de la suppression du fruit avec ID 1.");
        }

        // Vérification de la suppression
        Optional<Fruit> deletedFruit = fruitDao.fetchById(1L);
        if (deletedFruit.isEmpty()) {
            System.out.println("Le fruit avec ID 1 n'existe plus.");
        } else {
            System.out.println("Le fruit avec ID 1 existe toujours : " + deletedFruit.get().getName());
        }
    }

}
