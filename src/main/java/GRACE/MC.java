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
        
        for (int i=0; i<table.getNbBlocs(); i++)
        {
            this.buffers.get(0).fillBloc(blocs.get(i));
            shuffle(table.getNom());
            vider();
        }
    }
    
    //répartit le bloc entre les buffers restants
    public void shuffle(String nomTable)
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
                store(nomTable,i,this.buffers.get(i).getTuple(j));
            }
        }
    }
    
    public void store(String nomTable, int numBuffer, Tuple tupleBuffer)
    {
        if (nomTable == "R")
        {
            this.disque.getTableR(numBuffer-1).ecrireTuple(tupleBuffer);
        }
        else
        {
            this.disque.getTableS(numBuffer-1).ecrireTuple(tupleBuffer);
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
    
    public void Grace(int col1, int col2){
        int i =0;
        while(i<3){
            if(this.buffers.get(3).tuples.size()< this.buffers.get(3).taille-1){
                if(this.disque.getTableR(i).getBlocs().size() + this.disque.getTableS(i).getBlocs().size() < 4){
                    // On récupère les tuples de R0 dans le buffer 0
                    this.buffers.get(0).fill(this.disque.getTableR(i).getBlocs().get(0).getTuple());
                    // On récupère les tuples de S0 dans le buffer 1
                    this.buffers.get(1).fill(this.disque.getTableS(i).getBlocs().get(0).getTuple());
                    // Pour chaque tuple du buffer 0
                    for(Tuple tR : this.buffers.get(0).getTuples()){
                        // Pour chaque tuple du buffer 1
                        for(Tuple tS : this.buffers.get(1).getTuples()){
                            /*Si la valeur de la colonne désignée pour Ri est égal à la valeur
                            de la colonne de Si alors*/
                            if (tR.getAttributsList().get(col1).equals(tS.getAttributsList().get(col2))){
                                Tuple tupleConcat = new Tuple();
                                //On concatène les deux tuples
                                tupleConcat.concatAttributs(tR,tS);
                                //On insère le tuple concatèné dans le buffer 3
                                this.buffers.get(3).fillTuple(tupleConcat);
                                System.out.println(this.buffers.get(3));
                            }
                        }
                    }
                }else{
                    this.Cartesien(i,col1,col2);
                }
            i++;
            }else{//Si le buffer 3 contient déjà plein
                //Onn insère chaque tuple du buffer 3 dans la taple Res
                for(Tuple tB : this.buffers.get(3).getTuples()){
                    this.disque.getTableRes().ecrireTuple(tB);
                }
                //On vide le buffer
                this.buffers.get(3).vider();
            }
        }
        /*A la fin de l'algorithme on récupère les tuples restés dans le buffer
        si celui_ci n'est pas vide*/
        if(!this.buffers.get(3).tuples.isEmpty()){
            for(Tuple tB : this.buffers.get(3).getTuples()){
                this.disque.getTableRes().ecrireTuple(tB);
            }
        }
        this.buffers.get(3).vider();
    }
    
    public void Cartesien(int i, int col1, int col2){
        //on vérifie qui prend le plus de blocs entre Ri et Si
        //convention : si Ri et Si prennent chacun + d'un bloc, on reserve Buff0 et Buff1 pour Ri et le dernier pour Si
        
        /*DECLARATION VARIABLES DE TRAVAIL*/
        int nbBlocsRi = this.disque.getTableR(i).getNbBlocs(); //nombre de blocs de Ri
        int nbBlocsSi = this.disque.getTableS(i).getNbBlocs(); //nombre de blocs de Si
        ArrayList<Bloc> blocsRi = this.disque.getTableR(i).getBlocs(); //blocs de Ri
        ArrayList<Bloc> blocsSi = this.disque.getTableS(i).getBlocs(); //blocs de Si
        Bloc blocRi; //bloc temporaire qui va contenir le bloc de R avec lequel on travaille
        Bloc blocSi; //bloc temporaire qui va contenir le bloc de S avec lequel on travaille
        /**********************************/
        
        //si Ri prend plus d'un buffer
        if (nbBlocsRi >= 1)
        {
            for (int j=0; j<nbBlocsRi; j+=2)
            {
                blocRi = blocsRi.get(j);
                //this.buffers
                for (int k=0; k<nbBlocsSi; k++)
                {
                    blocSi = blocsSi.get(k);
                    jointure(blocRi,blocSi,col1,col2);
                }
            }
            //on charge
            this.buffers.get(2).fillBloc(this.disque.getTableS(i).getBlocs().get(0));
        }
    }
    
    public void jointure(Bloc blocRi, Bloc Si, int col1, int col2)
    {
        
    }
}