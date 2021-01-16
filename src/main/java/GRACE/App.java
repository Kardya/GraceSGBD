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
       
       Table S = new Table ("S");
       Table S1 = new Table ("S1");
       Table S2 = new Table ("S2");
       Table S3 = new Table ("S3");
       
       ArrayList<Table> tables = new ArrayList<Table>();
       ArrayList<Table> tablesR = new ArrayList<Table>();
       ArrayList<Table> tablesS = new ArrayList<Table>();
       tables.add(R);
       tablesR.add(R1);
       tablesR.add(R2);
       tablesR.add(R3);
       tablesS.add(S1);
       tablesS.add(S2);
       tablesS.add(S3);
       
       Disque disque = new Disque(tables,tablesR,tablesS);
       
       ArrayList<String> liste1 = new ArrayList<String>();
       liste1.add("Redouane");
       liste1.add("El Mansouri");
       liste1.add("23");
       Tuple tuple1 = new Tuple("1",liste1);
       
       ArrayList<String> liste2 = new ArrayList<String>();
       liste2.add("Anttony");
       liste2.add("Gomess");
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
       
       ArrayList<String> liste7 = new ArrayList<String>();
       liste7.add("Herine");
       liste7.add("Servan");
       liste7.add("22");
       Tuple tuple7 = new Tuple("1",liste7);
       
       ArrayList<String> liste8 = new ArrayList<String>();
       liste8.add("Lise");
       liste8.add("Kabbache");
       liste8.add("25");
       Tuple tuple8 = new Tuple("2",liste8);
       
       ArrayList<String> liste9 = new ArrayList<String>();
       liste9.add("Yoann");
       liste9.add("Vincent");
       liste9.add("20");
       Tuple tuple9 = new Tuple("3",liste9);
       
       ArrayList<String> liste10 = new ArrayList<String>();
       liste10.add("Bastien");
       liste10.add("Bobb");
       liste10.add("22");
       Tuple tuple10 = new Tuple("4",liste10);
       
       ArrayList<String> liste11 = new ArrayList<String>();
       liste11.add("Rafik");
       liste11.add("Boushaki");
       liste11.add("22");
       Tuple tuple11 = new Tuple("5",liste11);
       
       ArrayList<String> liste12 = new ArrayList<String>();
       liste12.add("Wassim");
       liste12.add("Ouchene");
       liste12.add("22");
       Tuple tuple12 = new Tuple("6",liste12);
       
       S.ecrireTuple(tuple7);
       S.ecrireTuple(tuple8);
       S.ecrireTuple(tuple9);
       S.ecrireTuple(tuple10);
       S.ecrireTuple(tuple11);
       S.ecrireTuple(tuple12);
       
       //System.out.println(R);
       //System.out.println(S);
       
       MC mc = new MC(disque);
       mc.fill(R);
       mc.fill(S);
       System.out.println(disque);
    }
}