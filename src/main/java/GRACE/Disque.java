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
    private ArrayList<Table> tablesRes;
    
    public Disque(ArrayList<Table> tables, ArrayList<Table> tablesR, ArrayList<Table> tablesS)
    {
        this.tables = tables;
        this.tablesR = tablesR;
        this.tablesS = tablesS;
    }
    
    public Table getTableR()
    {
        return this.tables.get(0);
    }
    
    public Table getTableS()
    {
        return this.tables.get(1);
    }
    
    public Table getTableRes(){
        return this.tablesRes.get(0);
    }
    
    public void setTableRes(Table e){
        this.tablesRes.add(e);
    }
}
