/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport;

import arctransport.controller.Controller;
import arctransport.ihm.Console;
import arctransport.metier.GestionFlote;

/**
 *
 * @author zakariae.chentouf
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestionFlote gf = new GestionFlote();
        Controller ctrl = new Controller(gf);
        Console cs = new Console(ctrl);
        cs.start();
    }
    
}
