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
public class Buffer {
    private int id;
    int taille = 3;
    ArrayList<Tuple> tuples;
    private char lettre;
    
    public Buffer(int id)
    {
        this.id = id;
        this.tuples = new ArrayList<Tuple>();
    }
    
    public void fill(ArrayList<Tuple> tuples)
    {
        this.tuples = tuples;
    }
    
    public void fillTuple(Tuple tuple){
        this.tuples.add(tuple);
    }
   
    public void fillBloc(Bloc bloc)
    {
        for (Tuple tuple : bloc.getTuple())
        {
            this.tuples.add(tuple);
        }
    }
    
    public int getNbTuples()
    {
        return this.tuples.size();
    }
    
    public ArrayList<Tuple> getTuples()
    {
        return this.tuples;
    }
    
    public Tuple getTuple(int i)
    {
        return this.tuples.get(i);
    }
    
    public void vider()
    {
        this.tuples.clear();
    }
    
    public void setLettre(char lettre)
    {
        this.lettre = lettre;
    }
    
    public char getLettre()
    {
        return this.lettre;
    }
    
    public String toString()
    {
        String chaine = "Buffer n°" + this.id + "\n";
        for (Tuple tuple : this.tuples)
        {
            chaine += tuple.toString() + "\n";
        }
        return chaine;
    }
}