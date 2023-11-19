
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ManipulationArbre {
    public ManipulationArbre() {
    }

    public static void generationXMLdepuisTexte(String[] var0, String var1) {
        String var2 = "";

        for (int var3 = 0; var3 < var0.length; ++var3) {
            var2 = var2 + var0[var3];
        }

        generationXMLdepuisTexte(var2, var1);
    }

    public static void generationXMLdepuisTexte(String var0, String var1) {
        int var2 = 0;
        int var4 = 0;
        String var5 = "";
        String var6 = "";
        boolean var7 = true;
        boolean var8 = false;
        LinkedList var9 = new LinkedList();
        LinkedList var10 = new LinkedList();
        StringReader var11 = new StringReader(var0);

        while (true) {
            int var3;
            try {
                if ((var3 = var11.read()) != -1) {
                    if (var7) {
                        if (var3 != 40) {
                            var8 = true;
                        }

                        var10.add(0);
                        var4 = 40;
                        var7 = false;
                    } else if (var2 == 0) {
                        var8 = true;
                    }

                    switch (var3) {
                        case 40:
                            if (var4 == 41 || var4 == 120 || var4 >= 48 && var4 <= 57) {
                                System.out.println("Chaine non conforme");
                                return;
                            }

                            ++var2;
                            var10.add(0);
                            break;
                        case 41:
                            if (var4 == 40 || var4 >= 97 && var4 <= 115 || var4 >= 42 && var4 <= 47) {
                                System.out.println("Chaine non conforme");
                                return;
                            }

                            --var2;
                            if ((Integer) var10.getLast() > 1) {
                                System.out.println("Identifiez chaque operation elementaire avec des parentheses.");
                                return;
                            }

                            var10.removeLast();
                            break;
                        case 42:
                            if (var4 == 40 || var4 >= 97 && var4 <= 115 || var4 >= 42 && var4 <= 47) {
                                System.out.println("Chaine non conforme");
                                return;
                            }

                            var10.set(var10.size() - 1, (Integer) var10.getLast() + 1);
                            break;
                        case 43:
                            if (var4 == 40 || var4 >= 97 && var4 <= 115 || var4 >= 42 && var4 <= 47) {
                                System.out.println("Chaine non conforme");
                                return;
                            }

                            var10.set(var10.size() - 1, (Integer) var10.getLast() + 1);
                            break;
                        case 44:
                        case 46:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 82:
                        case 83:
                        case 84:
                        case 85:
                        case 86:
                        case 87:
                        case 88:
                        case 89:
                        case 90:
                        case 91:
                        case 92:
                        case 93:
                        case 95:
                        case 96:
                        case 98:
                        case 100:
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 106:
                        case 107:
                        case 108:
                        case 109:
                        case 112:
                        case 113:
                        case 114:
                        case 117:
                        case 118:
                        case 119:
                        default:
                            System.out.println("Chaine non conforme");
                            return;
                        case 45:
                            if (var4 == 40 || var4 >= 97 && var4 <= 115 || var4 >= 42 && var4 <= 47) {
                                System.out.println("Chaine non conforme");
                                return;
                            }

                            var10.set(var10.size() - 1, (Integer) var10.getLast() + 1);
                            break;
                        case 47:
                            if (var4 == 40 || var4 >= 97 && var4 <= 115 || var4 >= 42 && var4 <= 47) {
                                System.out.println("Chaine non conforme");
                                return;
                            }

                            var10.set(var10.size() - 1, (Integer) var10.getLast() + 1);
                            break;
                        case 48:
                            if (var4 == 41 || var4 >= 97 && var4 <= 115 || var4 == 120) {
                                System.out.println("Chaine non conforme");
                                return;
                            }
                            break;
                        case 49:
                            if (var4 == 41 || var4 >= 97 && var4 <= 115 || var4 == 120) {
                                System.out.println("Chaine non conforme");
                                return;
                            }
                            break;
                        case 50:
                            if (var4 == 41 || var4 >= 97 && var4 <= 115 || var4 == 120) {
                                System.out.println("Chaine non conforme");
                                return;
                            }
                            break;
                        case 51:
                            if (var4 != 41 && (var4 < 97 || var4 > 115) && var4 != 120) {
                                break;
                            }

                            System.out.println("Chaine non conforme");
                            return;
                        case 52:
                            if (var4 != 41 && (var4 < 97 || var4 > 115) && var4 != 120) {
                                break;
                            }

                            System.out.println("Chaine non conforme");
                            return;
                        case 53:
                            if (var4 != 41 && (var4 < 97 || var4 > 115) && var4 != 120) {
                                break;
                            }

                            System.out.println("Chaine non conforme");
                            return;
                        case 54:
                            if (var4 == 41 || var4 >= 97 && var4 <= 115 || var4 == 120) {
                                System.out.println("Chaine non conforme");
                                return;
                            }
                            break;
                        case 55:
                            if (var4 == 41 || var4 >= 97 && var4 <= 115 || var4 == 120) {
                                System.out.println("Chaine non conforme");
                                return;
                            }
                            break;
                        case 56:
                            if (var4 == 41 || var4 >= 97 && var4 <= 115 || var4 == 120) {
                                System.out.println("Chaine non conforme");
                                return;
                            }
                            break;
                        case 57:
                            if (var4 == 41 || var4 >= 97 && var4 <= 115 || var4 == 120) {
                                System.out.println("Chaine non conforme");
                                return;
                            }
                            break;
                        case 94:
                            if (var4 == 40 || var4 >= 97 && var4 <= 115 || var4 >= 42 && var4 <= 47) {
                                System.out.println("Chaine non conforme");
                                return;
                            }

                            var10.set(var10.size() - 1, (Integer) var10.getLast() + 1);
                            break;
                        case 97:
                            if (var4 != 41 && (var4 < 48 || var4 > 57) && var4 != 120 && (var4 < 42 || var4 > 47)
                                    && var4 != 115 && var4 != 105 && var4 != 110 && var4 != 99 && var4 != 111
                                    && var4 != 97) {
                                break;
                            }

                            System.out.println("Chaine non conforme");
                            return;
                        case 99:
                            if (var4 == 41 || var4 >= 48 && var4 <= 57 || var4 == 120 || var4 == 115 || var4 == 105
                                    || var4 == 110 || var4 == 99 || var4 == 111 || var4 == 116 || var4 == 97) {
                                System.out.println("Chaine non conforme");
                                return;
                            }
                            break;
                        case 105:
                            if (var4 != 41 && (var4 < 48 || var4 > 57) && var4 != 120 && (var4 < 42 || var4 > 47)
                                    && var4 != 105 && var4 != 110 && var4 != 99 && var4 != 111 && var4 != 116
                                    && var4 != 97) {
                                break;
                            }

                            System.out.println("Chaine non conforme");
                            return;
                        case 110:
                            if (var4 != 41 && (var4 < 48 || var4 > 57) && var4 != 120 && (var4 < 42 || var4 > 47)
                                    && var4 != 115 && var4 != 110 && var4 != 99 && var4 != 111 && var4 != 116) {
                                break;
                            }

                            System.out.println("Chaine non conforme");
                            return;
                        case 111:
                            if (var4 == 41 || var4 >= 48 && var4 <= 57 || var4 == 120 || var4 >= 42 && var4 <= 47
                                    || var4 == 115 || var4 == 105 || var4 == 110 || var4 == 111 || var4 == 116
                                    || var4 == 97) {
                                System.out.println("Chaine non conforme");
                                return;
                            }
                            break;
                        case 115:
                            if (var4 == 41 || var4 >= 48 && var4 <= 57 || var4 == 120 || var4 == 115 || var4 == 105
                                    || var4 == 110 || var4 == 99 || var4 == 116 || var4 == 97) {
                                System.out.println("Chaine non conforme");
                                return;
                            }
                            break;
                        case 116:
                            if (var4 == 41 || var4 >= 48 && var4 <= 57 || var4 == 120 || var4 == 115 || var4 == 105
                                    || var4 == 110 || var4 == 99 || var4 == 111 || var4 == 116 || var4 == 97) {
                                System.out.println("Chaine non conforme");
                                return;
                            }
                            break;
                        case 120:
                            if (var4 == 41 || var4 >= 48 && var4 <= 57 || var4 >= 97 && var4 <= 115 || var4 == 120) {
                                System.out.println("Chaine non conforme");
                                return;
                            }
                    }

                    var4 = var3;
                    continue;
                }
            } catch (IOException var26) {
                var26.printStackTrace();
            }

            if (var2 != 0) {
                System.out.println("Chaine non conforme");
                return;
            }

            if ((Integer) var10.getLast() > 1) {
                System.out.println("Identifiez chaque operation elementaire avec des parentheses.");
                return;
            }

            if (var8) {
                var0 = "(" + var0 + ")";
            }

            DocumentBuilderFactory var12 = DocumentBuilderFactory.newInstance();

            try {
                DocumentBuilder var13 = var12.newDocumentBuilder();
                Document var14 = var13.newDocument();
                var14.setXmlVersion("1.0");
                var14.setXmlStandalone(true);
                Element var15 = var14.createElement("Operation");
                var14.appendChild(var15);
                StringReader var16 = new StringReader(var0);
                var9.add((Element) var15);

                while ((var3 = var16.read()) != -1) {
                    switch (var3) {
                        case 40:
                            if (var5 != "") {
                                if (((Element) var9.getLast()).hasAttribute("type")) {
                                    var9.add(var14.createElement("Noeud"));
                                }

                                ((Element) var9.getLast()).setAttribute("type", "action");
                                ((Element) var9.getLast()).setAttribute("fonction", var5);
                                var5 = "";
                            }

                            var9.add(var14.createElement("Noeud"));
                            break;
                        case 41:
                            if (var6 != "") {
                                if (((Element) var9.getLast()).hasAttribute("type")) {
                                    var9.add(var14.createElement("Noeud"));
                                }

                                ((Element) var9.getLast()).setAttribute("type", "valeur");
                                ((Element) var9.getLast()).setAttribute("valeur", var6);
                                var6 = "";
                            }

                            ((Element) var9.get(var9.size() - 2)).appendChild((Node) var9.getLast());
                            var9.removeLast();
                            break;
                        case 42:
                            if (var6 != "") {
                                ((Element) var9.getLast()).setAttribute("type", "action");
                                ((Element) var9.getLast()).setAttribute("fonction", "*");
                                var9.add(var14.createElement("Noeud"));
                                ((Element) var9.getLast()).setAttribute("type", "valeur");
                                ((Element) var9.getLast()).setAttribute("valeur", var6);
                                var6 = "";
                                ((Element) var9.get(var9.size() - 2)).appendChild((Node) var9.getLast());
                                var9.removeLast();
                            } else {
                                ((Element) var9.get(var9.size() - 2)).appendChild((Node) var9.getLast());
                                var9.removeLast();
                                ((Element) var9.getLast()).setAttribute("type", "action");
                                ((Element) var9.getLast()).setAttribute("fonction", "*");
                            }
                            break;
                        case 43:
                            if (var6 != "") {
                                ((Element) var9.getLast()).setAttribute("type", "action");
                                ((Element) var9.getLast()).setAttribute("fonction", "+");
                                var9.add(var14.createElement("Noeud"));
                                ((Element) var9.getLast()).setAttribute("type", "valeur");
                                ((Element) var9.getLast()).setAttribute("valeur", var6);
                                var6 = "";
                                ((Element) var9.get(var9.size() - 2)).appendChild((Node) var9.getLast());
                                var9.removeLast();
                            } else {
                                ((Element) var9.get(var9.size() - 2)).appendChild((Node) var9.getLast());
                                var9.removeLast();
                                ((Element) var9.getLast()).setAttribute("type", "action");
                                ((Element) var9.getLast()).setAttribute("fonction", "+");
                            }
                        case 44:
                        case 46:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 82:
                        case 83:
                        case 84:
                        case 85:
                        case 86:
                        case 87:
                        case 88:
                        case 89:
                        case 90:
                        case 91:
                        case 92:
                        case 93:
                        case 95:
                        case 96:
                        case 98:
                        case 100:
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 106:
                        case 107:
                        case 108:
                        case 109:
                        case 112:
                        case 113:
                        case 114:
                        case 117:
                        case 118:
                        case 119:
                        default:
                            break;
                        case 45:
                            if (var6 != "") {
                                ((Element) var9.getLast()).setAttribute("type", "action");
                                ((Element) var9.getLast()).setAttribute("fonction", "-");
                                var9.add(var14.createElement("Noeud"));
                                ((Element) var9.getLast()).setAttribute("type", "valeur");
                                ((Element) var9.getLast()).setAttribute("valeur", var6);
                                var6 = "";
                                ((Element) var9.get(var9.size() - 2)).appendChild((Node) var9.getLast());
                                var9.removeLast();
                            } else {
                                ((Element) var9.get(var9.size() - 2)).appendChild((Node) var9.getLast());
                                var9.removeLast();
                                ((Element) var9.getLast()).setAttribute("type", "action");
                                ((Element) var9.getLast()).setAttribute("fonction", "-");
                            }
                            break;
                        case 47:
                            if (var6 != "") {
                                ((Element) var9.getLast()).setAttribute("type", "action");
                                ((Element) var9.getLast()).setAttribute("fonction", "/");
                                var9.add(var14.createElement("Noeud"));
                                ((Element) var9.getLast()).setAttribute("type", "valeur");
                                ((Element) var9.getLast()).setAttribute("valeur", var6);
                                var6 = "";
                                ((Element) var9.get(var9.size() - 2)).appendChild((Node) var9.getLast());
                                var9.removeLast();
                            } else {
                                ((Element) var9.get(var9.size() - 2)).appendChild((Node) var9.getLast());
                                var9.removeLast();
                                ((Element) var9.getLast()).setAttribute("type", "action");
                                ((Element) var9.getLast()).setAttribute("fonction", "/");
                            }
                            break;
                        case 48:
                            var6 = var6 + "0";
                            break;
                        case 49:
                            var6 = var6 + "1";
                            break;
                        case 50:
                            var6 = var6 + "2";
                            break;
                        case 51:
                            var6 = var6 + "3";
                            break;
                        case 52:
                            var6 = var6 + "4";
                            break;
                        case 53:
                            var6 = var6 + "5";
                            break;
                        case 54:
                            var6 = var6 + "6";
                            break;
                        case 55:
                            var6 = var6 + "7";
                            break;
                        case 56:
                            var6 = var6 + "8";
                            break;
                        case 57:
                            var6 = var6 + "9";
                            break;
                        case 94:
                            if (var6 != "") {
                                ((Element) var9.getLast()).setAttribute("type", "action");
                                ((Element) var9.getLast()).setAttribute("fonction", "^");
                                var9.add(var14.createElement("Noeud"));
                                ((Element) var9.getLast()).setAttribute("type", "valeur");
                                ((Element) var9.getLast()).setAttribute("valeur", var6);
                                var6 = "";
                                ((Element) var9.get(var9.size() - 2)).appendChild((Node) var9.getLast());
                                var9.removeLast();
                            } else {
                                ((Element) var9.get(var9.size() - 2)).appendChild((Node) var9.getLast());
                                var9.removeLast();
                                ((Element) var9.getLast()).setAttribute("type", "action");
                                ((Element) var9.getLast()).setAttribute("fonction", "^");
                            }
                            break;
                        case 97:
                            var5 = var5 + "a";
                            break;
                        case 99:
                            var5 = var5 + "c";
                            break;
                        case 105:
                            var5 = var5 + "i";
                            break;
                        case 110:
                            var5 = var5 + "n";
                            break;
                        case 111:
                            var5 = var5 + "o";
                            break;
                        case 115:
                            var5 = var5 + "s";
                            break;
                        case 116:
                            var5 = var5 + "t";
                            break;
                        case 120:
                            var6 = var6 + "x";
                    }
                }

                while (var9.size() > 1) {
                    ((Element) var9.get(var9.size() - 2)).appendChild((Node) var9.get(var9.size() - 1));
                    var9.removeLast();
                }

                DOMSource var17 = new DOMSource(var14);
                new File(var1);
                StreamResult var19 = new StreamResult(var1);
                TransformerFactory var20 = TransformerFactory.newInstance();
                Transformer var21 = var20.newTransformer();
                var21.setOutputProperty("indent", "yes");
                var21.setOutputProperty("encoding", "ISO-8859-1");
                var21.transform(var17, var19);
            } catch (ParserConfigurationException var22) {
                var22.printStackTrace();
            } catch (IOException var23) {
                var23.printStackTrace();
            } catch (TransformerConfigurationException var24) {
                var24.printStackTrace();
            } catch (TransformerException var25) {
                var25.printStackTrace();
            }

            return;
        }
    }

    private static Element arbreVersXMLSimple(Arbre var0, Document var1) {
        Element var2 = var1.createElement("Noeud");
        boolean var3 = false;
        if (var0.existeFilsGauche()) {
            var2.appendChild(arbreVersXMLSimple(var0.filsGauche(), var1));
            var3 = true;
        }

        if (var0.existeFilsDroit()) {
            var2.appendChild(arbreVersXMLSimple(var0.filsDroit(), var1));
            var3 = true;
        }

        if (var3) {
            var2.setAttribute("type", "action");
            var2.setAttribute("fonction", (String) var0.valeur());
        } else {
            var2.setAttribute("type", "valeur");
            var2.setAttribute("valeur", (String) var0.valeur());
        }

        return var2;
    }

    public static void arbreVersXML(Arbre var0, String var1) {
        try {
            DocumentBuilderFactory var2 = DocumentBuilderFactory.newInstance();
            DocumentBuilder var3 = var2.newDocumentBuilder();
            Document var4 = var3.newDocument();
            var4.setXmlVersion("1.0");
            var4.setXmlStandalone(true);
            Element var5 = var4.createElement("Operation");
            var5.appendChild(arbreVersXMLSimple(var0, var4));
            var4.appendChild(var5);
            DOMSource var6 = new DOMSource(var4);
            new File(var1);
            StreamResult var8 = new StreamResult(var1);
            TransformerFactory var9 = TransformerFactory.newInstance();
            Transformer var10 = var9.newTransformer();
            var10.setOutputProperty("indent", "yes");
            var10.setOutputProperty("encoding", "ISO-8859-1");
            var10.transform(var6, var8);
        } catch (ParserConfigurationException var11) {
            var11.printStackTrace();
        } catch (TransformerConfigurationException var12) {
            var12.printStackTrace();
        } catch (TransformerException var13) {
            var13.printStackTrace();
        }

    }

    private static Arbre XMLVersArbreSimple(Element var0) {
        if (!var0.getAttribute("type").equals("action")) {
            return var0.getAttribute("type").equals("valeur") ? new Arbre(var0.getAttribute("valeur")) : null;
        } else {
            int var3 = 0;

            NodeList var4;
            for (var4 = var0.getElementsByTagName("Noeud"); var3 < var4.getLength()
                    && var4.item(var3).getParentNode() != var0; ++var3) {
            }

            Arbre var1 = XMLVersArbreSimple((Element) var4.item(var3));
            ++var3;

            while (var3 < var4.getLength() && var4.item(var3).getParentNode() != var0) {
                ++var3;
            }

            if (var3 < var4.getLength()) {
                Arbre var2 = XMLVersArbreSimple((Element) var4.item(var3));
                return new Arbre(var0.getAttribute("fonction"), var1, var2);
            } else {
                return new Arbre(var0.getAttribute("fonction"), var1, (Arbre) null);
            }
        }
    }

    public static Arbre XMLVersArbre(String var0) {
        try {
            DocumentBuilderFactory var1 = DocumentBuilderFactory.newInstance();
            DocumentBuilder var2 = var1.newDocumentBuilder();
            File var3 = new File(var0);
            Document var4 = var2.parse(var3);
            Element var5 = var4.getDocumentElement();
            return XMLVersArbreSimple((Element) var5.getElementsByTagName("Noeud").item(0));
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public static Arbre generationArbredepuisTexte(String[] var0) {
        generationXMLdepuisTexte(var0, "ArbreAutoGenere.xml");
        return XMLVersArbre("ArbreAutoGenere.xml");
    }

    public static Arbre generationArbredepuisTexte(String var0) {
        generationXMLdepuisTexte(var0, "ArbreAutoGenere.xml");
        return XMLVersArbre("ArbreAutoGenere.xml");
    }

    public static void Affiche(Arbre var0) {
        JCanvas var1 = new JCanvas(var0);
        var1.setPreferredSize(new Dimension(2 ^ (var0.hauteur() - 1) * 150, var0.hauteur() * 100));
        GUIHelper.showOnFrame(var1, "Affichage de l'arbre");
    }
}
