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
import java.util.Date;
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
            case 4:  
                ctrl.getChiffreAffaireTotal();
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
                Chauffeur chauf1 = new Chauffeur();
                System.out.println("Entrez matricule chauffeur");
                chauf1.setMatricule(sc.nextLine());
                System.out.println("Entrez nom chauffeur");
                chauf1.setNom(sc.nextLine());
                System.out.println("Entrez prenom chauffeur");
                chauf1.setPrenom(sc.nextLine());
                ctrl.ajoutChauffeur(chauf1);
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
                ctrl.afficherVehicules();
                break;
            case 2:
                Vehicule v1 = new Vehicule();
                System.out.println("Entrez matricule vehicule");
                v1.setMatricule(readValueInt());
                System.out.println("Entrez designation vehicule");
                v1.setDesignation(sc.nextLine());
                System.out.println("Entrez prix/minute pour vehicule");
                v1.setPrixMinute(readValueInt());
                ctrl.ajoutVehicule(v1);
                break;
            case 3:
                System.out.println("Entrez matricule");
                ctrl.supprimerVehicule(readValueInt());
                break;
            case 4:
                selectMenuPrincipal();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Valeur erronee");
                break;
        }
    }

    private void selectMenuCourse() throws ParseException {
        switch (readValueInt()) {
            case 1:
                ctrl.afficherCourses();
                break;
            case 2:
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy:HH:MM");
                int distance ;
                Date dateD;
                Date dateF;
                
                System.out.println("Entrez distance course");
                distance = readValueInt();
                
                System.out.println("Entrez date debut course (dd-MM-yyyy:HH:MM)");
                dateD =formatter.parse(sc.nextLine());
                
                System.out.println("Entrez date fin course (dd-MM-yyyy:HH:MM)");
                dateF = formatter.parse(sc.nextLine());
                
                System.out.println("Entrez matricule chauffeur");
                String matriculeChauffeur = sc.nextLine();
                
                System.out.println("Entrez matricule vehicule");
                int matriculeVehicule = readValueInt();
                try {
                    Course c1 = new Course(distance, dateD, dateD);
                    ctrl.ajoutCourse(c1, matriculeChauffeur, matriculeVehicule);
                } catch (Exception e) {
                    System.out.println("ERREUR \"date de fin avant date début !!\"");
                }
                break;
            case 3:
                System.out.println("Entrez matricule");
                ctrl.supprimerVehicule(readValueInt());
                break;
            case 4:
                selectMenuPrincipal();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Valeur erronee");
                break;
        }
    }

}
