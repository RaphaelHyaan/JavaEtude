
// Exemple d'utilisation de la classe Arbre fournie pour le TP n III
// exemple d'execution : java Sc "(x+3)*(5-(2*x))"
// necessite les fichiers Arbre.java, Clavier.javaGUIHelper.java, JCanvas.java, ManipulationArbre.java, TextInter.java
import java.io.*;
import java.awt.Dimension;
import javax.swing.*;

public class Sc {

	public static void main(String args[]) throws IOException {
		// utilisation des methodes pour transformer le texte d'une expression en un
		// arbre (avec stockage dans un format intermediaire)
		if (args.length == 0) {
			System.out.println("Default");
			Arbre arbre = ManipulationArbre.generationArbredepuisTexte("(x+3)*(5-(2*x))");
			System.out.println("FI");
		} else {
			System.out.println("Normal");
			ManipulationArbre.generationXMLdepuisTexte(args, "XML.xml");
		}
		;
		ManipulationArbre.XMLVersArbre("XML.xml").afficherPrefixe();
		System.out.println();
		// Utilisation: java Sc "(x+3)*(5-(2*x))" donne comme resultat:
		// * + x 3 - 5 * 2 x

		// Recuperation d'un objet de la classe Arbre
		Arbre arbre = ManipulationArbre.XMLVersArbre("XML.xml");
		arbre.afficherPrefixe();
		System.out.println();

		// utilisation de la methode pour afficher l'arbre dans une fenetre.
		ManipulationArbre.Affiche(arbre);

	}
}
