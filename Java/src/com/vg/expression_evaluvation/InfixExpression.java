package com.vg.expression_evaluvation;

import java.util.Stack;

public class InfixExpression {
    public static void main(String[] args) {
        InfixExpression ifx = new InfixExpression();
//        Infix expressions contains the operators in between operands
        String expression = "(100+2)*(10/5)";
        ifx.evaluvateExpression(expression);
    }

    private void evaluvateExpression(String expression) {

        if(expression == null || expression.length() <= 2) {
            return;
        }

        char[] chars = expression.toCharArray();

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i = 0; i<chars.length; i++) {

            if(chars[i] == ' ') {
                continue;
            }
            if(Character.isDigit(chars[i])) {
                StringBuffer sb = new StringBuffer();

                while(Character.isDigit(chars[i])) {
                    sb.append(chars[i++]);
                }
                operands.push(Integer.parseInt(sb.toString()));
                i--;
            }
            else {
                if(chars[i] == '(') {
                    operators.push(chars[i]);
                }
                else if(chars[i] == ')') {
                    while (!operators.empty() && operators.peek() != '(') {
                        Integer result = calculate(operators.pop(), operands.pop(), operands.pop());
                        operands.push(result);
                    }
                    operators.pop();
                }
                else if(chars[i] == '+' || chars[i] == '-' ||
                        chars[i] == '*' || chars[i] == '/') {
                    while (!operators.empty() && (getPrecedence(chars[i]) <= getPrecedence(operators.peek()))) {
                        Integer result = calculate(operators.pop(), operands.pop(), operands.pop());
                        operands.push(result);
                    }
                    operators.push(chars[i]);
                }
            }
        }

        while (!operators.isEmpty()) {
            Integer result = calculate(operators.pop(), operands.pop(), operands.pop());
            operands.push(result);
        }
        System.out.println("Infix Expression result : " + operands.pop());


    }

    private int getPrecedence(char ch) {
        if(ch == '^') {
            return 3;
        }
        else if(ch == '*' || ch == '/') {
            return 2;
        }
        else if(ch == '+' || ch == '-') {
            return 1;
        }
        return 0;
    }

    private Integer calculate(Character op, Integer num2, Integer num1) {
        switch (op) {
            case '+' :
                return num1 + num2;
            case '-' :
                return num1 - num2;
            case '*' :
                return num1 * num2;
            case  '/':
                if(num2 == 0) {
                    throw new ArithmeticException("Divide by zero");
                }
                return (Integer) num1/num2;
            default:
                return 0;
        }
    }
}

