/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.metier;

import java.util.Date;

/**
 *
 * @author chloe.trachsel
 */

//Thibault Daucourt

public class Course {
    private int distance; //en km, distance >= 0
    private Date dateDebut; // date format a définir
    private Date dateFin; // date format a définir
    private float prix ; // prix par minute

    
        
        /*Taxe de base
        0 - 5 km --> 10.-
        6 - 10km --> 8.-
         > 10 km --> 5.-
        */

    // retourne la valeur de la taxe de la course
    private int CalculerTaxe(){
        if (distance > 10) {
            return 5;
        } else if(distance > 5) {
            return 8;
        }else {
            return 10;
        }
    }
    
    public float RecetteCourse(){
        return distance * prix + this.CalculerTaxe();
    }
    
    public Course(int distance, Date dateDebut, Date dateFin, float prix) {
        this.distance = distance;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    
        
        
    }

    
    
}
