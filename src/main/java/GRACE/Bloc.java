/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRACE;

import java.util.ArrayList;

/**
 *
 * @author re770061
 */
public class Bloc {
    private int taille;
    private boolean plein;
    ArrayList<Tuple> tuples;

    public Bloc()
    {
        this.tuples = new ArrayList<Tuple>();
        taille = 3;
        plein = false;
    }
    
    public boolean getPlein()
    {
        return this.plein;
    }

    public void ecrireTuple(Tuple tuple)
    {
      if(!plein){
        tuples.add(tuple);
        
        if (tuples.size() >= taille)
        {
            plein = true;
        }
      }
    }
    
    public ArrayList<Tuple> getTuple()
    {
        return this.tuples;
    }
    
    public String toString()
    {
        String chaine = "";
        
        for (Tuple tuple : tuples)
        {
            chaine += tuple.toString();
        }
        chaine += "\n";
        return chaine;
    }
}
