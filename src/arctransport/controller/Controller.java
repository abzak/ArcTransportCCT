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

    public void afficherChauffeurs() {
        gf.getChauffeurs().getChauffeurs().toString();
    }

    public void afficherChauffeur(String matricule) {
        gf.getChauffeurs().findChauffeurByMatricule(matricule);
    }

    public void calculerChiffreAffaire(String matricule) {
        gf.getChiffreAffaireByChauffeur(matricule);
    }

    public void supprimerChauffeur(String matricule) {
        gf.getChauffeurs().deleteChauffeurByMatricule(matricule);
    }

    public void afficherVehicules() {
        gf.getVehicules().getVehicules().toString();
    }

    public void supprimerVehicule(int matricule) {
        gf.getVehicules().deleteVehiculeByMatricule(matricule);
    }

    public void afficherCourses() {
        gf.getCourses().gettAllCourses().toString();
    }

    public void ajoutVehicule(Vehicule v1) {
        gf.getVehicules().ajouteVehicule(v1);
    }

    public void ajoutChauffeur(Chauffeur chauf1) {
        gf.ajouteChauffeur(chauf1);
    }

    public void getChiffreAffaireTotal() {
        gf.getChiffreAffaireTotal();
    }

    public void ajoutCourse(Course c1, String matriculeChauffeur, int matriculeVehicule) {
        Vehicule v = gf.getVehicules().findVehiculeByMatricule(matriculeVehicule);
        Chauffeur c = gf.getChauffeurs().findChauffeurByMatricule(matriculeChauffeur);
        gf.getCourses().addCourse(c, v, c1);
    }
    
    
    
}
