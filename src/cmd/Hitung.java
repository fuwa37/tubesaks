package cmd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IRS37
 */
import java.util.*;

public class Hitung {
    static Scanner in=new Scanner(System.in);
    
    public static Map<Kaca, Integer> hitungKaca() {
        int i, j, k, l, m, id;
        float sum;
        float pa, le, kp;
        int banyak = 1;
        float luas;
        float luask = 0;
        float eff;
        int banyakKaca = 0;
        float effKaca = 0;

        Map<Kaca, Integer> listKaca = new HashMap();
        listKaca.clear();
        System.out.print("Masukkan panjang kaca paket :");
        pa = in.nextFloat();
        System.out.print("Masukkan lebar kaca paket :");
        le = in.nextFloat();
        System.out.print("Masukkan kepadatan kaca paket :");
        kp = in.nextFloat();

        Kaca kaca = new Kaca(1, pa, le, kp);
        luas = kaca.area();
        System.out.print("Masukkan berapa banyak jenis kaca :");
        int n = in.nextInt();
        for (i = 0; i < n; i++) {
            System.out.print("ID :");
            id=in.nextInt();
            System.out.print("Panjang :");
            pa = in.nextFloat();
            System.out.print("Lebar :");
            le = in.nextFloat();
            kp = kaca.getKepadatan();
            System.out.print("Banyaknya :");
            int b = in.nextInt();
            Kaca kacat = new Kaca(id, pa, le, kp);
            listKaca.put(kacat, b);
        }
        for (Map.Entry<Kaca, Integer> set : listKaca.entrySet()) {
            k = 0;
            while (k < set.getValue()) {
                if (kaca.getLebar() >= set.getKey().getLebar()) {
                    kaca.setLebar(kaca.getLebar() - set.getKey().getLebar());
                    k++;
                } else {
                    kaca.setLebar(5);
                    kaca.setPanjang(kaca.getPanjang() - set.getKey().getPanjang());
                }
                if (kaca.getPanjang() < set.getKey().getPanjang()) {
                    set.getKey().swap();
                    if (kaca.getPanjang() < set.getKey().getPanjang()) {
                        kaca.setPanjang(8);
                        banyak++;
                    }
                }
            }
            luask += set.getKey().area() * set.getValue();
        }
        //System.out.println(luask);
        //System.out.println(luas * banyak);
        eff = luask / (luas * banyak);
        effKaca = eff;
        banyakKaca = banyak;
        System.out.println("\n\nEfektifitas :"+effKaca);
        System.out.println("Banyak kaca :"+banyakKaca);
        return listKaca;
    }

    public static Map<Kusen, Integer> hitungKusen() {
        int i, j, k, l, m, id;
        float sum;
        float pa, le;
        int banyak = 1;
        String ba;
        float luas;
        float luask = 0;
        float eff;
        int banyakKusen = 0;
        
        float effKusen = 0;
        
        Map<Kusen, Integer> listKusen = new HashMap();
        listKusen.clear();
        System.out.print("Masukkan panjang kusen paket :");
        pa = in.nextFloat();
        System.out.print("Masukkan lebar kusen paket :");
        le = in.nextFloat();
        System.out.print("Masukkan bahan kusen paket :");
        ba = in.next();

        Kusen kus = new Kusen(1, pa, le, ba);
        luas = kus.area();
        System.out.print("Masukkan berapa banyak jenis kusen :");
        int n = in.nextInt();
        id = 0;
        for (i = 0; i < n; i++) {
            System.out.print("ID :");
            id=in.nextInt();
            System.out.print("Panjang :");
            pa = in.nextFloat();
            System.out.print("Lebar :");
            le = in.nextFloat();
            ba = kus.getBahan();
            System.out.print("Banyaknya :");
            int b = in.nextInt();
            Kusen kuse = new Kusen(id, pa, le, ba);
            listKusen.put(kuse, b);
        }

        for (Map.Entry<Kusen, Integer> set : listKusen.entrySet()) {
            k = 0;
            while (k < set.getValue()) {
                if (kus.getLebar() >= set.getKey().getLebar()) {
                    kus.setLebar(kus.getLebar() - set.getKey().getLebar());
                    k++;
                } else {
                    kus.setLebar(5);
                    kus.setPanjang(kus.getPanjang() - set.getKey().getPanjang());
                }
                if (kus.getPanjang() < set.getKey().getPanjang()) {
                    set.getKey().swap();
                    if (kus.getPanjang() < set.getKey().getPanjang()) {
                        kus.setPanjang(8);
                        banyak++;
                    }
                }
            }
            luask += set.getKey().area() * set.getValue();
        }
        eff = luask / (luas * banyak);
        effKusen = eff;
        banyakKusen = banyak;
        System.out.println("\n\nEfektifitas :"+effKusen);
        System.out.println("Banyak kaca :"+banyakKusen);
        return listKusen;
    }
}
