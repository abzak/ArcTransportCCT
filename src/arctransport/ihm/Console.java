/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.ihm;

import arctransport.controller.Controller;

/**
 *
 * @author chloe.trachsel
 */
public class Console {
    
    private Controller ctrl;

    public Console(Controller ctrl) {
        this.ctrl = ctrl;
    }
    
    
    public void AfficheMenuFlotte(){
        System.out.println("");
        System.out.println("-- Menu Principale de la Flotte--");
        System.out.println("[] -- Gestion des Chauffeurs");
        System.out.println("[] -- Gestion des Véhicules");
        System.out.println("[] -- Gestion des Courses");
        System.out.println("[] -- Calculer le chiffer d'affaire total");
        System.out.println("[] -- Quitter");
        System.out.println("");
    }
    
    public void AfficheMenuChauffeur(){
        System.out.println("");
        System.out.println("-- Menu Gestion des chauffeurs --");
        System.out.println("[] -- Afficher tous les Chauffeurs");
        System.out.println("[] -- Calculer le chiffer d'affaire d'un chauffeur");
        System.out.println("[] -- Afficher un chauffeur (matricule)");
        System.out.println("[] -- Ajouter un chauffeur");
        System.out.println("[] -- Supprimer un chauffeur");
        System.out.println("[] -- retour");
        System.out.println("");
    }
    
    public void AfficheMenuCourse(){
        System.out.println("");
        System.out.println("-- Menu Gestion des Courses --");
        System.out.println("[] -- Afficher toutes les Courses");
        System.out.println("[] -- Ajouter un Course");
        System.out.println("[] -- Supprimer un Course");
        System.out.println("[] -- retour");
        System.out.println("");
    }
    
    public void AfficheMenuVehicule(){
        System.out.println("");
        System.out.println("-- Menu Gestion des Véhicules --");
        System.out.println("[] -- Afficher toutes les Véhicules");
        System.out.println("[] -- Ajouter un Véhicule");
        System.out.println("[] -- Supprimer un Véhicule");
        System.out.println("[] -- retour");
        System.out.println("");
    }

    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
