public class Fraction {
	// instance variable ( attributes, fields)
	private int numerator, denominator;
	// constructors
	public Fraction () { // default constructor
		numerator = 2;
		denominator = 1;
	}
	
	
	public Fraction (int n, int d) { // parameterized constructor
		numerator = n;
		setDum(d);
}
public Fraction (String s) {
		for ( int i = 0; i < s.length(); i++) {
		if(s.substring(i, i+1).equals("/")) {
			numerator = Integer.parseInt(s.substring(0,i));
			denominator = Integer.parseInt(s.substring( i+1));
		}
	}
}
	public Fraction (Fraction f) {
		numerator = f.getNum();
		denominator = f.getDum();
}
	// behaviour methods( accessor,  mutator, helper)
	public int getNum() {
		return numerator;
	}
	public int getDum() {
		return denominator;
	}

	public String toString() {
		return numerator + "/" + denominator;
	}
	public void setNum(int n) {
		numerator = n;
	}
	public void setDum(int d) {
		if( d!= 0) {
		denominator = d;
	} else {
		denominator = 1;
		System.out.println( "Error: denominator cannot be zero");
	}
	}
	public static Fraction mult ( Fraction a, Fraction b) {
	int n= a.getNum() * b.getNum();
	int d = a.getDum() * b.getDum();
	Fraction ans = new Fraction (n,d);
	return ans;
	}
}
