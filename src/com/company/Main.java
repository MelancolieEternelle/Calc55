package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean wrongInput = false;
        int a = 0, b = 0;
        Example.c = 0;
        String[] strings = new String[3];
        Scanner in = new Scanner(System.in);
        System.out.println("2 числа (от 1 до 10 или от I до X)) и одну операцию между ними(+, -, *, /) (через пробел) ");
        String strPrimer = in.nextLine();

        strPrimer = strPrimer.trim();
        String[] masStr = strPrimer.split(" ");
        int i = 0;
        for (String element : masStr) {
          //  System.out.print("i=" + i + " ");
            if (i < 3) {
                strings[i] = element;
            } else {
                wrongInput = true;
            }
            i++;
            }
        if (i < 3){
            System.out.println("Слишком мало данных");
            System.exit(0);
        }
        in.close();
        if (wrongInput == true) {
            System.out.println();
            System.out.println(String.format("Введено " + (i - 3) + " лишних объектов(знаки или числа)"));
            System.exit(0);
        }

        int flagChislo1 = 0;
        int flagChislo2 = 0;

        try {
            a = Integer.parseInt(strings[0]);
           // System.out.println("первое число арабское");
            flagChislo1 = 1;
            if (a>10){
                System.out.println("Введенные числа должны быть меньше 10");
                System.exit(0);
            }

        } catch (NumberFormatException e) {
           // System.err.println("первое число не арабское");

            RimVvod rimVvod = new RimVvod();
            if (rimVvod.test(strings[0]) == true) {
                flagChislo1 = 2;
                a = Example.c;
               // System.out.println("потому, что римское");
            } else {
                if (flagChislo1 == 0) {
                    System.out.println("первое, вовсе не число");
                    System.exit(0);
                }
            }
        }

        try {
            b = Integer.parseInt(strings[2]);
           // System.out.println("второе число арабское");
            flagChislo2 = 1;
            if (b>10){
                System.out.println("Введенные числа должны быть меньше 10");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
           // System.err.println("второе число не арабское");

            RimVvod rimVvod = new RimVvod();
            if (rimVvod.test(strings[2]) == true) {
                flagChislo2 = 2;
                b = Example.c;
               // System.out.println("потому, что римское");
            } else {
                if (flagChislo2 == 0) {
                    System.out.println("второе, вовсе не число");
                    System.exit(0);
                }
            }
        }

        if ((flagChislo2 == 1) && (flagChislo1 == 1)) {
           // System.out.println("Действие араб");
            DeistvieArab2 deistvieArab2 = new DeistvieArab2();
            Example.c = deistvieArab2.deistvie(strings[1],a ,b);
            System.out.println(Example.c);
        } else {
            if ((flagChislo2 == 2) && (flagChislo1 == 2)) {
                //          System.out.println("Действие рим");
                DeistvieArab2 deistvieArab2 = new DeistvieArab2();
                //if (a > b) && strings[2]="="
                Example.c = deistvieArab2.deistvie(strings[1], a, b);
                if (Example.c < 1) {
                    System.out.println("Римляне не умеют в 0 и отрицательные числа, внимательнее");
                    System.exit(0);
                } else {
                    System.out.println(Example.c);
                    RimVIVOD rimVIVOD = new RimVIVOD();
                    System.out.println(rimVIVOD.ResultRim());
                }
            }

            else {
                System.out.println("Введенные числа должны оба быть либо арабскими, либо римскими");
                System.exit(0);
            }
        }
    }

}


class DeistvieArab2{
    int deistvie (String string, int a, int b) {
        switch(string){
        case "+":
            Example.c =  (a+b);
            break;
        case "-":
            Example.c =  (a-b);
            break;
        case "*":
            Example.c = (a*b);
            break;
        case "/":
            if (b!=0) {
                Example.c =  (a/b);
            } else{
                System.out.println("Деление на 0, внимательней");
                System.exit(0);
            }
            break;
        default:
            System.out.println("Не знаю такого оператора");
            System.exit(0);
        }
    return Example.c;
    }
}