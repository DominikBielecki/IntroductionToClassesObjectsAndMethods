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

                System.out.println(zamianaNaDziesietny(numToDecimalSystem, zJakiegoSystemuLiczba(baseSystem)));

            } else if (choose.equals("B")) {
                System.out.println("Enter a decimal value ");
                numFromDecimalSystem = Integer.parseInt(br.readLine());

                System.out.println("To which system do you want to convert: ");
                targetSystem = Integer.parseInt(br.readLine());

                String wynik2 = zamianaZDziesietnego(naJakiSystem(targetSystem), numFromDecimalSystem);

                System.out.println(wynik2);

            } else if (choose.equals("C")) {

                System.out.println("Enter the value of the first number to sum");
                number1 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikSumy1 = zamianaNaDziesietny(number1, zJakiegoSystemuLiczba(baseSystem));

                System.out.println("Enter the value of the second number to sum");
                number2 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikSumy2 = zamianaNaDziesietny(number2, zJakiegoSystemuLiczba(baseSystem));

                System.out.println("In which system to display the result?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of the addition is: " + zamianaZDziesietnego(naJakiSystem(targetSystem), skladnikSumy1 + skladnikSumy2) +
                        " in the system " + targetSystem);

            } else if (choose.equals("D")) {

                System.out.println("Enter the value of the first number to be subtracted");
                number1 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikRoznicy1 = zamianaNaDziesietny(number1, zJakiegoSystemuLiczba(baseSystem));

                System.out.println("Enter the value of the second number to be subtracted");
                number2 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikRoznicy2 = zamianaNaDziesietny(number2, zJakiegoSystemuLiczba(baseSystem));

                System.out.println("In which system to display the result?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of the subtraction is: " + zamianaZDziesietnego(naJakiSystem(targetSystem), skladnikRoznicy1 - skladnikRoznicy2) +
                        " in the system " + targetSystem);

            } else if (choose.equals("E")) {
                System.out.println("Enter the value of the first number for the multiplication operation");
                number1 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikMnozenia1 = zamianaNaDziesietny(number1, zJakiegoSystemuLiczba(baseSystem));

                System.out.println("Enter the value of the second number for the multiplication operation");
                number2 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikMnozenia2 = zamianaNaDziesietny(number2, zJakiegoSystemuLiczba(baseSystem));

                System.out.println("In which system to display the result?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of the multiplication is: " + zamianaZDziesietnego(naJakiSystem(targetSystem), skladnikMnozenia1 * skladnikMnozenia2) +
                        " in the system " + targetSystem);

            } else if (choose.equals("F")) {
                System.out.println("Enter the value of the first number for the division operation");
                number1 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikDzielenia1 = zamianaNaDziesietny(number1, zJakiegoSystemuLiczba(baseSystem));

                System.out.println("Enter the value of the second number for the division operation");
                number2 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int skladnikDzielenia2 = zamianaNaDziesietny(number2, zJakiegoSystemuLiczba(baseSystem));

                System.out.println("In which system to display the result?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of the division is: " + zamianaZDziesietnego(naJakiSystem(targetSystem), skladnikDzielenia1 / skladnikDzielenia2) +
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
    static String zamianaZDziesietnego(int systemDocelowy, int inputNum) {
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

    static int zJakiegoSystemuLiczba(int systemZrodlowy) {
        switch (systemZrodlowy) {
            case 2:
                systemZrodlowy = 2;
                break;
            case 3:
                systemZrodlowy = 3;
                break;
            case 4:
                systemZrodlowy = 4;
                break;
            case 5:
                systemZrodlowy = 5;
                break;
            case 6:
                systemZrodlowy = 6;
                break;
            case 7:
                systemZrodlowy = 7;
                break;
            case 8:
                systemZrodlowy = 8;
                break;
            case 9:
                systemZrodlowy = 9;
                break;
            case 10:
                systemZrodlowy = 10;
                break;
            case 16:
                systemZrodlowy = 16;
                break;
            default:
                systemZrodlowy = 2;
                break;
        }
        return systemZrodlowy;
    }

    static int naJakiSystem(int systemDocelowy) {
        switch (systemDocelowy) {
            case 2:
                systemDocelowy = 2;
                break;
            case 3:
                systemDocelowy = 3;
                break;
            case 4:
                systemDocelowy = 4;
                break;
            case 5:
                systemDocelowy = 5;
                break;
            case 6:
                systemDocelowy = 6;
                break;
            case 7:
                systemDocelowy = 7;
                break;
            case 8:
                systemDocelowy = 8;
                break;
            case 9:
                systemDocelowy = 9;
                break;
            case 10:
                systemDocelowy = 10;
                break;
            case 16:
                systemDocelowy = 16;
                break;
            default:
                systemDocelowy = 2;
                break;
        }
        return systemDocelowy;
    }
}
