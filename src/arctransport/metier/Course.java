/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Thibault Daucourt
 */
public class Course {
    private static int compteur ;
    
    private int numero;// numero de gestion
    private int distance; //en km, distance >= 0
    private Date dateDebut; // date format a définir
    private Date dateFin; // date format a définir
    private Chauffeur chauffeur;
    private Vehicule vehicule;


    /*Taxe de base
     0 - 5 km --> 10.-
     6 - 10km --> 8.-
     > 10 km --> 5.-
     */
    // retourne la valeur de la taxe de la course
    private int calculerTaxe() {
        if (distance > 10) {
            return 5;
        } else if (distance > 5) {
            return 8;
        } else {
            return 10;
        }
    }

    public float getPrixCourse() {
        long diffMinutes = (dateFin.getTime() - dateDebut.getTime()) / (60 * 1000) % 60;
        return  (diffMinutes * vehicule.getPrixMinute() )+ this.calculerTaxe();
    }

    public Course() {
    }

    public Course(int distance, Date dateDebut, Date dateFin) {
        compteur += 1;
        this.numero = compteur;
        this.distance = distance;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Course(int distance, Date dateDebut, Date dateFin,  Chauffeur chauffeur, Vehicule vehicule) {
        this(distance, dateDebut, dateFin);
        this.chauffeur = chauffeur;
        this.vehicule = vehicule;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.dateDebut);
        hash = 23 * hash + Objects.hashCode(this.dateFin);
        hash = 23 * hash + Objects.hashCode(this.chauffeur);
        hash = 23 * hash + Objects.hashCode(this.vehicule);
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
        final Course other = (Course) obj;
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        if (!Objects.equals(this.chauffeur, other.chauffeur)) {
            return false;
        }
        if (!Objects.equals(this.vehicule, other.vehicule)) {
            return false;
        }
        return true;
    }
    
    
    // teste si le début de la course testé est avant lé fin de la course source
    // et test si la fin de la course testé est après le début de la course source
    // pour déterminer si elles se chevauchent
    public Boolean isMeanwhile(Course courseTested){    
         if(courseTested.dateDebut.before(dateFin) && courseTested.dateFin.after(dateDebut)){
             return true;
         }else{
             return false;
         }
     }
    
    public String toString(){
        StringBuilder string = new StringBuilder();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        
        string.append("Course no ");
        string.append(numero);       
        string.append(", ");
        string.append(df.format(dateDebut));
        string.append(" - ");
        string.append(df.format(dateFin));
        string.append(" / ");
        string.append(distance);
        string.append(" km");
        
        return string.toString();
    }

}
