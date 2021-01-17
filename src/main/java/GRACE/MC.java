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
        int tailleRb = 0;//On récupère le nombre de bloc de la sous-table Ri
        int tailleSb = 0;//On récupère le nombre de bloc de la sous-table Si
        int iterS = 0;//Pour connaitre le nombre d'itération pour les buffers de Si
        while(i<3){
            tailleRb = this.disque.getTableR(i).getNbBlocs();
            tailleSb = this.disque.getTableS(i).getNbBlocs();
            if(this.buffers.get(3).tuples.size()< this.buffers.get(3).taille-1){
                
                if(tailleRb + tailleSb < 4){
                    if(tailleRb == 2){
                        this.buffers.get(0).fill(this.disque.getTableR(i).getBlocs().get(0).getTuple());
                        this.buffers.get(1).fill(this.disque.getTableR(i).getBlocs().get(1).getTuple());
                        this.buffers.get(2).fill(this.disque.getTableS(i).getBlocs().get(0).getTuple());
                    }else if(tailleSb == 2){
                        this.buffers.get(0).fill(this.disque.getTableR(i).getBlocs().get(0).getTuple());
                        this.buffers.get(1).fill(this.disque.getTableS(i).getBlocs().get(0).getTuple());
                        this.buffers.get(2).fill(this.disque.getTableS(i).getBlocs().get(1).getTuple());
                    }else{
                        // On récupère les tuples de R0 dans le buffer 0
                        this.buffers.get(0).fill(this.disque.getTableR(i).getBlocs().get(0).getTuple());
                        // On récupère les tuples de S0 dans le buffer 1
                        this.buffers.get(1).fill(this.disque.getTableS(i).getBlocs().get(0).getTuple());
                    }
                    if(tailleSb == 2 || (tailleSb ==1 && tailleRb == 1)){
                        iterS = 1;
                    }else if(tailleRb == 2){
                        iterS = 2;
                    }
                    for(int iR = 0; iR < tailleRb;iR++){//On regarde nbBlocs pour connaitre le nb d'itération
                        // Pour chaque tuple du buffer iR
                        for(Tuple tR : this.buffers.get(iR).getTuples()){
                            // Pour chaque tuple du buffer 1
                            for(int iS = 0; iS < tailleSb;iS++){//On regarde nbBlocs pour connaitre le nb d'itération
                                //System.out.println("val iterS : "+iterS);
                                for(Tuple tS : this.buffers.get(iS+iterS).getTuples()){
                                    /*Si la valeur de la colonne désignée pour Ri est égal à la valeur
                                    de la colonne de Si alors*/
                                    if (tR.getAttributsList().get(col1).equals(tS.getAttributsList().get(col2))){
                                        Tuple tupleConcat = new Tuple();
                                        //On concatène les deux tuples
                                        tupleConcat.concatAttributs(tR,tS);
                                        //On insère le tuple concatèné dans le buffer 3
                                        this.buffers.get(3).fillTuple(tupleConcat);
                                        //System.out.println(this.buffers.get(3));
                                    }
                                }
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
        int decalageRi = 0; //indice permettant de savoir le bloc de Ri à stocker dans un buffer
        int decalageSi = 0; //indice permettant de savoir le bloc de Si à stocker dans un buffer
        int sousDecalageRi = 0;
        boolean end = false; //booléen indiquant la fin de jointure entre Ri et Si
        /**********************************/
        
        while(!end)
        {
            //chargement des buffers en fonction de bloc de Ri et Si restants
            
            /**************chargement du/des bloc(s) de Ri**************/
            if ((nbBlocsRi - decalageRi) > 1)
            {
                this.buffers.get(0).fillBloc(blocsRi.get(decalageRi));
                this.buffers.get(0).setLettre('R');
                this.buffers.get(1).fillBloc(blocsRi.get(decalageRi+1));
                this.buffers.get(1).setLettre('R');
                sousDecalageRi = 2;
            }
            else if ((nbBlocsRi - decalageRi) == 1)
            {
                this.buffers.get(0).fillBloc(blocsRi.get(decalageRi));
                this.buffers.get(0).setLettre('R');
                sousDecalageRi = 1;
            }
            /***********************************************************/
            
            /**************chargement du/des bloc(s) de Si**************/
            if ((nbBlocsSi - decalageSi) > 1)
            {
                //on vérifie d'abord si le buffer1 n'est pas occupé
                if (this.buffers.get(1).getNbTuples() == 0)
                {
                    this.buffers.get(1).fillBloc(blocsSi.get(decalageSi));
                    this.buffers.get(1).setLettre('S');
                    this.buffers.get(2).fillBloc(blocsSi.get(decalageSi+1));
                    this.buffers.get(2).setLettre('S');
                    decalageSi += 2;
                }
                else
                {
                    this.buffers.get(2).fillBloc(blocsSi.get(decalageSi));
                    this.buffers.get(2).setLettre('S');
                    decalageSi++;
                }
            }
            else if ((nbBlocsSi - decalageSi) == 1)
            {
                if (this.buffers.get(1).getNbTuples() == 0)
                {
                    this.buffers.get(1).fillBloc(blocsSi.get(decalageSi));
                    this.buffers.get(1).setLettre('S');
                    decalageSi++;
                }
                else
                {
                    this.buffers.get(2).fillBloc(blocsSi.get(decalageSi));
                    this.buffers.get(2).setLettre('S');
                    decalageSi++;
                }
            }
            /***********************************************************/
            jointure(col1,col2);
            
            //on met à jour les décalages en fonction du decalage de Si
            if (decalageSi >= nbBlocsSi)
            {
                decalageRi += sousDecalageRi;
                decalageSi = 0;
            }
            if (decalageRi >= nbBlocsRi)
            {
                end = true;
            }  
        }
    }
    
    public void jointure(int col1, int col2)
    {
        int countR = 0;
        int countS = 0;
        ArrayList<Tuple> blocR;
        ArrayList<Tuple> blocS;
        
        for(Buffer buffer : this.buffers)
        {
            if (buffer.getLettre() == 'R')
                countR++;
            else if (buffer.getLettre() == 'S')
                countS++;
        }
        
        //pour chaque buffer contenant une partie de Ri
        for (int i=0; i<countR; i++)
        {
            blocR = this.buffers.get(i).getTuples();
            //pour chaque buffer contenant une partie de Si
            for (int j=0; j<countS; j++)
            {
                blocS = this.buffers.get(countR + j).getTuples();
                
                //on passe à la jointure entre les deux blocs
                for (Tuple tuple1 : blocR)
                {
                    for (Tuple tuple2 : blocS)
                    {
                        if (tuple1.getAttributsList().get(col1) == tuple2.getAttributsList().get(col2))
                        {
                            Tuple tuple3 = new Tuple();
                            tuple3.concatAttributs(tuple1, tuple2);
                            this.buffers.get(3).fillTuple(tuple3);
                        }
                    }
                }
            }
        }
        
        //on insère le contenu du dernier buffer dans la table résultat
        for (Tuple tuple : this.buffers.get(3).getTuples())
        {
            this.disque.getTableRes().ecrireTuple(tuple);
        }
        vider();
    }
}