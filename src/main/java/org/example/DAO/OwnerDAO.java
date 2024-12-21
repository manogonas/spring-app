package org.example.DAO;

import org.example.Classes.Specialist;
import org.example.HibernateSessionFactoryUtil;
import org.example.Classes.Owner;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class OwnerDAO {
    public Owner findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Owner owner = (Owner) session.get(Owner.class, id);
        tx.commit();
        session.close();
        return owner;
    }

    public void insert(Owner owner) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(owner);;
        tx1.commit();
        session.close();
    }

    public void update(Owner owner) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(owner);
        tx1.commit();
        session.close();
    }

    public void delete(Owner owner) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(owner);
        tx1.commit();
        session.close();
    }

    public ArrayList<Owner> findAll() {
        String hql = "from Owner";
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        ArrayList<Owner> users = (ArrayList<Owner>)  session.createQuery(hql).list();
        tx1.commit();
        session.close();
        return users;
    }
}
