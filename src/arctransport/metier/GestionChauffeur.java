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
public class GestionChauffeur {
    
    private final List<Chauffeur> chauffeurs;

    public GestionChauffeur() {
        this.chauffeurs =  new ArrayList<>();
    }
    
    protected void ajouteChauffeur(Chauffeur c) {
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
    
     public List<Chauffeur> getChauffeurs() {
        return chauffeurs;
    }
}
