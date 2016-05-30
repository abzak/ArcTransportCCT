/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zakariae.chentouf
 */
public class GestionCourses {

    private final Map<String, List<Course>> mapCourseParChauffeur;

    public GestionCourses() {
        this.mapCourseParChauffeur = new HashMap<>();
    }

    public void addCourse(Chauffeur cf, Vehicule v, Course crs) throws IllegalArgumentException {
        if (this.isCourseValide(crs)) {
            crs.setChauffeur(cf);
            crs.setVehicule(v);
            mapCourseParChauffeur.get(cf.getMatricule()).add(crs);
        }else{
            throw new IllegalArgumentException("Course invalide, véhicule occupé !");
        }
        

    }

    public void removeCourse(Course crs) {
        mapCourseParChauffeur.get(crs.getChauffeur().getMatricule()).remove(crs);
    }

    public List<Course> gettAllCourses() {
        List courses = new ArrayList<>();
        mapCourseParChauffeur.entrySet().stream().forEach((entry) -> {
            courses.add(entry.getValue());
        });
        return courses;
    }

    public List<Course> getCourseByChauffeur(String matricule) {
        return mapCourseParChauffeur.get(matricule);
    }

    public void initializeListChauffeur(String matricule) {
        mapCourseParChauffeur.put(matricule, new ArrayList<>());
    }

    public List<Course> getCoursesByVehicule(String matricule) {
        List courses = new ArrayList<>();
        mapCourseParChauffeur.entrySet().stream().forEach((entry) -> {
            for (Course course : entry.getValue()) {
                if (course.getVehicule().compareMatricule(matricule)) {
                    courses.add(course);
                }
            }
        });
        return courses;
    }

    public Course selectCourseByNumero(int numero) throws IllegalArgumentException{
        for (Map.Entry<String, List<Course>> entry : mapCourseParChauffeur.entrySet()) {
            for (Course course : entry.getValue()) {
                if (course.getNumero() == numero) {
                    return course;
                }
            }
        }
        throw new IllegalArgumentException("Numero Inconnu");
    }

    public void removeCourseByNumero(int numero) {
        try {
            Course crs = selectCourseByNumero(numero);
            mapCourseParChauffeur.get(crs.getChauffeur().getMatricule()).remove(crs);
        } catch (Exception e) {
            System.out.println("ERREUR \"Le numéro de course selectionné est invalide !\"");
        }
    }
    
    public Boolean isCourseValide(Course courseTested){
        for (Course course : this.getCoursesByVehicule(courseTested.getVehicule().getMatricule())) {
            if (course.isMeanwhile(courseTested)) {
                return false;
            }
        }
        return true;
    }

}
