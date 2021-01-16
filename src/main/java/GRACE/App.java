package GRACE;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Table R = new Table ("R");
       Table R1 = new Table ("R1");
       Table R2 = new Table ("R2");
       Table R3 = new Table ("R3");
       
       ArrayList<Table> disque = new ArrayList<Table>();
       disque.add(R);
       disque.add(R1);
       disque.add(R2);
       disque.add(R3);
       
       ArrayList<String> liste1 = new ArrayList<String>();
       liste1.add("Redouane");
       liste1.add("El Mansouri");
       liste1.add("23");
       Tuple tuple1 = new Tuple("1",liste1);
       
       ArrayList<String> liste2 = new ArrayList<String>();
       liste2.add("Anttony");
       liste2.add("Gomes");
       liste2.add("22");
       Tuple tuple2 = new Tuple("2",liste2);
       
       ArrayList<String> liste3 = new ArrayList<String>();
       liste3.add("Romain");
       liste3.add("Chardonnet");
       liste3.add("22");
       Tuple tuple3 = new Tuple("3",liste3);
       
       ArrayList<String> liste4 = new ArrayList<String>();
       liste4.add("Lukas");
       liste4.add("Barthélémy");
       liste4.add("22");
       Tuple tuple4 = new Tuple("4",liste4);
       
       ArrayList<String> liste5 = new ArrayList<String>();
       liste5.add("Elie");
       liste5.add("Isaac");
       liste5.add("22");
       Tuple tuple5 = new Tuple("5",liste5);
       
       ArrayList<String> liste6 = new ArrayList<String>();
       liste6.add("Sarra");
       liste6.add("Mansar");
       liste6.add("25");
       Tuple tuple6 = new Tuple("6",liste6);
       
       R.ecrireTuple(tuple1);
       R.ecrireTuple(tuple2);
       R.ecrireTuple(tuple3);
       R.ecrireTuple(tuple4);
       R.ecrireTuple(tuple5);
       R.ecrireTuple(tuple6);
       System.out.println(R);
       
       MC mc = new MC();
       mc.fill(R);
       System.out.println(mc);
    }
}