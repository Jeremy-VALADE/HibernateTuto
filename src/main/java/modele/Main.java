/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.File;
import java.util.ArrayList;
import javax.crypto.AEADBadTagException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author jerev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestService t= new TestService(createSessionFactory());
        Maison l = new Maison("toto");
        Maison u = new Maison("lance");
        t.insertEvenement(l);
        t.insertEvenement(u);
        ArrayList<Maison> maisons = new ArrayList<>();
        maisons.add(l);
        maisons.add(u);
        t.insertEvenement(new Personne(l));
        maisons = new ArrayList<>();       
        maisons.add(new Maison("oui"));
       t.insertEvenement(new Personne(l));
        for (Personne p : t.getAllEvenement())
            System.out.println(p);
    }

    public static SessionFactory createSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure(new File("hibernate.cfg.xml")).build();
        try {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return null;
    }
}
