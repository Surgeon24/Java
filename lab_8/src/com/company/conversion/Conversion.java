package com.company.conversion;
import javax.swing.*;
import java.util.*;

public class Conversion {
    public String conversion(String input){
        return getRpn(input);
    }



    public static String getRpn(String formula) {
        char[] sequenceList  = formula.toCharArray();
        //StringBuilder to store the return value
        StringBuilder resultBuilder = new StringBuilder(sequenceList.length);
        Deque<Character> stack = new ArrayDeque<>();
        int counter = -1;

        //Continue looping until you convert all formulas to Reverse Polish Notation
        for(char token : sequenceList){
            counter +=1;
            switch (token) {
                case '+':
                case '-':
                    //If the priority of the stacked operator is lower, the stack operator is buffered.
                    while (!stack.isEmpty()) {
                        char c = stack.getFirst();
                        if (c == '*' || c == '/') {
                            resultBuilder.append(stack.removeFirst());
                            resultBuilder.append(" ");
                        } else {
                            break;
                        }
                    }
                    stack.addFirst(token);
                    break;
                case '*':
                    if (stack.isEmpty()){
                        stack.addFirst(token);
                        break;
                    }
                    while (stack.getFirst() == '/'){
                        resultBuilder.append(stack.removeFirst());
                        resultBuilder.append(" ");
                        if (stack.isEmpty()){
                            break;
                        }
                    }
                    stack.addFirst(token);
                    break;
                case '/':
                    if (stack.isEmpty()){
                        stack.addFirst(token);
                        break;
                    }
                    while (stack.getFirst() == '*'){
                        resultBuilder.append(stack.removeFirst());
                        resultBuilder.append(" ");
                        if (stack.isEmpty()){
                            break;
                        }
                    }
                    stack.addFirst(token);
                    break;
                case '(':
                    stack.addFirst(token);
                    break;
                case ')':
                    try {
                        while (true) {
                            if (stack.isEmpty()) {
                                throw new NumberFormatException();
                            }
                            else if (stack.getFirst() != '(') {
                                resultBuilder.append(stack.removeFirst());
                                resultBuilder.append(" ");
                            }
                            else if (stack.getFirst() == '(') {
                                stack.removeFirst();
                                break;
                            }
                        }
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Wrong input line. Extra closing bracket.");

                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.':
                    try{
                        if (token == '.') {
                            if (resultBuilder.isEmpty())
                                throw new IllegalArgumentException();
                            else if (resultBuilder.charAt(resultBuilder.length()-1) < '0' || resultBuilder.charAt(resultBuilder.length()-1) > '9')
                                throw new IllegalArgumentException();
                        }
                        resultBuilder.append(token);
                        if (sequenceList.length > counter+1) {
                            if ((sequenceList[counter + 1] < '0' || sequenceList[counter + 1] > '9') && sequenceList[counter + 1] != '.') {
                                resultBuilder.append(" ");
                            }
                        }
                    }catch(IllegalArgumentException ex){
                        JOptionPane.showMessageDialog(null, "Incorrect use of dot!");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Incorrect symbol!");
                    return "0";
            }
        }

        while (!stack.isEmpty()) {
            resultBuilder.append(stack.removeFirst());
            resultBuilder.append(" ");
        }
        return resultBuilder.toString();
    }
}