package ENUM;

import java.util.Random;

public enum Cities {
    KiEV("KV"),
    BAKU("BK"),
    ISTANBUL("IST"),
    ISLAMABAD("ISAB"),
    PARIS("PRS"),
    ROMA("ROM"),
    NEWYORK("NYK"),
    LONDON("LND"),
    ODESSA("ODE"),
    BRIDGETOWN("BRD"),
    SOFIA("SOF"),
    HAVANA("HAV"),
    DUBLIN("DBLN"),
    MONACO("MNC"),
    SEOUL("SEO");
    public final String lbl;
    Cities(String lbl){
        this.lbl=lbl;
    }
    public String getLabel() {
        return lbl;
    }
    public static Cities randomCity(){
        Cities all[]=values();
        Random a=new Random();
        return all[a.nextInt(all.length)];
    }
}
