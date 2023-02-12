import java.util.Scanner;

/**
 * version 2018-2019<br>
 * QuadraticFormula will input three real numbered coefficients a, b, c of a
 * quadratic equation in standard form .. ax^2+bx+c=0 .. and then calculate the
 * discriminant and the solutions into variables: discriminant, solution1 and solution2. It will
 * then output the discriminant and both solutions.
 * By Misha Raykhlin
 */

public class QuadraticFormula {
  public static void main(String[] args) {
    Scanner kboard = new Scanner(System.in);
    double a = 0.0, b = 0.0, c = 0.0;
    System.out.println("Welcome to the Quadratic Equation Solver :)\n");
    System.out.println("Consider a quadratic equation in standard form ...  ax\u00B2 + bx + c = 0");
    System.out.print("Please enter coefficient a: ");
    a = kboard.nextDouble();
    System.out.print("Please enter coefficient b: ");
    b = kboard.nextDouble();
    System.out.print("Please enter coefficient c: ");
    c = kboard.nextDouble();
    double discriminant = (b*b)-(4*a*c);
    double solution1 = ((-b + Math.sqrt(discriminant))/(2*a));
    double solution2 = ((-b - Math.sqrt(discriminant))/(2*a));
    System.out.println("The Quadratic equation is ... " + a +"X^2 + " + b + "x + " + c + " = 0 " + "has a discriminant of " + discriminant + " and has solutions " + solution1 + " and " + solution2);
    // YOUR CODE GOES HERE ...
    
    // input coefficients b and c Done
    
    // declare variables discriminant, solution1 and solution2 done
    // and assign them appropriate values (use the quadratic formula) done

    // print the quadratic equation, the discriminant and the solutions
    // as a complete sentence. done
    //math done
    // visit the website to view a sample output done

  }
}