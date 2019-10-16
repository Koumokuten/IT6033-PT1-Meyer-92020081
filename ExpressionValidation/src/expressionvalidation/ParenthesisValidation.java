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
 *   Holds the main function of the ExpressionValidation program
 */
public class ParenthesisValidation {

    //  The validation method linking the expression validation
    public static boolean validation(String b, char open, char close) {
        //  Sets the result to "true"
        boolean result = true;
        //  Creates the Stack storing the information
        Stack<Character> stack = new Stack<>();
        char current;
        //  A "for" loop which compares the string and initiates the loop
        for(int i = 0; i < b.length(); i++) {
            current = b.charAt(i);
            if(current == open ) {
                stack.push(current);
            } else if(current == close) {
                if(stack.isEmpty()) {
                    result = false;
                    return result;
                // Removes the element from the Stack
                } else if(current == close){
                    stack.pop();
                }
            }
        }
        // If Stack is not empty returns false
        if(!stack.isEmpty()) {
            result = false;
        }
        return result;
    }
    
    
}