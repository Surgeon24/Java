package m.ermolaev.conversions.roman;

import m.ermolaev.conversions.GenericNumeralSystem;

import java.util.TreeMap;
import java.util.Locale;

public class Roman implements GenericNumeralSystem {
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    @Override
    public String fromArabic(int val) {
        int l =  map.floorKey(val);
        if ( val == l ) {
            return map.get(val);
        }
        return map.get(l) + fromArabic(val-l);
    }



    @Override
    public int toArabic(String val) {
        int result = 0, previous = 0;
        char temp;
        val = val.toUpperCase(Locale.ROOT);

        if(!validateNumber(val))
            throw new UnsupportedOperationException();

        for (int i = val.length() - 1; i >= 0; i--) {
            temp = val.charAt(i);
            switch (temp) {
                case 'M':
                    result = specifyNumber(1000, previous, result);
                    previous = 1000;
                    break;
                case 'D':
                    result = specifyNumber(500, previous, result);
                    previous = 500;
                    break;
                case 'C':
                    result = specifyNumber(100, previous, result);
                    previous = 100;
                    break;
                case 'L':
                    result = specifyNumber(50, previous, result);
                    previous = 50;
                    break;
                case 'X':
                    result = specifyNumber(10, previous, result);
                    previous = 10;
                    break;
                case 'V':
                    result = specifyNumber(5, previous, result);
                    previous = 5;
                    break;
                case 'I':
                    result = specifyNumber(1, previous, result);
                    previous = 1;
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }
        return result;
    }

    private int specifyNumber(int number, int previous, int result) {
        if (previous > number) {
            return result - number;
        } else {
            return  result + number;
        }
    }

    private boolean validateNumber(String val) {
        return val.matches(
                "M{0,3}" + "(CM|CD|D?C{0,3})" + "(XC|XL|L?X{0,3})" + "(IX|IV|V?I{0,3})");
    }

}
