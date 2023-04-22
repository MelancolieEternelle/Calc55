package com.company;

public class RimVvod {
    String rimEd[] = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X"};

    boolean test(String string) {
        boolean flagRim = false;
        for (int i=1; i<11; i++) {
            if (string.equals(rimEd[i])) {
                //System.out.println("Найдено римское число " + rimEd[i]);
                Example.c = i;
                flagRim = true;
            }
        }
            return flagRim;
    }

}
