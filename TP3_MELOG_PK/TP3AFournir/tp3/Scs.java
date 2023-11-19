
// Exemple d'utilisation de la classe Arbre fournie pour le TP n III
// exemple d'execution : java Sc "(x+3)*(5-(2*x))"
// necessite les fichiers Arbre.java, Clavier.javaGUIHelper.java, JCanvas.java, ManipulationArbre.java, TextInter.java
import java.io.*;
import java.util.Vector;
import java.awt.Dimension;
import javax.swing.*;

public class Scs {

	public static void main(String args[]) throws IOException {
		CalculArbre arbre = new CalculArbre();
		Vector<String> a = new Vector<>();
		// arbre.getExpression("0+2*3/4*(1/2+5^2/(x+0))");
		// arbre.getExpression("x^3+2*x^2+2*x+1");
		arbre.getExpression("(x^2)/(x)");
		// arbre.derivePolynome();
		arbre.deriveRationnelle();
		arbre.printArbre();
		arbre.setX(6.0);
		System.out.println(arbre.calculArbre());
	}
}