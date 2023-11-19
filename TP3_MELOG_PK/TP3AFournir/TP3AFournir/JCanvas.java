
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.Graphics;
import javax.swing.JPanel;

public class JCanvas extends JPanel {
    protected Arbre arbre;

    JCanvas(Arbre var1) {
        this.arbre = var1;
    }

    public void paint(Graphics var1) {
        byte var2 = 50;
        int var3 = 2 ^ (this.arbre.hauteur() - 1) * 150 / 2;
        this.drawNode(var1, this.arbre, var3, var2);
    }

    public void drawNode(Graphics var1, Arbre var2, int var3, int var4) {
        var1.drawString(var2.valeur().toString(), var3, var4);
        if (var2.filsDroit() != null) {
            var1.drawLine(var3, var4 + 5, var3 + 25 * var2.filsDroit().hauteur() + 5, var4 + 50 - 15);
            this.drawNode(var1, var2.filsDroit(), var3 + 25 * var2.filsDroit().hauteur(), var4 + 50);
        }

        if (var2.filsGauche() != null) {
            var1.drawLine(var3, var4 + 5, var3 - 25 * var2.filsGauche().hauteur() + 5, var4 + 50 - 15);
            this.drawNode(var1, var2.filsGauche(), var3 - 25 * var2.filsGauche().hauteur(), var4 + 50);
        }

    }
}
