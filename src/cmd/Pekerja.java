package cmd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Pekerja {
    private static final int workpower=5;//potong kaca/kusen per hari

    public static int getWP() {
        return workpower;
    }

    public static int getWaktu(int jk,int jp){
        return (jk / jp)+1;
    }
    
    public static int getPekerja(int jk,int jw){
        return (jk / jw)+1;
    }
}
