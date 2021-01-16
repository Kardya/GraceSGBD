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
public class Disque {
    private ArrayList<Table> tables;
    private ArrayList<Table> tablesR;
    private ArrayList<Table> tablesS;
    private Table tableRes;
    
    public Disque(ArrayList<Table> tables, ArrayList<Table> tablesR, ArrayList<Table> tablesS, Table tableRes)
    {
        this.tables = tables;
        this.tablesR = tablesR;
        this.tablesS = tablesS;
        this.tableRes = tableRes;
    }
    
    public Table getTableR(int num)
    {
        return this.tablesR.get(num);
    }
    
    public Table getTableS(int num)
    {
        return this.tablesS.get(num);
    }
    
    public String toString()
    {
        String chaine = "Sous tables de R :\n";
        for (Table table : this.tablesR)
        {
            chaine += table.toString();
        }
        
        chaine += "Sous tables de S:\n";
        
        for (Table table : this.tablesS)
        {
            chaine += table.toString();
        }
        
        chaine += "table de Res:\n";

        chaine += this.tableRes.toString();

        return chaine;
    }
    
    public Table getTableRes(){
        return this.tableRes;
    }
}
