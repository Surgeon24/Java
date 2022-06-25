package com.company;

import com.company.conversion.Solve;
import com.company.conversion.Conversion;



public class Main {
    public static void main(String[] args) {
        double output = solveEquation(args[0]);

        System.out.print("This is a solution in main function:" + output);
    }

    public static double solveEquation(String input){
        System.out.print("equation is: " + input + "\t");
        Solve x = new Solve();
        Conversion z = new Conversion();
        String middle;
        middle = z.conversion(input);
        System.out.print("RPN is: " + middle + "\t");
        double output = x.solve(middle);
        System.out.print("answer is: " + output + "\n");
        return output;
    }
}
