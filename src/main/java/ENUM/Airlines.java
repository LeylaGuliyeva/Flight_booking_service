package ENUM;

import java.util.Random;

public enum Airlines {
    PEGASUS("PG"),
    TURKISH_AIRLINES("TA"),
    UKRAINE_INTERNATIONAL_AIRLINES("UIA");
    public final String label;
    Airlines(String label){
        this.label=label;
    }
    public String getLabel() {
        return label;
    }
    public static Airlines randomAirline(){
        Airlines all[]=values();
        Random a=new Random();
        return all[a.nextInt(all.length)];
    }
}
