/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.metier;

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
    
    private String matricule;
    private String designation;
    private int prixMinute;
    
    public Vehicule() {}

    public Vehicule(String matricule, String designation, int prixMinute) {
        this();
        this.matricule = matricule;
        this.designation = designation;
        this.prixMinute = prixMinute;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getDesignation() {
        return designation;
    }

    public int getPrixMinute() {
        return prixMinute;
    }

    
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrixMinute(int prixMinute) {
        this.prixMinute = prixMinute;
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
    
    public boolean compareMatricule(String matriculeO){
        boolean ok = false;
        if (matriculeO == this.matricule) {
            ok = true;
        }
        return ok ;
    }
    
    public String toString(){
        StringBuilder vehiculeInformation = new StringBuilder();
        
        vehiculeInformation.append(matricule);
        vehiculeInformation.append(", ");
        vehiculeInformation.append(designation);
        vehiculeInformation.append(", ");
        vehiculeInformation.append(prixMinute);
        vehiculeInformation.append(" chf/min");
        vehiculeInformation.append(System.getProperty("line.separator"));
        
        return vehiculeInformation.toString();
    }

    
    
}
