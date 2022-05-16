package modell;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Galeria implements Iterable<KiallitasiTargy>, Serializable{
    private ArrayList<KiallitasiTargy> targyak;
    
    public Galeria(){
        targyak = new ArrayList<>();
        
        try {
            //készítő és cím
            Festmeny f1 = new Festmeny("keszítő3", "cím2");
            
            //készítő és cím MAI dátum
            Festmeny f2 = new Festmeny(LocalDate.now(), "készítő1", "cím3");
            
            
            //készítő és cím HIBÁS dátum
            //Festmeny f3 = new Festmeny(LocalDate.parse("2023-01-01"), "készítő2", "cím1");
            
            //készítő és cím Fájl
            Festmeny f4 = new Festmeny(new File("kep.txt"), "készítő5", "cím4");
            
            //készítő és cím + Fájl és MAI dátum
            Festmeny f5 = new Festmeny(new File("kep.txt"), LocalDate.now(), "készítő4", "cím5");
            
            //készítő és cím + Fájl és LÉTEZŐ dátum
            Festmeny f6 = new Festmeny(new File("kep.txt"), LocalDate.of(2021, 05, 13), "készítő7", "cím7");
            
            targyak.add(f1);
            targyak.add(f2);
            targyak.add(f4);
            targyak.add(f5);
            targyak.add(f6);
        }
        catch (HibasDatumException ex) {
            Logger.getLogger(Galeria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void felvesz(KiallitasiTargy targy){
        targyak.add(targy);
    }

   
    public List<KiallitasiTargy> rendezCimSzerint(){
        Collections.sort(targyak, KiallitasiTargy.cimRendezo());
        return Collections.unmodifiableList(targyak);
    }
    
    public List<KiallitasiTargy> rendezKeszitoSzerint(){
        Collections.sort(targyak, KiallitasiTargy.keszitoRendezo());
        return Collections.unmodifiableList(targyak);
    }

    @Override
    public Iterator<KiallitasiTargy> iterator() {
        return Collections.unmodifiableList(targyak).iterator();
    }
}
