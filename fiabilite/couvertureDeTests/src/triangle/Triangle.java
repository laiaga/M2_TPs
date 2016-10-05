package triangle;

import com.google.common.base.Preconditions;

public class Triangle {
	private static double PRECISION = 0.001;
	
	private enum TypeCotes {
		SCALENE,ISOCELE,EQUILATERAL
	}
	private enum TypeAngles {
		ACUTANGLE, OBTUSANGLE, RECTANGLE
	}
	
	private double a,b,c;
	private double alpha, beta, gamma;
	
	public Triangle (double a, double b, double c) {
		Preconditions.checkArgument(a>0, "Side A must be of length > 0 but is of length %s", a);
		Preconditions.checkArgument(b>0, "Side B must be of length > 0 but is of length %s", b);
		Preconditions.checkArgument(c>0, "Side C must be of length > 0 but is of length %s", c);
		this.a = a;
		this.b = b;
		this.c = c;
		
		//Calcul des angles grace aux forumes alpha = arccos((b²+c²-a²)/(2bc)) etc 
		//alpha est l'angle opposé au côté de longueur a etc
		//pour passer de l'angle r en radian a d en degres :
		//d = r * 180 / pi
		this.alpha = Math.acos ((b*b + c*c - a*a)/(2*b*c))*180/Math.PI;
		this.beta = Math.acos ((a*a + c*c - b*b)/(2*a*c))*180/Math.PI;
		this.gamma = Math.acos ((a*a + b*b - c*c)/(2*a*b))*180/Math.PI;
		
		Preconditions.checkState(strictlyInferior(alpha, 180) && strictlySuperior(alpha, 0),
				"Angle alpha must be neither straight nor null ; he is %s°. Check the fasability of your triangle.",
				alpha);
		Preconditions.checkState(strictlyInferior(alpha, 180) && strictlySuperior(alpha, 0),
				"Angle beta must be neither straight nor null ; he is %s°. Check the fasability of your triangle.",
				beta);
		Preconditions.checkState(strictlyInferior(alpha, 180) && strictlySuperior(alpha, 0),
				"Angle gamma must be neither straight nor null ; he is %s°. Check the fasability of your triangle.",
				gamma);
	}
	
	public int type () {	
		int type = -1;
		
		switch (this.computeTypeCotes()) {
		case SCALENE :
			switch (this.computeTypeAngles()) {
			case ACUTANGLE:
				type = 0;
				break;
			case OBTUSANGLE:
				type = 1;
				break;
			case RECTANGLE:
				type = 2;
				break;
			default:
				break;
			
			}
			break;
		case ISOCELE:
			switch (this.computeTypeAngles()) {
			case ACUTANGLE:
				type = 3;
				break;
			case OBTUSANGLE:
				type = 4;
				break;
			case RECTANGLE:
				type = 5;
				break;
			default:
				break;
			
			}
			break;
		case EQUILATERAL:
			type = 6;
			break;
		default:
			break; 
		}
		
		return type;
	}
	
	private TypeCotes computeTypeCotes () {
		if (equal(a,b) && equal(b,c)) {
			return TypeCotes.EQUILATERAL;
		} else if (equal(a,b) || equal(b,c) || equal(a,c)) {
			return TypeCotes.ISOCELE;
		} else {
			return TypeCotes.SCALENE;
		}
	}
	
	private TypeAngles computeTypeAngles () {
		if (strictlySuperior(alpha, 90) || strictlySuperior(beta, 90) || strictlySuperior(gamma, 90)) {
			return TypeAngles.OBTUSANGLE;
		} else if (equal(alpha,90) || equal(beta,90) || equal(gamma,90)) {
			return TypeAngles.RECTANGLE;
		} else {
			return TypeAngles.ACUTANGLE;
		}
	}
	
	private static boolean equal(double d1, double d2) {
		return d1<d2+PRECISION && d1>d2-PRECISION;
	}
	
	private static boolean strictlySuperior(double d1, double d2) {
		return d1>d2+PRECISION;
	}
	
	private static boolean strictlyInferior(double d1, double d2) {
		return d1<d2+PRECISION;
	}
}
