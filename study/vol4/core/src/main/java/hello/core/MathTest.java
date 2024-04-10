package hello.core;

import java.util.Scanner;

/**
 * Created by jeaha on 11/28/23
 */
public class MathTest {
    
    public static String MathChallenge(String str) {
        // Remove spaces from the input string
        str = str.replaceAll("\\s", "");
        
        // Split the input string into three parts: operand1, operator, operand2
        String[] parts = str.split("[\\+\\-\\*/=]");
        String operand1 = parts[0];
        String operator = str.replaceAll("[^\\+\\-\\*/]", "");
        String operand2 = parts[1];
        
        // Find the missing digit by evaluating the expression
        int result;
        switch (operator) {
            case "+":
                result = Integer.parseInt(operand1) + Integer.parseInt(operand2);
                break;
            case "-":
                result = Integer.parseInt(operand1) - Integer.parseInt(operand2);
                break;
            case "*":
                result = Integer.parseInt(operand1) * Integer.parseInt(operand2);
                break;
            case "/":
                result = Integer.parseInt(operand1) / Integer.parseInt(operand2);
                break;
            default:
                return "Invalid operator";
        }
        
        // Find the x position and calculate the missing digit
        int xPosition = str.indexOf('x');
        int missingDigit;
        if (xPosition < operand1.length()) {
            missingDigit = result - Integer.parseInt(operand1);
        } else if (xPosition < operand1.length() + operator.length()) {
            missingDigit = result - Integer.parseInt(operand2);
        } else {
            return "Invalid input";
        }
        
        return String.valueOf(missingDigit);
    }
    
    public static void main(String[] args) {
        // Example usage
        Scanner s = new Scanner(System.in);
        System.out.print(MathChallenge(s.nextLine()));
    }
}
