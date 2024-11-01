package fr.formation.blog;

import jakarta.persistence.*;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("persistence-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(new Post("JPA niveau 1", "Découvrir JPA"));
            em.persist(new Post("JPA niveau 2", "Définir les relations"));
            em.persist(new Post("JPA niveau 3", "Utiliser le JPQL"));
            et.commit();
        }catch (Exception e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }

        em = emf.createEntityManager();
        et = em.getTransaction();
        try {
            et.begin();
            Post post = em.find(Post.class, 1L);
            Comment comment = new Comment("Top JPA !", post);
            em.persist(comment);

            et.commit();
        }catch (Exception e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
            emf.close();
        }

    }

}
