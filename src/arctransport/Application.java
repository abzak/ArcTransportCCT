/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arctransport;

import arctransport.controller.Controller;
import arctransport.ihm.Console;
import arctransport.metier.Chauffeur;
import arctransport.metier.Course;
import arctransport.metier.GestionFlote;
import arctransport.metier.Vehicule;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zakariae.chentouf
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        /*GestionFlote gf = new GestionFlote();
        Controller ctrl = new Controller(gf);
        Console cs = new Console(ctrl);
        cs.start();*/
        
        Chauffeur test = new Chauffeur("12","jean","bonneau");
        System.out.println(test.toString());
        
        Vehicule test2 = new Vehicule(121,"opel saphira",42);
        //System.out.println(test2.toString());
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM dd, yyyy HH:mm:ss");
	String dateInString = "07 07, 2013 12:10:56";
        String dateInString2 = "07 07, 2013 12:15:56";
        /*Course test3 = new Course(42, formatter.parse(dateInString), formatter.parse(dateInString2), test, test2);
        System.out.println(test3.toString());
        Course test4 = new Course(42, formatter.parse(dateInString), formatter.parse(dateInString2), test, test2);
        System.out.println(test4.toString());

        System.out.println(test3.toString());*/
        
        //test de init course invalide

    }
    
}
