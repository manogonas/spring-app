package org.example.DAO;

import org.example.Classes.Specialist;
import org.example.HibernateSessionFactoryUtil;
import org.example.Classes.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class PetDAO {
    public Pet findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Pet pet = (Pet) session.get(Pet.class, id);
        tx.commit();
        session.close();
        return pet;
    }

    public void insert(Pet pet) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(pet);;
        tx1.commit();
        session.close();
    }

    public void update(Pet pet) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(pet);
        tx1.commit();
        session.close();
    }

    public void delete(Pet pet) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(pet);
        tx1.commit();
        session.close();
    }

    public ArrayList<Pet> findAll() {
        String hql = "from Pet";
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        ArrayList<Pet> users = (ArrayList<Pet>)  session.createQuery(hql).list();
        tx1.commit();
        session.close();
        return users;
    }
}