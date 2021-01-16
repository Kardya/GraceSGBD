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
public class MC {
    private int taille;
    private ArrayList<Buffer> buffers;
    private Disque disque;
    
    public MC(Disque disque)
    {
        this.buffers = new ArrayList<Buffer>();
        this.taille = 4;
        this.disque = disque;
        init();
    }
    
    private void init()
    {
        for (int i=0; i<taille; i++)
        {
            this.buffers.add(new Buffer(i));
        }
    }
    
    public void fill(Table table)
    {
        ArrayList<Bloc> blocs = table.getBlocs();
        
        //for (int i=0; i<table.getNbBlocs(); i++)
        //{
            this.buffers.get(0).fillBloc(blocs.get(0));
            shuffle();
        //}
    }
    
    //répartit le bloc entre les buffers restants
    public void shuffle()
    {
        int nbTuples = this.buffers.get(0).getNbTuples();
        ArrayList<Tuple> tuples = this.buffers.get(0).getTuples();
        //on affecte chaque buffer (sans l'initial)
        for (int i=1; i<nbTuples+1; i++)
        {
            ArrayList<Tuple> partTuples = new ArrayList<Tuple>();
            partTuples.add(tuples.get(i-1));
            this.buffers.get(i).fill(partTuples);
        }
        
        //on stocke le contenu de chaque buffer dans la table correspondante
        for (int i=1; i<this.taille; i++)
        {
            //pour chaque tuple, on envoie les données
            for (int j=0; j<this.buffers.get(i).getNbTuples(); j++)
            {
                store('R',i,this.buffers.get(i).getTuple(j));
            }
        }
    }
    
    public void store(char lettreTable, int numBuffer, Tuple tupleBuffer)
    {
        if (lettreTable == 'R')
        {
            this.disque.getTableR(numBuffer-1).ecrireTuple(tupleBuffer);
        }
    }
    
    public void vider()
    {
        for(Buffer buffer : this.buffers)
        {
            buffer.vider();
        }
    }
    
    public String toString()
    {
        String chaine = "MC :\n";
        for (Buffer b : this.buffers)
        {
            chaine += b.toString();
        }
        return chaine;
    }
}