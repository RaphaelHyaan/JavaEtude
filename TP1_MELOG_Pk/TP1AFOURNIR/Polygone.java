import java.util.Vector;
import java.awt.*;

public class Polygone extends ObjetGraphique {
    protected Vector<Point> vectP;

    public Polygone(){}

    public Polygone(Vector<Point> points){
        vectP = new Vector<Point>(points);
    }

    public Polygone(Point[] points){
        vectP = new Vector<Point>();
        for (Point p : points){
            Point np = new Point(p);
            vectP.add(np);
        }
    }

    public void translater(int a, int b){
        for (Point p : vectP) {
			p.translater(a,b);
		}
    }

    public void ajouterPoint(Point point, int index){
        vectP.insertElementAt(point, index);
    }

    public void dessinerObjet(Graphics g){
        for(int i = 0;i<vectP.size()-1;i++){
            ligne(g,vectP.get(i).getX(),vectP.get(i).getY(),vectP.get(i+1).getX(),vectP.get(i+1).getY());
        }
        ligne(g, vectP.firstElement().getX(),vectP.firstElement().getY(),vectP.lastElement().getX(),vectP.lastElement().getY());
    }

}
