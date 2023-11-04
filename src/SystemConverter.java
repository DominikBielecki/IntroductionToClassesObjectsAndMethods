import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemConverter {
    public static void main(String[] args) throws IOException {
        int baseSystem, targetSystem, numFromDecimalSystem;
        String numToDecimalSystem, number1, number2, choose;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println(" ");
            System.out.println("-------------------------------------------------------");
            System.out.println("Choose what operation you want to perform:");
            System.out.println(" ");
            System.out.println("A. Convert from any system to the decimal system");
            System.out.println("B. Convert from decimal system to another system");
            System.out.println("C. Summing up numbers from different systems");
            System.out.println("D. Subtracting numbers from different systems");
            System.out.println("E. Multiplying numbers from different systems");
            System.out.println("F. Dividing numbers from different systems");
            System.out.println(" ");
            System.out.println("W. Exit the program");

            choose = br.readLine();

            if (choose.equals("A")) {
                System.out.println("Enter the value you want to convert to the decimal system: ");
                numToDecimalSystem = br.readLine();

                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());

                System.out.println(zamianaNaDziesietny(numToDecimalSystem, fromWhichSystem(baseSystem)));

            } else if (choose.equals("B")) {
                System.out.println("Enter a decimal value ");
                numFromDecimalSystem = Integer.parseInt(br.readLine());

                System.out.println("To which system do you want to convert: ");
                targetSystem = Integer.parseInt(br.readLine());

                String wynik2 = changeFromDecimal(toWhichSystem(targetSystem), numFromDecimalSystem);

                System.out.println(wynik2);

            } else if (choose.equals("C")) {

                System.out.println("Enter the value of the first number to sum");
                number1 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikSumy1 = zamianaNaDziesietny(number1, fromWhichSystem(baseSystem));

                System.out.println("Enter the value of the second number to sum");
                number2 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikSumy2 = zamianaNaDziesietny(number2, fromWhichSystem(baseSystem));

                System.out.println("In which system to display the result?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of the addition is: " + changeFromDecimal(toWhichSystem(targetSystem), skladnikSumy1 + skladnikSumy2) +
                        " in the system " + targetSystem);

            } else if (choose.equals("D")) {

                System.out.println("Enter the value of the first number to be subtracted");
                number1 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikRoznicy1 = zamianaNaDziesietny(number1, fromWhichSystem(baseSystem));

                System.out.println("Enter the value of the second number to be subtracted");
                number2 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikRoznicy2 = zamianaNaDziesietny(number2, fromWhichSystem(baseSystem));

                System.out.println("In which system to display the result?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of the subtraction is: " + changeFromDecimal(toWhichSystem(targetSystem), skladnikRoznicy1 - skladnikRoznicy2) +
                        " in the system " + targetSystem);

            } else if (choose.equals("E")) {
                System.out.println("Enter the value of the first number for the multiplication operation");
                number1 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikMnozenia1 = zamianaNaDziesietny(number1, fromWhichSystem(baseSystem));

                System.out.println("Enter the value of the second number for the multiplication operation");
                number2 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikMnozenia2 = zamianaNaDziesietny(number2, fromWhichSystem(baseSystem));

                System.out.println("In which system to display the result?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of the multiplication is: " + changeFromDecimal(toWhichSystem(targetSystem), skladnikMnozenia1 * skladnikMnozenia2) +
                        " in the system " + targetSystem);

            } else if (choose.equals("F")) {
                System.out.println("Enter the value of the first number for the division operation");
                number1 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikDzielenia1 = zamianaNaDziesietny(number1, fromWhichSystem(baseSystem));

                System.out.println("Enter the value of the second number for the division operation");
                number2 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikDzielenia2 = zamianaNaDziesietny(number2, fromWhichSystem(baseSystem));

                System.out.println("In which system to display the result?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of the division is: " + changeFromDecimal(toWhichSystem(targetSystem), skladnikDzielenia1 / skladnikDzielenia2) +
                        " in the system " + targetSystem);
            }

        } while (!choose.equals("W"));

    }

    static int val(char c) {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }

    public static int zamianaNaDziesietny(String str, int sysZrodlowy) {

        int len = str.length();
        int power = 1; // Initialize
        // power of base
        int num = 0; // Initialize result
        int i;

        // Decimal equivalent is
        // str[len-1]*1 + str[len-2] *
        // base + str[len-3]*(base^2) + ...
        for (i = len - 1; i >= 0; i--) {
            // A digit in input number
            // must be less than
            // number's base
            if (val(str.charAt(i)) >= sysZrodlowy) {
                System.out.println("Wrong number");
                return -1;
            }

            num += val(str.charAt(i)) * power;
            power = power * sysZrodlowy;
        }

        return num;
    }

    static char reVal(int num) {
        if (num >= 0 && num <= 9)
            return (char) (num + 48);
        else
            return (char) (num - 10 + 65);
    }

    // Function to convert a given decimal number
// to a base 'base' and
    static String changeFromDecimal(int systemDocelowy, int inputNum) {
        String s = "";

//        Convert the given number and the given system (base),
//            by continuously dividing a number with "base" and using the remainder of the division.

        while (inputNum > 0) {
            s += reVal(inputNum % systemDocelowy);
            inputNum /= systemDocelowy;
        }
        StringBuilder ix = new StringBuilder();

        // append a string into StringBuilder input1
        ix.append(s);

        // Reverse the result
        return new String(ix.reverse());
    }

    static int fromWhichSystem(int sourceSystem) {
        switch (sourceSystem) {
            case 2:
                sourceSystem = 2;
                break;
            case 3:
                sourceSystem = 3;
                break;
            case 4:
                sourceSystem = 4;
                break;
            case 5:
                sourceSystem = 5;
                break;
            case 6:
                sourceSystem = 6;
                break;
            case 7:
                sourceSystem = 7;
                break;
            case 8:
                sourceSystem = 8;
                break;
            case 9:
                sourceSystem = 9;
                break;
            case 10:
                sourceSystem = 10;
                break;
            case 16:
                sourceSystem = 16;
                break;
            default:
                sourceSystem = 2;
                break;
        }
        return sourceSystem;
    }

    static int toWhichSystem(int directedSystem) {
        switch (directedSystem) {
            case 2:
                directedSystem = 2;
                break;
            case 3:
                directedSystem = 3;
                break;
            case 4:
                directedSystem = 4;
                break;
            case 5:
                directedSystem = 5;
                break;
            case 6:
                directedSystem = 6;
                break;
            case 7:
                directedSystem = 7;
                break;
            case 8:
                directedSystem = 8;
                break;
            case 9:
                directedSystem = 9;
                break;
            case 10:
                directedSystem = 10;
                break;
            case 16:
                directedSystem = 16;
                break;
            default:
                directedSystem = 2;
                break;
        }
        return directedSystem;
    }
}
