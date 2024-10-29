package fr.formation.demo;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Projet JDBC (Connexion Java avec une bdd MySQL)");

        FruitDao fruitDao = new FruitDao();
        List<Fruit> fruitList = fruitDao.fetchAll();
        fruitList.forEach(f -> System.out.println(f));


        Fruit fruit = new Fruit();
        Fruit savedFruit = fruitDao.save(fruit);
        // Affichage du fruit inséré (=> avec l id generé)
        System.out.println(savedFruit);


    }
}
