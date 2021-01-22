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
       Table tableRes = new Table("Resultat");
       tables.add(R);
       tablesR.add(R1);
       tablesR.add(R2);
       tablesR.add(R3);
       tablesS.add(S1);
       tablesS.add(S2);
       tablesS.add(S3);
       
       Disque disque = new Disque(tables,tablesR,tablesS,tableRes);
       
       ArrayList<String> liste1 = new ArrayList<String>();
       liste1.add("Redouane");
       liste1.add("El Mansouri");
       liste1.add("23");
       Tuple tuple1 = new Tuple("1",liste1);
       
       ArrayList<String> liste2 = new ArrayList<String>();
       liste2.add("Antony");
       liste2.add("Gomes");
       liste2.add("22");
       Tuple tuple2 = new Tuple("2",liste2);
       
       ArrayList<String> liste3 = new ArrayList<String>();
       liste3.add("Romain");
       liste3.add("Chardonnet");
       liste3.add("21");
       Tuple tuple3 = new Tuple("3",liste3);
       
       ArrayList<String> liste4 = new ArrayList<String>();
       liste4.add("Lukas");
       liste4.add("Barthélémy");
       liste4.add("20");
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
       liste10.add("25");
       Tuple tuple10 = new Tuple("4",liste10);
       
       ArrayList<String> liste11 = new ArrayList<String>();
       liste11.add("Rafik");
       liste11.add("Boushaki");
       liste11.add("25");
       Tuple tuple11 = new Tuple("5",liste11);
       
       ArrayList<String> liste12 = new ArrayList<String>();
       liste12.add("Wassim");
       liste12.add("Ouchene");
       liste12.add("25");
       Tuple tuple12 = new Tuple("6",liste12);
       
       ArrayList<String> liste13 = new ArrayList<String>();
       liste13.add("Elhadj");
       liste13.add("Balde");
       liste13.add("25");
       Tuple tuple13 = new Tuple("7",liste13);
       
       ArrayList<String> liste14 = new ArrayList<String>();
       liste14.add("Sacha");
       liste14.add("Choumiloff");
       liste14.add("23");
       Tuple tuple14 = new Tuple("8",liste14);
       
       ArrayList<String> liste15 = new ArrayList<String>();
       liste15.add("Lucas");
       liste15.add("Chapelon");
       liste15.add("23");
       Tuple tuple15 = new Tuple("9",liste15);
       
       ArrayList<String> liste16 = new ArrayList<String>();
       liste16.add("Dorine");
       liste16.add("Chassagne");
       liste16.add("23");
       Tuple tuple16 = new Tuple("10",liste16);
       
       ArrayList<String> liste17 = new ArrayList<String>();
       liste17.add("Jeremy");
       liste17.add("Hurdebourcq");
       liste17.add("23");
       Tuple tuple17 = new Tuple("11",liste17);
       
       ArrayList<String> liste18 = new ArrayList<String>();
       liste18.add("Guillaume");
       liste18.add("Lortet");
       liste18.add("23");
       Tuple tuple18 = new Tuple("12",liste18);
       
       ArrayList<String> liste19 = new ArrayList<String>();
       liste19.add("Francinette");
       liste19.add("Atchade");
       liste19.add("21");
       Tuple tuple19 = new Tuple("13",liste19);
       
       ArrayList<String> liste20 = new ArrayList<String>();
       liste20.add("Emile");
       liste20.add("Aveko");
       liste20.add("21");
       Tuple tuple20 = new Tuple("14",liste20);
       
       ArrayList<String> liste21 = new ArrayList<String>();
       liste21.add("Dabi-Dit-Oumar");
       liste21.add("Diawara");
       liste21.add("20");
       Tuple tuple21 = new Tuple("15",liste21);
       
       ArrayList<String> liste22 = new ArrayList<String>();
       liste22.add("Joyeuse");
       liste22.add("Uwizeye");
       liste22.add("20");
       Tuple tuple22 = new Tuple("16",liste22);
       
       ArrayList<String> liste23 = new ArrayList<String>();
       liste23.add("Iman");
       liste23.add("Sabouhi");
       liste23.add("20");
       Tuple tuple23 = new Tuple("17",liste23);
       
       ArrayList<String> liste24 = new ArrayList<String>();
       liste24.add("Nathan");
       liste24.add("Voizeux");
       liste24.add("20");
       Tuple tuple24 = new Tuple("18",liste24);
       
       ArrayList<String> liste25 = new ArrayList<String>();
       liste25.add("Sebastien");
       liste25.add("Guillemin");
       liste25.add("20");
       Tuple tuple25 = new Tuple("19",liste25);
       
       ArrayList<String> liste26 = new ArrayList<String>();
       liste26.add("Baptiste");
       liste26.add("Chemain");
       liste26.add("21");
       Tuple tuple26 = new Tuple("20",liste26);
       
       ArrayList<String> liste27 = new ArrayList<String>();
       liste27.add("Wassila");
       liste27.add("Ziani");
       liste27.add("21");
       Tuple tuple27 = new Tuple("21",liste27);
       
       S.ecrireTuple(tuple7);
       S.ecrireTuple(tuple8);
       S.ecrireTuple(tuple9);
       S.ecrireTuple(tuple10);
       S.ecrireTuple(tuple11);
       S.ecrireTuple(tuple12);
       S.ecrireTuple(tuple13);
       S.ecrireTuple(tuple14);
       S.ecrireTuple(tuple15);
       S.ecrireTuple(tuple16);
       S.ecrireTuple(tuple17);
       S.ecrireTuple(tuple18);
       S.ecrireTuple(tuple19);
       S.ecrireTuple(tuple20);
       S.ecrireTuple(tuple21);
       S.ecrireTuple(tuple22);
       S.ecrireTuple(tuple23);
       S.ecrireTuple(tuple24);
       S.ecrireTuple(tuple25);
       S.ecrireTuple(tuple26);
       S.ecrireTuple(tuple27);
       
       System.out.println(R);
       System.out.println(S);
       
       MC mc = new MC(disque);
       mc.fill(R);
       mc.fill(S);
       mc.Grace(2, 2);
       System.out.println(disque);
    }
}