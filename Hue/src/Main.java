import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        HalloJavamitForEach.hallojavamitForEachMethode();
        System.out.println("");
        NumberTester tester = new NumberTester("src/testfile.txt");

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

        tester.testFile();
    }
}