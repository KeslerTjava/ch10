import java.util.Scanner;
public class FractionQuiz {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int correct = 0;
	int total = 0;
	
	System.out.println( " Let the Fraction Quiz Begin. Answers should be in lowest terms. Good luck!");
	while (true) {
	Fraction a = new Fraction();
	Fraction b = new Fraction();
	
	 int pick = (int) (Math.random() * 4);
	 String op;
	 Fraction answer;
	 if (pick == 0) {
		 op = "+";
		 answer = Fraction.add(a,b);
	} else if (pick == 1) {
		op = "-";
		answer = Fraction.subtract(a,b);
	} else if (pick ==2) {
		op = "*";
		answer = Fraction.multiply(a,b);
	} else {
		op = "/";
		answer = Fraction.divide(a,b);
	}
	System.out.println();
	System.out.print(a + " " + op + " " + b + " = ");
	String input = in.nextLine().trim();
	
	if (input.equalsIgnoreCase("quit")) {
		break;
		
	}
	Fraction guess = new Fraction(input);
	total++;
	if (guess.equals(answer)) {
		correct++;
		System.out.println("Correct!");
	} else {
		System.out.println("Wrong, the answer was " + answer);
	}
}
	System.out.println();
	if (total == 0) {
		System.out.println("You didn't answer any question");
	} else {
		Fraction score = new Fraction(correct, total);
		int percent =(int) Math.round(100.0 * correct/ total);
		System.out.println("You answered " + score + " correctly, for a score of " + percent + " percent!");
	}
}
}
