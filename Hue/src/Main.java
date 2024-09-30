import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private Scanner scanner;
    private RationalCalculator rationalCalculator;
    private VectorCalculator vectorCalculator;
    private ComplexCalculator complexCalculator;
    public static void main(String[] args) {
            Main main = new Main();
            main.run();
    }
    public Main() {
        scanner = new Scanner(System.in);
        initializeCalculators();
    }

    private void run() {
        HalloJavamitForEach.hallojavamitForEachMethode();
        System.out.println("");

        NumberTester tester = new NumberTester("src/testfile.txt");
        initializeNumberTester(tester);
        tester.testFile();

        runCalculator();
    }

    private void initializeNumberTester(NumberTester tester) {
        tester.setOddEvenTester(number -> number % 2 != 0);
        tester.setPrimeTester(number -> {
            if (number <= 1) return false;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) return false;
            }
            return true;
        });
        tester.setPalindromeTester(number -> {
            String str = String.valueOf(number);
            return str.equals(new StringBuilder(str).reverse().toString());
        });
    }

    private void initializeCalculators() {
        CalculationOperation add = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() + y.getA());
            result.setB(x.getB() + y.getB());
            return result;
        };

        CalculationOperation subtract = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() - y.getA());
            result.setB(x.getB() - y.getB());
            return result;
        };

        CalculationOperation multiply = (x, y) -> {
            Number result = new Number();
            result.setA(x.getA() * y.getA() - x.getB() * y.getB());
            result.setB(x.getA() * y.getB() + x.getB() * y.getA());
            return result;
        };

        CalculationOperation divide = (x, y) -> {
            Number result = new Number();
            double denominator = y.getA() * y.getA() + y.getB() * y.getB();
            result.setA((x.getA() * y.getA() + x.getB() * y.getB()) / denominator);
            result.setB((x.getB() * y.getA() - x.getA() * y.getB()) / denominator);
            return result;
        };

        rationalCalculator = new RationalCalculator(add, subtract, multiply, divide);
        vectorCalculator = new VectorCalculator(add, subtract, multiply, divide);
        complexCalculator = new ComplexCalculator(add, subtract, multiply, divide);
    }

    private void runCalculator() {
        while (true) {
            int calculatorChoice = chooseCalculator();
            if (calculatorChoice == 4) {
                break;
            }

            Number x = enterNumber("x");
            Number y = enterNumber("y");

            int operationChoice = chooseOperation();
            Number result = performOperation(calculatorChoice, operationChoice, x, y);

            if (result != null) {
                displayResult(result);
            }
        }

        scanner.close();
    }

    private int chooseCalculator() {
        System.out.println("Choose calculator:");
        System.out.println("1 = Rational calculator");
        System.out.println("2 = Vector calculator");
        System.out.println("3 = Complex calculator");
        System.out.println("4 = Exit program");
        return scanner.nextInt();
    }

    private Number enterNumber(String label) {
        System.out.println("Enter number " + label + " a:");
        double a = scanner.nextDouble();
        System.out.println("Enter number " + label + " b:");
        double b = scanner.nextDouble();
        Number number = new Number();
        number.setA(a);
        number.setB(b);
        return number;
    }

    private int chooseOperation() {
        System.out.println("Choose operation:");
        System.out.println("1 = add");
        System.out.println("2 = subtract");
        System.out.println("3 = multiply");
        System.out.println("4 = divide");
        System.out.println("5 = enter numbers again");
        return scanner.nextInt();
    }

    private Number performOperation(int calculatorChoice, int operationChoice, Number x, Number y) {
        AbstractCalculator calculator;
        switch (calculatorChoice) {
            case 1:
                calculator = rationalCalculator;
                break;
            case 2:
                calculator = vectorCalculator;
                break;
            case 3:
                calculator = complexCalculator;
                break;
            default:
                return null;
        }

        switch (operationChoice) {
            case 1:
                return calculator.add(x, y);
            case 2:
                return calculator.subtract(x, y);
            case 3:
                return calculator.multiply(x, y);
            case 4:
                return calculator.divide(x, y);
            case 5:
                return null;
            default:
                return null;
        }
    }

    private void displayResult(Number result) {
        System.out.println("=========================");
        System.out.println("Solution:");
        System.out.println("a = " + result.getA());
        System.out.println("b = " + result.getB());
        System.out.println("=========================");
    }
}