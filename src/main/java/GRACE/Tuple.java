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
}
