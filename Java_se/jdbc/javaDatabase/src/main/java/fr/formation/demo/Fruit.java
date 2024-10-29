package fr.formation.demo;


import java.time.LocalDate;

public class Fruit {
    private Long id;
    private String name;
    private LocalDate expirationDate;

    public Fruit(Long id, String name, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
