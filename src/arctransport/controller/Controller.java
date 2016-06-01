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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zakariae.chentouf
 */
public class Controller {

    private GestionFlote gf;

    public Controller(GestionFlote gf) {
        try {
            this.gf = gf;
            // Donnée test;
            Chauffeur chauffeurTest = new Chauffeur("12", "jean", "bonneau");
            ajoutChauffeur(chauffeurTest);
            Chauffeur chauffeurTest2 = new Chauffeur("2", "paul", "Conex");
            ajoutChauffeur(chauffeurTest2);
            Vehicule vehiculeTest = new Vehicule("121", "opel saphira", 1);
            ajoutVehicule(vehiculeTest);
            Vehicule vehiculeTest2 = new Vehicule("3", "MERCEDES BENZ EASY", 3);
            ajoutVehicule(vehiculeTest2);
            SimpleDateFormat formatter = new SimpleDateFormat("MM dd, yyyy HH:mm:ss");
            String dateInString = "07 07, 2013 12:10:56";
            String dateInString2 = "07 07, 2013 12:15:56";
            Course courseTest1 = new Course(42, formatter.parse(dateInString), formatter.parse(dateInString2));
            ajoutCourse(courseTest1, chauffeurTest.getMatricule(), vehiculeTest.getMatricule());
            Course courseTest2 = new Course(43, formatter.parse(dateInString), formatter.parse(dateInString2));
            ajoutCourse(courseTest2, chauffeurTest2.getMatricule(), vehiculeTest2.getMatricule());
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    public void ajoutCourse(Course c1, String matriculeChauffeur, String matriculeVehicule)throws IllegalArgumentException  {
        Vehicule v = gf.getVehicules().findVehiculeByMatricule(matriculeVehicule);
        Chauffeur c = gf.getChauffeurs().findChauffeurByMatricule(matriculeChauffeur);
        gf.getCourses().addCourse(c, v, c1);
    }

    public void supprimerCourse(int numero) {
        gf.getCourses().removeCourseByNumero(numero);
    }

}
