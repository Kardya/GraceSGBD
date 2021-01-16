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
public class Table {
    private String nom;
    private ArrayList<Bloc> blocs;
    private int nbBlocs;
    
    public Table(String nom)
    {
        this.nom = nom;
        blocs = new ArrayList<Bloc>();
        this.nbBlocs = 0;
    }
    
    public void ecrireTuple(Tuple tuple)
    {
        boolean affectation = false;
        for(Bloc bloc : blocs)
        {
            if (!bloc.getPlein() && !affectation)
            {
                bloc.ecrireTuple(tuple);
                affectation = true;
            }
        }
        
        if (!affectation)
        {
            Bloc bloc = new Bloc();
            bloc.ecrireTuple(tuple);
            this.blocs.add(bloc);
            this.nbBlocs++;
        }
    }
    
    public int getNbBlocs()
    {
        return this.nbBlocs;
    }
    
    public ArrayList<Bloc> getBlocs()
    {
        return this.blocs;
    }
    
    public String toString()
    {
        String chaine = "Nom de la table : " + this.nom + "\n";
        int i = 0;
        for (Bloc bloc : blocs)
        {
            chaine += "Bloc n°"+i+"\n";
            chaine += bloc.toString();
            i++;
        }
        return chaine;
    }
}
