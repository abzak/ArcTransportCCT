/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zakariae.chentouf
 */
public class GestionCourses {

    private List<Course> courses;
    private List<Chauffeur> chauffeurs;
    private List<Vehicule> vehicules;

    public GestionCourses() {
        this.courses = new ArrayList<>();
        this.chauffeurs = new ArrayList<>();
        this.vehicules = new ArrayList<>();
    }

    public void ajouteChauffeur(Chauffeur c) {
        chauffeurs.add(c);
    }

    public Chauffeur findChauffeurByMatricule(String matricule) {
        Chauffeur cRecherche = null;
        for (Chauffeur c : chauffeurs) {
            if (c.findByMatricule(matricule)) {
                cRecherche = c;
                break;
            }
        }
        return cRecherche;
    }

    public void deleteChauffeur(Chauffeur c) {
        chauffeurs.remove(c);
    }

    public void deleteChauffeurByMatricule(String matricule) {
        deleteChauffeur(findChauffeurByMatricule(matricule));
    }

    public void ajouteVehicule(Vehicule v) {
        vehicules.add(v);
    }

    public Vehicule findVehiculeByMatricule(String matricule) {
        Vehicule vRecherche = null;
        for (Vehicule v : vehicules) {
            if (v.findByMatricule(matricule)) {
                vRecherche = v;
                break;
            }
        }
        return vRecherche;
    }

    public void deleteVehicule(Vehicule v) {
        vehicules.remove(v);
    }

    public void deleteVehiculeByMatricule(String matricule) {
        deleteVehicule(findVehiculeByMatricule(matricule));
    }

    public void addCourse(Chauffeur cf, Vehicule v, Course crs) {
        crs.setChauffeur(cf);
        crs.setVehicule(v);
        addCourseOnAllList(cf, v, crs);
    }

    private void addCourseOnAllList(Chauffeur cf, Vehicule v, Course crs) {
        courses.add(crs);
        cf.getCourses().add(crs);
        v.getCourses().add(crs);
    }

    private void removeCourse(Course c) {
        c.getChauffeur().getCourses().remove(c);
        c.getVehicule().getCourses().remove(c);
        courses.remove(c);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Chauffeur> getChauffeurs() {
        return chauffeurs;
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public float getChiffreAffaireTotal() {
          return getChiffreAffaire(courses);
    }
    
    public float getChiffreAffaireByChauffeur(String matricule){
        return getChiffreAffaireByChauffeur(findChauffeurByMatricule(matricule));
    }
    
    public float getChiffreAffaireByChauffeur(Chauffeur c){
         return getChiffreAffaire(c.getCourses());
    }

    private float getChiffreAffaire(List<Course> courses) {
        float chiffreAffaireTotal = 0;
        for (Course course : courses) {
            chiffreAffaireTotal = chiffreAffaireTotal + course.getPrixCourse();
        }
        return chiffreAffaireTotal;
    }

    
}

