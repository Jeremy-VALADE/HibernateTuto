/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;
import java.util.Objects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jerev
 */
public class TestService {

    private final SessionFactory sessionFactory;

    public TestService(SessionFactory session) {
        this.sessionFactory = Objects.requireNonNull(session);
    }

    public void insertEvenement(Object even) {
        Objects.requireNonNull(even);
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(even);
        session.getTransaction().commit();
        session.close();
    }

    public Personne getAllEvenemenst() {
        Session session = this.sessionFactory.openSession();
        Personne evenements = (Personne) session.load(Personne.class, 1);
        session.close();
        return evenements;
    }
    
    
    public  List<Personne> getAllEvenement() {
        Session session = this.sessionFactory.openSession();
        List<Personne> evenements = session.createQuery("from Personne").list();
        session.close();
        return evenements;
    }
}
