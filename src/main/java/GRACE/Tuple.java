/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRACE;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author re770061
 */
public class Tuple {
    private int longueur;
    private String attributCle;
    private List<String> attributs;
    
    public Tuple(String attributCle,List<String> attributs)
    {
        this.attributCle = attributCle;
        this.attributs = new ArrayList<String>(attributs);
    }
    
    public Tuple(){}
    
    public List<String> getAttributsList(){
        return this.attributs;
    }
    
    public String getAttributCle(){
        return this.attributCle;
    }
    
    public void concatAttributs(Tuple tuple1, Tuple tuple2) 
    {
        this.attributCle = tuple1.getAttributCle();
        this.attributs.addAll(tuple1.getAttributsList());
        this.attributs.add(tuple2.getAttributCle());
        this.attributs.addAll(tuple2.getAttributsList());
    }
    
    public void videTuple(){
        this.attributs.clear();
        this.attributCle = null;
    }
    public String toString()
    {
        String chaine = this.attributCle + " ";
        
        for (String attribut : attributs)
        {
            chaine += attribut + " ";
        }
        chaine += "\n";
        return chaine;
    }
}
