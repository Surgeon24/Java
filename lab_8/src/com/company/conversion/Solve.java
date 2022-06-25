package com.company.conversion;

import com.company.Main;

import java.util.Stack;

public class Solve {
    int Poz = 0;
    public double solve(String ONP) {
        Stack<Double> stos = new Stack<Double>();
        double a, b, tmp;
        //analizujemy wszystkie znaki, aby wyłuskać liczby i operatory
        while (Poz < ONP.length()) {
            if (czy_cyfra(ONP.charAt(Poz))) { //jeśli wykryjesz cyfrę,
                tmp = str_to_double(ONP, Poz);
                stos.push(tmp); //to zamień ją oraz kolejne na liczbę i wrzuć na stos
                tmp = String.valueOf((int)Math.abs(tmp)).length();

            }
            else if (czy_oper(ONP.charAt(Poz))) //jeśli wykryjesz operator, to wykonaj odpowiednie działanie
            {
                if (stos.size() < 2) //gdy jest za mało liczb na stosie
                {
                    System.err.print("Niepoprawne wyrażenie ONP");
                    return 0;
                }
                a = stos.lastElement();    //pobierz pierwszą liczbę ze stosu
                stos.pop();    //usuń tę liczbę ze stosu
                b = stos.lastElement();    //pobierz drugą liczbę ze stosu
                stos.pop();    //usuń tę liczbę ze stosu
                stos.push(dzialanie(b, a, ONP.charAt(Poz))); //wrzuć na stos wynik działania liczba b operator liczba a
            }
            Poz ++;
        }
        //jeśli ostatecznie na stosie będzie mniej lub więcej niż jeden element
        if (stos.size() != 1) {
            System.err.print("Niepoprawne wyrażenie ONP");
            return 0;
        }
        return stos.lastElement();
    }

    double dzialanie(double a, double b, char oper) {
        switch(oper)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;//dzielenie całkowite
        }
        System.err.print("Podano nieprawidłowy operator");
        return 0;
    }

    //sprawdzam, czy podany znak jest cyfrą
    boolean czy_cyfra(char znak)
    {
        return znak >= '0' && znak <= '9';
    }
    //sprawdzam, czy dany znak jest jednym z czterech operatorów
    boolean czy_oper(char znak)
    {
        return znak == '+' || znak == '-' || znak == '*' || znak == '/';
    }

    double str_to_double(String a, int poz)
    {
        boolean dot = false;
        int number = 0;
        int afterDot = 0;
        while(poz < a.length() && (czy_cyfra(a.charAt(poz)) || a.charAt(poz) == '.')) {
            //schemat Hornera
            if (!dot){
                if (czy_cyfra(a.charAt(poz)))
                    number = number * 10 + a.charAt(poz) - '0';
                else
                    dot = true;
            }
            else
                afterDot = afterDot * 10 + a.charAt(poz) - '0';
            ++poz;
        }
        --poz;
        Poz = poz;
        double out = number;
        out = number * Math.pow(10, String.valueOf(afterDot).length()) + afterDot;
        out /= Math.pow(10, String.valueOf(afterDot).length());
        if (dot)
            return (out);
        return number;
    }
}
