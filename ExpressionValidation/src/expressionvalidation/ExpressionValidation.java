/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressionvalidation;

import java.util.*;

/**
 *
 *   Author Meyer Evenblij
 *   15/10/19
 *   Validates the expression which in this case is parenthesis input by user.
 *   Balancing the parenthesis.
 * 
 */
public class ExpressionValidation {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Welcome to the exression validating program\n");
        //  Requires the user to input expression
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("Enter your expression: ");
        String b = scannerObject.nextLine();
        System.out.println(b);
        //  Asks user for the starting character
        System.out.println("Enter your opening character to validate: ");
        char open = scannerObject.next().charAt(0);
        System.out.println(open);
        //  Asks user for the closing character
        System.out.println("Enter your closing character to validate: ");
        char close = scannerObject.next().charAt(0);
        System.out.println(close);
        //  using ParenthesisValidation class it creates a new variable allowing output
        ParenthesisValidation v = new ParenthesisValidation();
        System.out.println("The expression is: " + v.validation(b, open, close));
    }
    
}

