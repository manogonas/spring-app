package org.example.DAO;

import org.example.Classes.Specialist;
import org.example.HibernateSessionFactoryUtil;
import org.example.Classes.Story;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class StoryDAO {
    public Story findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Story.class, id);
    }

    public void insert(Story story) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(story);;
        tx1.commit();
        session.close();
    }

    public void update(Story story) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(story);
        tx1.commit();
        session.close();
    }

    public void delete(Story story) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(story);
        tx1.commit();
        session.close();
    }

    public ArrayList<Story> findAll() {
        String hql = "from Story";
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        ArrayList<Story> users = (ArrayList<Story>)  session.createQuery(hql).list();
        tx1.commit();
        session.close();
        return users;
    }
}
