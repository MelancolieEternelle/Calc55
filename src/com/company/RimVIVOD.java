package com.company;

public class RimVIVOD
{
    String rimEd[] = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X"};
    String rimDes[] = {"0","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
    String ResultRim ()
        {
            String string = " ";
            if ((Example.c / 100) == 1)
                {
                    string = "C";
                }
            else{
                if ((Example.c / 10) >= 1)
                    {
                        string = (rimDes[Example.c / 10]);
                        if ((Example.c % 10) > 0) {string = string + (rimEd[Example.c % 10]);}
                    }
                else{
                    if ((Example.c % 10) > 0)
                        {
                            string = rimEd[Example.c % 10];
                        }
                    }
                }
            return string;

        }
}
