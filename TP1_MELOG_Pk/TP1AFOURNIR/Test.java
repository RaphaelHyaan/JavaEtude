/**
   fichier Test.java
   Trace de differents objets graphiques
   Utilisation de la classe obstraite ObjetGraphique
*/

import java.util.*;
import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;

public class Test {
   public static void main(String[] a) {       
	Vector<ObjetGraphique> mesObjetsG = new Vector<ObjetGraphique>();
	Segment s1 = new Segment();
	       
	Point p1 = new Point(100,100);
	Point p2 = new Point(100,200);
	Point p3 = new Point(200,300);
	Point p4 = new Point(300,300);
      
	//segment
	// s1.ajouterSommet(p1);	s1.ajouterSommet(p3);
	
	// SegmentColore s2 = new SegmentColore(new Segment (s1), Color.red);
	// s2.translater(150,-60);

	// SegmentColore s3 = new SegmentColore(new Segment (s1.getVectP().get(0),s1.getVectP().get(1)), Color.blue);
	// s3.translater(20,150);
      
	// SegmentColore s4 = new SegmentColore(new Segment (s1.getVectP().get(0),(s1.getVectP().get(1)).translaterP(150,-200)), Color.cyan);

    //   // Instructions d'affichage des figures
      
    //   monDessin.ajoutObjet(s1);
	//   monDessin.ajoutObjet(s2);
	//   monDessin.ajoutObjet(s3);
	//   monDessin.ajoutObjet(s4);

	//

	//polygone

	Point[] points = {p1,p2,p3,p4};
	Polygone poly1 = new Polygone(points);

	PolygoneColore poly2 = new PolygoneColore(points, Color.red);
	poly2.translater(100, 50);

	RectangleColore rect1 = new RectangleColore(p3, p1, Color.blue);

	Affichage monDessin;  monDessin = new Affichage();
	monDessin.ajoutObjet(poly1);
	monDessin.ajoutObjet(poly2);
	monDessin.ajoutObjet(rect1);
	monDessin.setVisible(true);
   }
}


