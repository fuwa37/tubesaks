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
public class Kaca extends Barang{
    private float kepadatan;
    
    public Kaca(int id, float lebar, float panjang,float kepadatan) {
        super(id,lebar, panjang);
        this.kepadatan=kepadatan;
    }

    public float getKepadatan() {
        return kepadatan;
    }

    public void setKepadatan(float kepadatan) {
        this.kepadatan = kepadatan;
    }

    public Kaca() {
        super();
    }
    
    
    
    
}
