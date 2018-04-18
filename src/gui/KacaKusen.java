package gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IRS37
 */
import cmd.Kusen;
import cmd.Kaca;
import java.util.*;

public class KacaKusen {

    static int banyakKaca = 1;
    static int banyakKusen = 1;
    static float luasKaca = 0;
    static float luasKusen = 0;
    static Map<Kaca, Integer> listKaca = new HashMap();
    static Map<Kusen, Integer> listKusen = new HashMap();

    public static class DataKaca {

        static float panjang, lebar, kepadatan, area;
    }

    public static class DataKusen {

        static float panjang, lebar, area;
        static String bahan;
    }

    public static float efektifKaca() {
        float effKaca = luasKaca / (DataKaca.area * banyakKaca);
        return effKaca;
    }

    public static float efektifKusen() {
        float effKusen = luasKusen / (DataKusen.area * banyakKusen);
        return effKusen;
    }

    public static void inputKaca(int id, float pa, float le, int banyak) {
        Kaca kaca = new Kaca(id, pa, le, DataKaca.kepadatan);
        listKaca.put(kaca, banyak);
    }

    public static void inputKusen(int id, float pa, float le, int banyak) {
        Kusen kusen = new Kusen(id, pa, le, DataKusen.bahan);
        listKusen.put(kusen, banyak);
    }

    public static void infoKaca(float panjang, float lebar, float kepadatan) {
        DataKaca.panjang = panjang;
        DataKaca.lebar = lebar;
        DataKaca.kepadatan = kepadatan;
        DataKaca.area = panjang * lebar;
    }

    public static void infoKusen(float panjang, float lebar, String bahan) {
        DataKusen.panjang = panjang;
        DataKusen.lebar = lebar;
        DataKusen.bahan = bahan;
        DataKusen.area = panjang * lebar;
    }

    public static int banyakKaca() {
        int k;
        float pa = DataKaca.panjang;
        float le = DataKaca.lebar;
        banyakKaca=1;
        luasKaca=0;

        for (Map.Entry<Kaca, Integer> set : listKaca.entrySet()) {
            luasKaca += set.getKey().area()*set.getValue();
            k = 0;
            while (k < set.getValue()) {
                if (DataKaca.lebar >= set.getKey().getLebar()) {
                    DataKaca.lebar = DataKaca.lebar - set.getKey().getLebar();
                    k++;
                } else {
                    DataKaca.lebar = le;
                    DataKaca.panjang = DataKaca.panjang - set.getKey().getPanjang();
                }
                if (DataKaca.panjang < set.getKey().getPanjang()) {
                    set.getKey().swap();
                    if (DataKaca.panjang < set.getKey().getPanjang()) {
                        DataKaca.panjang = pa;
                        banyakKaca++;
                    }
                }
            }
        }
        return banyakKaca;
    }

    public static int banyakKusen() {
        int k;
        float pa = DataKusen.panjang;
        float le = DataKusen.lebar;
        banyakKusen=1;
        luasKusen=0;

        for (Map.Entry<Kusen, Integer> set : listKusen.entrySet()) {
            luasKusen += set.getKey().area()*set.getValue();;
            k = 0;
            while (k < set.getValue()) {
                if (DataKusen.lebar >= set.getKey().getLebar()) {
                    DataKusen.lebar = DataKusen.lebar - set.getKey().getLebar();
                    k++;
                } else {
                    DataKusen.lebar = le;
                    DataKusen.panjang = DataKusen.panjang - set.getKey().getPanjang();
                }
                if (DataKusen.panjang < set.getKey().getPanjang()) {
                    set.getKey().swap();
                    if (DataKusen.panjang < set.getKey().getPanjang()) {
                        DataKusen.panjang = pa;
                        banyakKusen++;
                    }
                }
            }
        }
        return banyakKusen;
    }
}
