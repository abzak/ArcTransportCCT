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
public class GestionVehicule {
    
    
    private List<Vehicule> vehicules;
    
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

    public List<Vehicule> getVehicules() {
        return vehicules;
    }
    
}
