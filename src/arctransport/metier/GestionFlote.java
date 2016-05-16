/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.metier;


import java.util.List;

/**
 *
 * @author zakariae.chentouf
 */
public class GestionFlote {

    private final GestionChauffeur chauffeurs;
    private final GestionVehicule vehicules;
    private final GestionCourses courses;

    public GestionFlote() {
        this.courses = new GestionCourses();
        this.chauffeurs = new GestionChauffeur();
        this.vehicules = new GestionVehicule();
    }

    public void  ajouteChauffeur(Chauffeur c){
       chauffeurs.ajouteChauffeur(c);
       courses.initializeListChauffeur(c.getMatricule());
    }
    
    public float getChiffreAffaireTotal() {
        return getChiffreAffaire(courses.gettAllCourses());
    }

    public float getChiffreAffaireByChauffeur(String matricule) {
        return getChiffreAffaireByChauffeur(chauffeurs.findChauffeurByMatricule(matricule));
    }

    public float getChiffreAffaireByChauffeur(Chauffeur c) {
        return getChiffreAffaire(courses.getCourseByChauffeur(c.getMatricule()));
    }

    private float getChiffreAffaire(List<Course> courses) {
        float chiffreAffaireTotal = 0;
        for (Course course : courses) {
            chiffreAffaireTotal = chiffreAffaireTotal + course.getPrixCourse();
        }
        return chiffreAffaireTotal;
    }

    public GestionChauffeur getChauffeurs() {
        return chauffeurs;
    }

    public GestionVehicule getVehicules() {
        return vehicules;
    }

    public GestionCourses getCourses() {
        return courses;
    }
    
    
}
