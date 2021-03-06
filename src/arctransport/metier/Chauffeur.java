/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.metier;

import java.util.Objects;

/**
 *
 * @author Zakaria Chentouf
 * @mail zakaria.chentouf@he-arc.ch
 */

//Zakaria Chentouf

public class Chauffeur {
    private String matricule;
    private String nom;
    private String prenom;

    public Chauffeur() { 
    }

    public Chauffeur(String matricule, String nom, String prenom) {
        this();
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
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
        final Chauffeur other = (Chauffeur) obj;
        if (!Objects.equals(this.matricule, other.matricule)) {
            return false;
        }
        return true;
    }
    
    public boolean findByMatricule(String matriculeO){
        boolean ok = false;
        if (matriculeO.equals(this.matricule)) {
            ok = true;
        }
        return ok ;
    }
    
    public float getChiffreDAffaire(){
     return 0;
    }
    
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String toString(){
        StringBuilder chauffeurInfo = new StringBuilder();
        chauffeurInfo.append("Matricule : ");
        chauffeurInfo.append(matricule);
        chauffeurInfo.append(", ");
        chauffeurInfo.append("Nom : ");
        chauffeurInfo.append(nom);
        chauffeurInfo.append(" ");
        chauffeurInfo.append("Prenom : ");
        chauffeurInfo.append(prenom);
        chauffeurInfo.append(System.getProperty("line.separator"));

        return chauffeurInfo.toString();
    }
  
}
