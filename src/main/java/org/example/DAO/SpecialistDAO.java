package org.example.DAO;

import org.example.HibernateSessionFactoryUtil;
import org.example.Classes.Specialist;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SpecialistDAO {
    public Specialist findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Specialist specialist = (Specialist) session.get(Specialist.class, id);
        tx.commit();
        session.close();
        return specialist;
    }

    public void insert(Specialist specialist) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(specialist);;
        tx1.commit();
        session.close();
    }

    public void update(Specialist specialist) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(specialist);
        tx1.commit();
        session.close();
    }

    public void delete(Specialist specialist) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(specialist);
        tx1.commit();
        session.close();
    }

    public ArrayList<Specialist> findAll() {
        String hql = "from Specialist";
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        ArrayList<Specialist> users = (ArrayList<Specialist>)  session.createQuery(hql).list();
        tx1.commit();
        session.close();
        return users;
    }
}
