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
public class GestionVehicule {

    private final List<Vehicule> vehicules;

    public GestionVehicule() {
        this.vehicules = new ArrayList<>();
    }
     
     public void ajouteVehicule(Vehicule v) {
        vehicules.add(v);
    }

    public Vehicule findVehiculeByMatricule(int matricule) {
        Vehicule vRecherche = null;
        for (Vehicule v : vehicules) {
            if (v.compareMatricule(matricule)) {
                vRecherche = v;
                break;
            }
        }
        return vRecherche;
    }

    public void deleteVehicule(Vehicule v) {
        vehicules.remove(v);
    }

    public void deleteVehiculeByMatricule(int matricule) {
        deleteVehicule(findVehiculeByMatricule(matricule));
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }
    
}
