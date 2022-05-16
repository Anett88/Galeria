package modell;

import java.io.Serializable;
import java.text.Collator;
import java.time.LocalDate;
import java.util.Comparator;

class KeszitoComparator implements Comparator<KiallitasiTargy>{
    @Override
    public int compare(KiallitasiTargy o1, KiallitasiTargy o2) {
        Collator coll = Collator.getInstance();
        return coll.compare(o1.getKeszito(), o2.getKeszito());
        
        //return o1.getKeszito().compareTo(o2.getKeszito());
    } 
}

class CimComparator implements Comparator<KiallitasiTargy>{
    @Override
    public int compare(KiallitasiTargy o1, KiallitasiTargy o2) {
        Collator coll = Collator.getInstance();
        return coll.compare(o1.getCim(), o2.getCim());
        
        //return o1.getKeszito().compareTo(o2.getKeszito());
    } 
}

public abstract class KiallitasiTargy implements Serializable{
    private LocalDate letrehozas;
    private String keszito, cim;

    public KiallitasiTargy(String keszito, String cim) throws HibasDatumException {
        this(LocalDate.now(), keszito, cim);
    }

    public KiallitasiTargy(LocalDate letrehozas, String keszito, String cim) throws HibasDatumException {
        if(letrehozas.isAfter(LocalDate.now())){
            throw new HibasDatumException("Nem létező dátum");
        }
        this.letrehozas = letrehozas;
        
        this.keszito = keszito;
        this.cim = cim;
    }

    public LocalDate getLetrehozas() {
        return letrehozas;
    }

    public String getKeszito() {
        return keszito;
    }

    public String getCim() {
        return cim;
    }
    
    public static CimComparator cimRendezo(){
        return new CimComparator();
    }
    
    public static KeszitoComparator keszitoRendezo(){
        return new KeszitoComparator();
    }

    @Override
    public String toString() {
        return "KiallitasiTargy{" + "letrehozas=" + letrehozas + ", keszito=" + keszito + ", cim=" + cim + '}';
    }
    
    
}
