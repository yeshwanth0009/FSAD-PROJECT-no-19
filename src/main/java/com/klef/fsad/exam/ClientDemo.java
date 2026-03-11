package com.klef.fsad.exam;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fsadexam");
        EntityManager em = emf.createEntityManager();

        // INSERT RECORD
        em.getTransaction().begin();

        Product p = new Product();
        p.setName("Laptop");
        p.setDescription("Dell Inspiron");
        p.setDate(new Date());
        p.setStatus("Available");

        em.persist(p);

        em.getTransaction().commit();

        System.out.println("Record Inserted Successfully");

        // UPDATE RECORD
        em.getTransaction().begin();

        Product pr = em.find(Product.class, p.getId());

        if(pr != null)
        {
            pr.setName("Gaming Laptop");
            pr.setStatus("Out of Stock");
        }

        em.getTransaction().commit();

        System.out.println("Record Updated Successfully");

        em.close();
        emf.close();
    }
}