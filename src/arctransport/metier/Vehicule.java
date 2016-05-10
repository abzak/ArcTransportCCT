/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author chloe.trachsel
 */

//Chloé Trachsel

public class Vehicule {
    /*Taxe de base
        0 - 5 km --> 10.-
        6 - 10km --> 8.-
         > 10 km --> 5.-
    */
    
    private int matricule;
    private String designation;
    private int prixMinute;
    private List<Course> listeCourses;

    public Vehicule() {
        listeCourses = new ArrayList<>();
    }

    public Vehicule(int matricule, String designation, int prixMinute, Course listeCourses) {
        this();
        this.matricule = matricule;
        this.designation = designation;
        this.prixMinute = prixMinute;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getDesignation() {
        return designation;
    }

    public int getPrixMinute() {
        return prixMinute;
    }

    public List<Course> getListeCourses() {
        return listeCourses;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrixMinute(int prixMinute) {
        this.prixMinute = prixMinute;
    }

    public void setListeCourses(List<Course> listeCourses) {
        this.listeCourses = listeCourses;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.matricule);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicule other = (Vehicule) obj;
        if (!Objects.equals(this.matricule, other.matricule)) {
            return false;
        }
        if (!Objects.equals(this.designation, other.designation)) {
            return false;
        }
        return true;
    }
    
    
}
