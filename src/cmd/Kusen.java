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
public class Kusen extends Barang{
    private String bahan;
    
    public Kusen(int id,float lebar, float panjang,String bahan) {
        super(id,lebar, panjang);
        this.bahan=bahan;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }
    
    
}
