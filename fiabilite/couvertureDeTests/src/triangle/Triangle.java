package triangle;

import com.google.common.base.Preconditions;

public class Triangle {
	private double a,b,c;
	
	public Triangle (double a, double b, double c) {
		Preconditions.checkArgument(a>0, "Side A must be of length > 0 but is of length %s", a);
		Preconditions.checkArgument(b>0, "Side B must be of length > 0 but is of length %s", b);
		Preconditions.checkArgument(c>0, "Side C must be of length > 0 but is of length %s", c);
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int type () {
		double alpha, beta, gamma;
		
		//Calcul des angles grace aux forumes alpha = arccos((b²+c²-a²)/(2bc)) etc 
		//alpha est l'angle opposé au côté de longueur a etc
		alpha = Math.acos ((b*b + c*c - a*a)/(2*b*c));
		beta = Math.acos ((a*a + c*c - b*b)/(2*a*c));
		gamma = Math.acos ((a*a + b*b - c*c)/(2*a*b));
		
		return 0;
	}
}
