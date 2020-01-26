/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author jerev
 */
@Entity
@Table (name="maison")
public class Maison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;
    private String nom;
    public Maison() {
    }

    public Maison(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Maison{" + "nom=" + nom + '}';
    }
    
    
    
    
}
