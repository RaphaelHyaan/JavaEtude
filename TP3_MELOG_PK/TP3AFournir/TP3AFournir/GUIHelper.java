// Source code is decompiled from a .class file using FernFlower decompiler.
import javax.swing.JComponent;
import javax.swing.JFrame;

public class GUIHelper {
public GUIHelper() {
}

public static void showOnFrame(JComponent var0, String var1) {
    JFrame var2 = new JFrame(var1);
    GUIHelper$1 var3 = new GUIHelper$1();
    var2.addWindowListener(var3);
    var2.getContentPane().add(var0);
    var2.pack();
    var2.setVisible(true);
}
}
