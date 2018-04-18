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
import com.opencsv.*;
import java.util.*;
import java.io.*;

public class CSV {
    public void writeKaca(Map<Kaca,Integer> lk, String file) throws Exception{
        String csv=file;
        CSVWriter writer = new CSVWriter(new FileWriter(csv,true));
        
        //String[] header="ID_Bahan#Panjang#Lebar#Ketebalan#Jumlah".split("#");
        //writer.writeNext(header);
        for(Map.Entry<Kaca,Integer> list:lk.entrySet()){
            String id=Integer.toString(list.getKey().getId());
            String p=Float.toString(list.getKey().getPanjang());
            String l=Float.toString(list.getKey().getLebar());
            String k=Float.toString(list.getKey().getKepadatan());
            String j=Integer.toString(list.getValue());
            String[] kaca={id,p,l,k,j};
            
            writer.writeNext(kaca);
        }
        writer.close();
    }
    
    public void writeKusen(Map<Kusen,Integer> lk, String file) throws Exception{
        String csv=file;
        CSVWriter writer = new CSVWriter(new FileWriter(csv,true));
        
        //String[] header="ID_Bahan#Panjang#Lebar#Bahan#Jumlah".split("#");
        //writer.writeNext(header);
        for(Map.Entry<Kusen,Integer> list:lk.entrySet()){
            String id=Integer.toString(list.getKey().getId());
            String p=Float.toString(list.getKey().getPanjang());
            String l=Float.toString(list.getKey().getLebar());
            String k=list.getKey().getBahan();
            String j=Integer.toString(list.getValue());
            String[] kaca={id,p,l,k,j};
            
            writer.writeNext(kaca);
        }
        writer.close();
    }
}
