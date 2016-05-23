/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.ihm;

import arctransport.controller.Controller;
import java.util.Scanner;

/**
 *
 * @author chloe.trachsel
 */
public class Console {

    private Controller ctrl;
    private Scanner sc;

    public Console(Controller ctrl) {
        this.ctrl = ctrl;
        sc = new Scanner(System.in);
    }

    public void afficheMenuFlotte() {
        System.out.println("");
        System.out.println("-- Menu Principale de la Flotte--");
        System.out.println("[1] -- Gestion des Chauffeurs");
        System.out.println("[2] -- Gestion des Véhicules");
        System.out.println("[3] -- Gestion des Courses");
        System.out.println("[4] -- Calculer le chiffer d'affaire total");
        System.out.println("[0] -- Quitter");
        System.out.println("");
    }

    public void afficheMenuChauffeur() {
        System.out.println("");
        System.out.println("-- Menu Gestion des chauffeurs --");
        System.out.println("[1] -- Afficher tous les Chauffeurs");
        System.out.println("[2] -- Calculer le chiffer d'affaire d'un chauffeur");
        System.out.println("[3] -- Afficher un chauffeur (matricule)");
        System.out.println("[4] -- Ajouter un chauffeur");
        System.out.println("[5] -- Supprimer un chauffeur");
        System.out.println("[6] -- retour");
        System.out.println("");
    }

    public void afficheMenuCourse() {
        System.out.println("");
        System.out.println("-- Menu Gestion des Courses --");
        System.out.println("[1] -- Afficher toutes les Courses");
        System.out.println("[2] -- Ajouter un Course");
        System.out.println("[3] -- Supprimer un Course");
        System.out.println("[4] -- retour");
        System.out.println("");
    }

    public void afficheMenuVehicule() {
        System.out.println("");
        System.out.println("-- Menu Gestion des Véhicules --");
        System.out.println("[1] -- Afficher toutes les Véhicules");
        System.out.println("[2] -- Ajouter un Véhicule");
        System.out.println("[3] -- Supprimer un Véhicule");
        System.out.println("[4] -- retour");
        System.out.println("");
    }

    public void start() { 
        afficheMenuFlotte();
        selectMenuPrincipal();

    }

    private int readValueInt() {
        int valeur = sc.nextInt();
        sc.nextLine();
        return valeur;
    }
    
    

    private void selectMenuPrincipal() {
        switch (readValueInt()) {
            case 1:
                afficheMenuChauffeur();
                break;
            case 2:
                afficheMenuVehicule();
                break;
            case 3:
                afficheMenuCourse();
                break;
            case 4:  //TODO
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Valeur erronee");
                break;
        }
    }

    private void selectMenuChauffeur() {
        switch (readValueInt()) {
            case 1:
                ctrl.afficherChauffeurs();
                break;
            case 2:
                System.out.println("Entrez matricule");
                ctrl.calculerChiffreAffaire(sc.nextLine());
                break;
            case 3:
                System.out.println("Entrez matricule");
                ctrl.afficherChauffeur(sc.nextLine());
                break;
            case 4:  
                System.out.println("Entrez matricule chauffeur");
                String matricule;
                matricule = sc.nextLine();
                System.out.println("Entrez nom chauffeur");
                String nom;
                nom = sc.nextLine();
                System.out.println("Entrez prenom chauffeur");
                String prenom;
                prenom = sc.nextLine();
                ctrl.ajoutChauffeur(matricule, nom, prenom);
                break;
            case 5:  
                System.out.println("Entrez matricule");
                ctrl.supprimerChauffeur(sc.nextLine());
                break;
            case 6:  
                selectMenuPrincipal();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Valeur erronee");
                break;
        }
    }

    private void selectMenuVehicule() {
        switch (readValueInt()) {
            case 1:
                afficheMenuChauffeur();
                break;
            case 2:
                afficheMenuVehicule();
                break;
            case 3:
                afficheMenuCourse();
                break;
            case 4:  //TODO
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Valeur erronee");
                break;
        }
    }

    private void selectMenuCourse() {
        switch (readValueInt()) {
            case 1:
                afficheMenuChauffeur();
                break;
            case 2:
                afficheMenuVehicule();
                break;
            case 3:
                afficheMenuCourse();
                break;
            case 4:  //TODO
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Valeur erronee");
                break;
        }
    }

}
