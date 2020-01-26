/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

/**
 *
 * @author jerev
 */
@Entity
@Table(name = "personne")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;
    
    @ManyToMany(
            cascade = CascadeType.ALL,            
            fetch = FetchType.EAGER
    )
    Set<Maison> maison;
            
    
   /* @OneToOne
    Maison maison;*/
    public Personne() {
        
    }

    public Personne(Set<Maison> maison) {
        this.maison = maison;
    }

    @Override
    public String toString() {
        return "Personne " + num +"\n" + maison;
    }

}
