public class Fraction {
    // instance variables (attributes, fields)
    private int numerator, denominator;

    // constructors
    public Fraction() { // default constructor
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int n, int d) { // parameterized constructor
        numerator = n;
        setDenom(d);
    }

    public Fraction(String s) { // "100/3" style
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals("/")) {
                numerator = Integer.parseInt(s.substring(0, i).trim());
                setDenom(Integer.parseInt(s.substring(i + 1).trim()));
            }
        }
    }

    public Fraction(Fraction f) { // copy constructor
        numerator = f.getNum();
        denominator = f.getDenom();
    }

    // accessors
    public int getNum() {
        return numerator;
    }

    public int getDenom() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    // mutators
    public void setNum(int n) {
        numerator = n;
    }

    public void setDenom(int d) {
        if (d != 0) {
            denominator = d;
        } else {
            denominator = 1;
            System.out.println("Error: denominator cannot be zero");
        }
    }

    public void reduce() {
        if (numerator == 0) {       // 0/anything is just 0/1
            denominator = 1;
            return;
        }
        int g = gcf(numerator, denominator);
        numerator = numerator / g;
        denominator = denominator / g;
        if (denominator < 0) {      // keep the minus sign on top
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // static methods
    public static Fraction multiply(Fraction a, Fraction b) {
        int n = a.getNum() * b.getNum();
        int d = a.getDenom() * b.getDenom();
        Fraction ans = new Fraction(n, d);
        ans.reduce();
        return ans;
    }

    public static Fraction divide(Fraction a, Fraction b) {
        Fraction flipped = new Fraction(b.getDenom(), b.getNum());
        return multiply(a, flipped);
    }

    public static Fraction add(Fraction a, Fraction b) {
        int n = a.getNum() * b.getDenom() + b.getNum() * a.getDenom();
        int d = a.getDenom() * b.getDenom();
        Fraction ans = new Fraction(n, d);
        ans.reduce();
        return ans;
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        int n = a.getNum() * b.getDenom() - b.getNum() * a.getDenom();
        int d = a.getDenom() * b.getDenom();
        Fraction ans = new Fraction(n, d);
        ans.reduce();
        return ans;
    }

    // helper method (Euclid's algorithm)
    private static int gcf(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
