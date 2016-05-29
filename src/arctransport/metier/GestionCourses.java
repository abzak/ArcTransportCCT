/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

    public void addCourse(Chauffeur cf, Vehicule v, Course crs) {
        crs.setChauffeur(cf);
        crs.setVehicule(v);
        mapCourseParChauffeur.get(cf.getMatricule()).add(crs);

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

    public List<Course> getCoursesByVehicule(int matricule) {
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
    
    public Course selectCourseByNumero(int numero){
        Course retour = null;
        Boolean found = false;
        for (Map.Entry<String, List<Course>> entry : mapCourseParChauffeur.entrySet()) {
            String key = entry.getKey();
            List<Course> value = entry.getValue();
            for (Iterator<Course> iterator = value.iterator(); iterator.hasNext();) {
                Course next = iterator.next();
                if (next.getNumero() == numero) {
                    retour = next;
                    found = true;
                }
                if(found)
                    break;
            }
            if(found)
                    break;
        }
        if(!found){
            throw new IllegalArgumentException("erreur matricule invalide !");
        }
        return retour;
    }
    
    public void removeCourseByNumero(int numero) {
        try {
            Course crs = selectCourseByNumero(numero);
            mapCourseParChauffeur.get(crs.getChauffeur().getMatricule()).remove(crs);
        } catch (Exception e) {
            System.out.println("ERREUR \"Le numéro de course selectionné est invalide !\"");
        }
    }

}
