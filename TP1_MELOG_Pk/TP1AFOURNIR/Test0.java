/**
   fichier Test0.java
*/

import java.util.*;

public class Test0 {
   public static void main(String[] a) {       
	Vector<ObjetGraphique> mesObjetsG = new Vector<ObjetGraphique>();
	Segment0 s1 = new Segment0();
	       
	Point p1 = new Point(100,100);
    System.out.println("Coordonnées de point p1 : "+p1.toString());   
	Point p3 = new Point(200,300);
      

    // Retirer les commentaires des lignes suivantes pour la question 2. 
	s1.ajouterSommet(p1);	s1.ajouterSommet(p3);
	s1.translater(150,-60);
    System.out.println("Coordonnées d'une extrémité du segment s1 : "+s1.getExtremite(1).toString());   
    System.out.println("Coordonnées de la deuxième extrémité du segment s1 : "+s1.getExtremite(2).toString());   
  }
}


