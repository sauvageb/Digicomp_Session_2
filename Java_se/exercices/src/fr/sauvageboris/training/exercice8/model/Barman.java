package fr.sauvageboris.training.exercice8.model;

public class Barman extends Human {

    private String barName;

    public Barman(String name) {
        this(name, "Chez " + name);
    }

    public Barman(String name, String barName) {
        super(name, "vin");
        this.barName = barName;
    }

    @Override
    public void speak(String text) {
        super.speak(text + ", Coco");
    }

    @Override
    public void introduce() {
        super.introduce();
        this.speak("N'oubliez pas de venir boire un coup à " + this.barName);
    }

    public void serve(Human human) {
        this.speak("Voilà votre verre de " + human.getDrink());
        human.drink();
    }

    public String getBarName() {
        return barName;
    }
}
