import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.println("1.Enter the base of your number (2, 8 ,10 or 16): ");
        System.out.println("2.Enter a decimal number and enter a new base from base 1 to 64 to convert to: ");
        System.out.println("Type in either 1 or 2 to indicate your choice");
        Scanner o = new Scanner(System.in);
        String option = o.nextLine();
        while(!(option.equals("1") || option.equals("2")) ){
            System.out.println("Type in 1 or 2 only!");
           option= o.nextLine();
        }
        if(option.equals("1")) {
            System.out.println("1.Enter the base of your number (2, 8 ,10 or 16): ");
            Scanner s = new Scanner(System.in);
            String choice = s.nextLine();
            NumberConverter testBase = new NumberConverter(0, 2);
            while (!testBase.checkBase(choice)) {
                System.out.println("Please Enter a Valid Base:");
                choice = s.nextLine();
            }
            int base = Integer.parseInt(choice);
            NumberConverter testNum = new NumberConverter(0, base);
            System.out.print("Enter your number : ");
            String number = s.nextLine();
            if(base != 16) {
                while (!testNum.checkValue(number)) {
                    System.out.println("Incorrect Number Input!");
                    number = s.nextLine();
                }
            } else {
                NumberConverter testHexNum = new NumberConverter(number,base);
               for(int i = 0; i<number.length() ; i++) {
                   String hexList = "123456789ABCDEF";
                   if(!hexList.contains(number.substring(i,i+1))) {
                       System.out.println("Incorrect Number Input!");
                       number = s.nextLine();
                   }
                }
            }
            NumberConverter ncForHex = new NumberConverter(number, base);
            if (ncForHex.getBase() == 16) {
                ncForHex.convert();
            } else {
                int n = Integer.parseInt(number);
                NumberConverter nc = new NumberConverter(n, base);
                nc.convert();
            }
            s.close();
        } else{
            System.out.println("Enter a decimal Number:");
            Scanner d = new Scanner(System.in);
            int decimal = d.nextInt();
            System.out.println("Enter a base between 1-64");
            int base = d.nextInt();
            NumberConverter test = new NumberConverter(0,0);
            while(!test.check64Base(base)){
                System.out.println("The base is out of range!");
                base = d.nextInt();
            }
            NumberConverter decimalNumber = new NumberConverter(decimal, base);
            System.out.println("Original Number: " + decimal);
            System.out.println("Converted to Base " + base);
            System.out.println(decimal + " in base " + base + " is: " + decimalNumber.convertToBase());
        }

    }
}
