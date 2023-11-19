

public class Point {
	protected int x;
	protected int y;
	
	public Point(int a,int b) {
        this.x = a;
        this.y = b;
	}
	
	public Point(Point point2) {
        this.x = point2.getCoordennees()[0];
        this.y = point2.getCoordennees()[1];
	}

    public int[] getCoordennees(){
        int[] coordonnées = {this.x,this.y};
        return coordonnées;
    }
	
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
	
	public void translater(int a,int b) {
        this.x += a;
        this.y += b;
	}
	public Point translaterP(int a,int b) {
		Point newPoint = new Point(a,b);
		return newPoint;
	}
	public String toString() {
		return("abscisse : "+x+", ordonnée : "+y);
		// La méthode toString() est définie dans la classe Object dont toute classe java hérite
		// elle est redéfinie ici pour renvoyer une chaîne de caractères qui décrit bien l'objet.
	}
}
		
	
	
