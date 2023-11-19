import java.util.Vector;


import java.awt.*;
import javax.swing.* ;
import java.awt.event.* ;
import java.util.Vector;

public class PolygoneColore extends Polygone{
    private Color color;

    public PolygoneColore(){}

    PolygoneColore(Vector<Point> points){
        super(points);
    }
    PolygoneColore(Point[] points){
        super(points);
    }
    PolygoneColore(Point[] points,Color color){
        super(points);
        this.color = color;
    }

    public void colorerObjet(Graphics g){
		g.setColor(this.color);
	}

}
