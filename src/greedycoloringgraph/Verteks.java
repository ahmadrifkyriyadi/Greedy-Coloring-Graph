/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedycoloringgraph;

/**
 *
 * @author AtlantisSeeker
 */
public class Verteks {
    String nama;
    String warna;
    
    public Verteks(){
        
    }
    
    public Verteks(String nama, String warna){
        this.nama=nama;
        this.warna=warna;
    }
    
    public String getWarna(){
        return warna;
    }
    
    public String getVerteks(){
        return nama;
    }
    
    public void setWarna(String nWarna){
        warna = nWarna;
    }
}
