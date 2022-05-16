package modell;

import java.io.File;
import java.time.LocalDate;

public class Festmeny extends KiallitasiTargy{
    
    private File eleres;
    
    public Festmeny(String keszito, String cim) throws HibasDatumException {
        this(new File("nincs"), keszito, cim);
    }

    public Festmeny(File eleres, String keszito, String cim) throws HibasDatumException {
        this(eleres, LocalDate.now(), keszito, cim);
    }

    public Festmeny(LocalDate letrehozas, String keszito, String cim) throws HibasDatumException {
        this(new File("nincs"), letrehozas, keszito, cim);
    }
    
    public Festmeny(File eleres, LocalDate letrehozas, String keszito, String cim) throws HibasDatumException {
        super(letrehozas, keszito, cim);
        this.eleres = eleres;
    }
    
    public void megjelenites(){
        if(eleres.exists()){
            System.out.println("megjelenítés folyamatban...");
        }else{
            System.out.println("nem lehet megjeleníteni");
        }
    }

    @Override
    public String toString() {
        String os = super.toString();
        return os + "Festmeny{" + "eleres=" + eleres + '}';
    }
    
    
}
