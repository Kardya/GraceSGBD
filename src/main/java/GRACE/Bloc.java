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
    private static int nbLectures;
    private static int nbEcritures;
    private int taille;
    ArrayList<Tuple> tuples;

    public Bloc()
    {
        this.tuples = new ArrayList<Tuple>();
    }

    public void lireTuple()
    {
        /*for(Tuple t : tuples){
           for(String a : t){
             System.out.Println("Faut mettre des choses ici mdr");
           }
        }*/
    }

    public void ecrireTuple(String attributCle,List<String> attributs)
    {
      if(tuples.size() < taille){
        tuples.add(new Tuple(attributCle,attributs));
      }
    }
}
