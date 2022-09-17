import Exceptions.InvalidFormatException;

import java.util.Scanner;


public class Main extends ConverterCalc {
    static Scanner scanner = new Scanner(System.in);
    static int operand1, operand2;
    static char operation;
    static int result;

    public static void main(String[] args) {
        try {
            System.out.println("Enter the expression [2 + 2] or two Roman numerals from I to X: format [V + V] + Enter");
            String inputUser = scanner.nextLine();
            String resultMath = calc(inputUser);
            System.out.print(resultMath);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidFormatException("Invalid expression format");
        }
    }

    public static String calc(String input) {
        char[] newChar = new char[14];
        try {
            for (int i = 0; i < input.length(); i++) {
                newChar[i] = input.charAt(i);
                if (newChar[i] == '+') {
                    operation = '+';
                }
                if (newChar[i] == '-') {
                    operation = '-';
                }
                if (newChar[i] == '*') {
                    operation = '*';
                }
                if (newChar[i] == '/') {
                    operation = '/';
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidFormatException("Invalid expression format! correct format: [1 + 1] " +
                    "and numbers from 1 to 10 ");
        }

        String under_charString = String.valueOf(newChar);
        String[] symbols = under_charString.split(" ");
        String symbol0 = " ";
        String symbol1 = " ";
        String symbol2 = " ";
        if (symbols.length <= 3) {
            symbol0 = symbols[0];
            symbol1 = symbols[2];
            symbol2 = symbol1.trim();
        } else {
            throw new InvalidFormatException("Invalid format! correct format: [1 + 1] or [I + I]");
        }


        if (!isNumeric(symbol0) & !isNumeric(symbol2)) {
            operand1 = romanToNumber(symbol0);
            operand2 = romanToNumber(symbol2);
            result = Calculator.calculated(operand1, operand2, operation);

            return convertNumToRoman(result);

        } else {
            try {
                operand1 = Integer.parseInt(symbol0);
                operand2 = Integer.parseInt(symbol2);
            } catch (NumberFormatException e) {
                throw new InvalidFormatException("Invalid expression format");
            }
            result = Calculator.calculated(operand1, operand2, operation);

            return String.valueOf(result);
        }
    }
}

