/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.controller;

import arctransport.metier.Chauffeur;
import arctransport.metier.Course;
import arctransport.metier.GestionFlote;
import arctransport.metier.Vehicule;

/**
 *
 * @author zakariae.chentouf
 */
public class Controller {

    private GestionFlote gf;

    public Controller(GestionFlote gf) {
        this.gf = gf;
    }

    public String afficherChauffeurs() {
        return gf.getChauffeurs().getChauffeurs().toString();
    }

    public Chauffeur afficherChauffeur(String matricule) {
        return gf.getChauffeurs().findChauffeurByMatricule(matricule);
    }

    public float calculerChiffreAffaire(String matricule) {
        return gf.getChiffreAffaireByChauffeur(matricule);
    }

    public void supprimerChauffeur(String matricule) {
        gf.getChauffeurs().deleteChauffeurByMatricule(matricule);
    }

    public String afficherVehicules() {
        return gf.getVehicules().getVehicules().toString();
    }

    public void supprimerVehicule(String matricule) {
        gf.getVehicules().deleteVehiculeByMatricule(matricule);
    }

    public String afficherCourses() {
        return gf.getCourses().gettAllCourses().toString();
    }

    public void ajoutVehicule(Vehicule v1) {
        gf.getVehicules().ajouteVehicule(v1);
    }

    public void ajoutChauffeur(Chauffeur chauf1) {
        gf.ajouteChauffeur(chauf1);
    }

    public float getChiffreAffaireTotal() {
        return gf.getChiffreAffaireTotal();
    }

    public void ajoutCourse(Course c1, String matriculeChauffeur, String matriculeVehicule) {
        Vehicule v = gf.getVehicules().findVehiculeByMatricule(matriculeVehicule);
        Chauffeur c = gf.getChauffeurs().findChauffeurByMatricule(matriculeChauffeur);
        gf.getCourses().addCourse(c, v, c1);
    }

    public void supprimerCourse(int numero) {
        gf.getCourses().removeCourseByNumero(numero);
    }

}
