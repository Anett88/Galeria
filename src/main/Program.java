package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import modell.Festmeny;
import modell.Galeria;
import modell.KiallitasiTargy;

public class Program {

    public static void main(String[] args) {
        Galeria galeria = new Galeria();
        
        System.out.println("Cím szerinti:");
        for (KiallitasiTargy targy : galeria.rendezCimSzerint()) {
            System.out.println(targy);
        }
        
        System.out.println("Készítő szerinti:");
        for (KiallitasiTargy targy : galeria.rendezKeszitoSzerint()) {
            System.out.println(targy);
        }
        
        for (KiallitasiTargy targy : galeria) {
            if(targy instanceof Festmeny){
                ((Festmeny)targy).megjelenites();
            }
        
        }
        
        try {
            ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("galeria.bin"));
            objKi.writeObject(galeria);
            objKi.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        galeria = null;
        
        try {
            ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("galeria.bin"));
            galeria = (Galeria)objBe.readObject();
            
            objBe.close();
            
            System.out.println("Visszaállítás:");
            for (KiallitasiTargy targy : galeria) {
                System.out.println(targy);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
