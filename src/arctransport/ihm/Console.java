/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport.ihm;

import arctransport.controller.Controller;
import arctransport.metier.Chauffeur;
import arctransport.metier.Course;
import arctransport.metier.Vehicule;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        selectMenuPrincipal();
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
        selectMenuChauffeur();

    }

    public void afficheMenuCourse() {
        System.out.println("");
        System.out.println("-- Menu Gestion des Courses --");
        System.out.println("[1] -- Afficher toutes les Courses");
        System.out.println("[2] -- Ajouter un Course");
        System.out.println("[3] -- Supprimer un Course");
        System.out.println("[4] -- retour");
        System.out.println("");
        selectMenuCourse();
    
    }

    public void afficheMenuVehicule() {
        System.out.println("");
        System.out.println("-- Menu Gestion des Véhicules --");
        System.out.println("[1] -- Afficher toutes les Véhicules");
        System.out.println("[2] -- Ajouter un Véhicule");
        System.out.println("[3] -- Supprimer un Véhicule");
        System.out.println("[4] -- retour");
        System.out.println("");
        selectMenuVehicule();
    }

    public void start() {
        afficheMenuFlotte();

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
            case 4:
                System.out.println("CHIFFRE D'AFFAIRE TOTAL : " +ctrl.getChiffreAffaireTotal());
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Valeur erronee");
                break;
        }
        afficheMenuFlotte();
    }

    private void selectMenuChauffeur() {
        switch (readValueInt()) {
            case 1:
                System.out.println(ctrl.afficherChauffeurs());
                break;
            case 2:
                System.out.println("Entrez matricule");
                System.out.println("Chiffre d'affaire : " + ctrl.calculerChiffreAffaire(sc.nextLine()));
                break;
            case 3:
                System.out.println("Entrez matricule");
                System.out.println(ctrl.afficherChauffeur(sc.nextLine()));
                break;
            case 4:
                Chauffeur nouveauChauffeur = new Chauffeur();
                System.out.println("Entrez matricule chauffeur");
                nouveauChauffeur.setMatricule(sc.nextLine());
                System.out.println("Entrez nom chauffeur");
                nouveauChauffeur.setNom(sc.nextLine());
                System.out.println("Entrez prenom chauffeur");
                nouveauChauffeur.setPrenom(sc.nextLine());
                ctrl.ajoutChauffeur(nouveauChauffeur);
                break;
            case 5:
                System.out.println("Entrez matricule");
                ctrl.supprimerChauffeur(sc.nextLine());
                break;
            case 6:
                afficheMenuFlotte();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Valeur erronee");
                break;
        }
        afficheMenuChauffeur();
    }

    private void selectMenuVehicule() {
        switch (readValueInt()) {
            case 1:
                System.out.println(ctrl.afficherVehicules());
                break;
            case 2:
                Vehicule nouveauVehicule = new Vehicule();
                System.out.println("Entrez matricule vehicule");
                nouveauVehicule.setMatricule(sc.nextLine());
                System.out.println("Entrez designation vehicule");
                nouveauVehicule.setDesignation(sc.nextLine());
                System.out.println("Entrez prix/minute pour vehicule (Seulelement chiffre plein)");
                nouveauVehicule.setPrixMinute(readValueInt());
                ctrl.ajoutVehicule(nouveauVehicule);
                break;
            case 3:
                System.out.println("Entrez matricule");
                ctrl.supprimerVehicule(sc.nextLine());
                break;
            case 4:
                afficheMenuFlotte();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Valeur erronee");
                break;
        }
        afficheMenuVehicule();
    }

    private void selectMenuCourse() {
        switch (readValueInt()) {
            case 1:
                System.out.println(ctrl.afficherCourses());
                break;
            case 2:
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy:HH:MM");
                    Course nouvelCourse = new Course();
                    String matriculeChauffeur = "";
                    System.out.println("Entrez distance course");
                    nouvelCourse.setDistance(readValueInt());
                    System.out.println("Entrez date debut course (dd-MM-yyyy:HH:MM)");
                    nouvelCourse.setDateDebut(formatter.parse(sc.nextLine()));
                    System.out.println("Entrez date fin course (dd-MM-yyyy:HH:MM)");
                    nouvelCourse.setDateFin(formatter.parse(sc.nextLine()));
                    System.out.println("Entrez matricule chauffeur");
                    matriculeChauffeur = sc.nextLine();
                    System.out.println("Entrez matricule vehicule");
                    String matriculeVehicule = sc.nextLine();
                    ctrl.ajoutCourse(nouvelCourse, matriculeChauffeur, matriculeVehicule);
                } catch (ParseException ex) {
                    Logger.getLogger(Console.class.getName()).log(Level.INFO, "FORMAT DE DATE INCORRECTE!", ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Console.class.getName()).log(Level.INFO, ex.getMessage(), ex);
                }
                break;

            case 3:
                System.out.println("Entrez matricule");
                ctrl.supprimerCourse(readValueInt());
                break;
            case 4:
                afficheMenuFlotte();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Valeur erronee");
                break;
        }
        afficheMenuCourse();
    }

}
