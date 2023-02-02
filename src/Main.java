import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        NumberConverter hex = new NumberConverter("7F1");
        System.out.println(7/2);
        System.out.println(3/2);
        System.out.println(1/2);
        System.out.println(hex.hexToBinary());
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        NumberConverter test = new NumberConverter(0,2);
        while(!test.checkBase(choice)){
            System.out.println("Please Enter a Valid Base:");
            choice = s.nextLine();
        }
       int base = Integer.parseInt(choice);

        NumberConverter test2 = new NumberConverter(0,base);
        System.out.print("Enter your number: ");
        String number = s.nextLine();
        while(!test2.checkValue(number)){
            System.out.println("Incorrect Number Input!");
            number = s.nextLine();
        }
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        nc.convert();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
    }
}

