public class FractionDriver {
    public static void main(String[] args) {
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction(100, 101);
        Fraction f3 = new Fraction("1/2");
        Fraction f4 = new Fraction(f3);          

        System.out.println(f1);                 
        System.out.println(f2 + " = " + f2.toDouble());
        System.out.println(f4);                 

        Fraction bad = new Fraction(3, 0);       
        System.out.println(bad);

        Fraction r = new Fraction(252, 105);
        r.reduce();
        System.out.println(r);                   

        Fraction half = new Fraction(1, 2);
        Fraction third = new Fraction(1, 3);
        System.out.println(Fraction.multiply(half, third)); 
        System.out.println(Fraction.divide(half, third));   
        System.out.println(Fraction.add(half, third));     
        System.out.println(Fraction.subtract(half, third)); 
    }
}
