
import java.util.Vector;
import java.awt.*;

public class RectangleColore extends PolygoneColore{
    private Color color;
    RectangleColore(Vector <Point> points){
        super(points);
    }
    RectangleColore(Point[] points){
        super(points);
    }
    RectangleColore(Point[] points,Color color){
        super(points);
        this.color = color;
    }
    RectangleColore(Point pointLU,Point pointRD,Color color){
        Point pointRU = new Point(pointRD.getX(), pointLU.getY());
        Point pointLD = new Point(pointLU.getX(), pointRD.getY());
        Point[] points = {pointLU,pointRU,pointRD,pointLD};
        vectP = new Vector<Point>();
        for (Point p : points){
            Point np = new Point(p);
            vectP.add(np);
        }
        this.color = color;
    }

    public void colorerObjet(Graphics g){
		g.setColor(this.color);
	}
}
