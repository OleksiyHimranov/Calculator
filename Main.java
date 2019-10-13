import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    int numA, numB;
    String a, b;
    String operator;
    String[] latinNum = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    List<String> list = Arrays.asList(latinNum);

    Scanner scanner = new Scanner(System.in);
    Calculator arabCal = new Calculator();
    LatinCalculator latinCal = new LatinCalculator();
    System.out.println("Calculator is running...\nPlease enter numbers with operation, like: 1 + 2 or I + II");

    try {

    a = scanner.next();
    operator = scanner.next();
    b = scanner.next();

    if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
      if (list.contains(a.toUpperCase()) && list.contains(b.toUpperCase())) {
        latinCal.convertInputLatinToArab(a.toUpperCase(), operator, b.toUpperCase());
      } else if (Integer.parseInt(a) >= 0 && Integer.parseInt(a) <= 10 && Integer.parseInt(b) >= 0 && Integer.parseInt(b) <= 10) {

        numA = Integer.parseInt(a);
        numB = Integer.parseInt(b);

        if (operator.equals("+")) {
          int c = arabCal.plus(numA, numB);
          System.out.println(c);
        } else if (operator.equals("-")) {
          int c = arabCal.subtract(numA, numB);
          System.out.println(c);
        } else if (operator.equals("*")) {
          int c = arabCal.multiply(numA, numB);
          System.out.println(c);
        } else if (operator.equals("/")) {
          try {
            int c = arabCal.divide(numA, numB);
            System.out.println(c);
          } catch (ArithmeticException e) {
            System.out.println("No division by zero please");
          }
        }
      }

    } else
      System.out.println("Invalid operator");

    } catch (Exception e) {
      System.out.println("I/O exception");

    }
  }
}
