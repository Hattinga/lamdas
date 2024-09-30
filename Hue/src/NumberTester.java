import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberTester {
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
    private String fileName;

    public NumberTester(String fileName) {
        this.fileName = fileName;
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }


    public void testFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int lines = Integer.parseInt(reader.readLine());
            for (int i = 0; i < lines; i++) {
                String[] line = reader.readLine().split(" ");
                int number = Integer.parseInt(line[1]);
                switch (line[0]) {
                    case "1":
                        System.out.println(oddTester.testNumber(number) ? "ODD" : "EVEN");
                        break;
                    case "2":
                        System.out.println(primeTester.testNumber(number) ? "PRIME" : "NO PRIME");
                        break;
                    case "3":
                        System.out.println(palindromeTester.testNumber(number) ? "PALINDROME" : "NO PALINDROME");
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}