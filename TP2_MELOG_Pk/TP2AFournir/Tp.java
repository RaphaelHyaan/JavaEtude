///////////////////////////////////////////////////////
// Olivier ROUX
//  - TP2  	Tp.java
///////////////////////////////////////////////////////

import java.io.*;
import java.util.*;

public class Tp {
	public static void main(String[] argv) throws IOException {
		long startTime = System.currentTimeMillis();

		// Recuperation du nom du fichier a traiter
		String fichier;
        fichier =(argv.length!=0)? argv[0]: "Textes/lesMiserables_A";
		// Appel de l'affichage du texte
		ContenuHash t = new ContenuHash(fichier);
		// Ecriture du texte modifie dans un second fichier texte
		t.addNewText("Textes/notreDameDeParis_A");
		t.sortByValue();
		// t.printNewWord();
		// t.printPosition("open");
		t.printWordPlusFrequence();
		t.ecri();
		t.getWordNumber();
		System.out.println(t.testWord("bonjour"));
		t.deleteWord("bonjour");
		System.out.println(t.testWord("bonjour"));
		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime-startTime);
	}
}
