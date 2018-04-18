package cmd;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Barang implements Serializable{
    private int id;
    private float lebar;
    private float panjang;
    public Barang(int id, float lebar, float panjang) {
        this.id=id;
        this.lebar = lebar;
        this.panjang = panjang;
    }

    public Barang() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public float getLebar() {
        return lebar;
    }

    public void setLebar(float lebar) {
        this.lebar = lebar;
    }

    public float getPanjang() {
        return panjang;
    }

    public void setPanjang(float panjang) {
        this.panjang = panjang;
    }
    
    public float area(){
        return (float)panjang*(float)lebar;
    }
    
    public float keliling(){
        return (2*lebar+2*panjang);
    }
    
    public float getEff(int p, int l){
        return area()/(float)(p*l); 
    }
    
    public void swap(){
        float temp;
        temp=panjang;
        panjang=lebar;
        lebar=temp;
    }
}
