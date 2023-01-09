import java.util.Scanner;
public class NumericConversion
{

    public static void main(String[] arg) {
        boolean inMenu = true;
        int menu;
        String input;

        while (inMenu) {
            System.out.println("Choose an option:");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");
            System.out.println("");
            System.out.println("Please enter an option: ");
            Scanner scnr = new Scanner(System.in);

            menu = scnr.nextInt();


            switch (menu) {
                case 1:
                    System.out.println("Please enter the numeric string to convert: ");
                    input = scnr.next();
                    System.out.println("Result: " + hexStringDecode(input));
                    break;
                case 2:
                    System.out.println("Please enter the numeric string to convert: ");
                    input = scnr.next();
                    System.out.println("Result: " + binaryStringDecode(input));
                    break;
                case 3:
                    System.out.println("Please enter the numeric string to convert: ");
                    input = scnr.next();
                    System.out.println("Result: " + binaryToHex(input));
                    break;
                case 4:
                    inMenu = false;
                    System.out.println("Quitting program");
                    break;
            }
        }
    }

    public static long hexStringDecode(String hex)
    {
        char[] hArray = hex.toCharArray();
        int hLength = hex.length();
        int hStart = hLength - 1;
        long hSum = 0;

        for (int i=hStart; i>=0; i--)
        {
                hSum = (long)(hSum + (hexCharDecode(hArray[i]) * Math.pow(16, hStart - i)));
        }

        return hSum;
    }


    public static short binaryStringDecode(String binary)
    {
        short bSum = 0;
        char[] bArray = binary.toCharArray();
        int bLength = bArray.length;
        int bStart = bLength - 1;

        for (int i=bStart; i>= 0; i--)
        {
            bSum = (short)(bSum + (Math.pow(2, bStart - i)));
        }

        return bSum;
    }


    public static String binaryToHex(String binary)
    {
        int value = (int) binaryStringDecode(binary);
        return Integer.toHexString(value).toUpperCase();
    }

    public static short hexCharDecode(char digit)
    {
        short hDigit;
        if (digit == 'A')
        {
            hDigit = 10;
        }
        else if (digit == 'B')
        {
            hDigit = 11;
        }
        else if (digit == 'C')
        {
            hDigit = 12;
        }
        else if (digit == 'D')
        {
            hDigit = 13;
        }
        else if (digit == 'E')
        {
            hDigit = 14;
        }
        else if (digit == 'F')
        {
            hDigit = 15;
        }
        else
        {
            hDigit  = (short)(Character.getNumericValue(digit));
        }
        return hDigit;
    }
}



