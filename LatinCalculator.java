public class LatinCalculator extends Calculator {
  String[] latinNum = {"NULL", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
  String[] latinNumDec = {"NULL", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
  int a, b, c;

  public void convertInputLatinToArab(String latinNumA, String operator, String latinNumB) {
    for (int i = 0; i < latinNum.length; i++) {
      if (latinNumA.equals(latinNum[i])) {
        a = i;
      }
      if (latinNumB.equals(latinNum[i])) {
        b = i;
      }
    }
    if (operator.equals("+")) {
      c = plus(a, b);
      convertAndOutput(c);
    } else if (operator.equals("-")) {
      c = subtract(a, b);
      convertAndOutput(c);
    } else if (operator.equals("*")) {
      c = multiply(a, b);
      convertAndOutput(c);
    } else if (operator.equals("/")) {
      try {
        c = divide(a, b);
        convertAndOutput(c);
      } catch (ArithmeticException e) {
        System.out.println("No division by zero please");
      }

    }
  }

  public void convertAndOutput(int c) {
    if(c <= 0){
      System.out.println("There are no negative numbers in Latin numeric");
    } else if (c < 10 && c > 0) {
      System.out.println(latinNum[c]);
    } else if (c == 10) {
      System.out.println(latinNum[(c)]);
    }else if (c > 10 && c % 10 == 0) {
      System.out.println(latinNumDec[(c / 10)]);
    } else {
      System.out.println(latinNumDec[(c / 10)] + latinNum[c % 10]);
    }

  }
}

