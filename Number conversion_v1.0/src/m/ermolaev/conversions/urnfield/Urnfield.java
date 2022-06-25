package m.ermolaev.conversions.urnfield;

import m.ermolaev.conversions.GenericNumeralSystem;

public class Urnfield implements GenericNumeralSystem {
    @Override
    public String fromArabic(int val) {
        String r_out = "";
        while(val >= 5){
            val -= 5;
            r_out += "\\";
        }
        while(val > 0){
            val --;
            r_out += "/";
        }
        String out = new StringBuilder(r_out).reverse().toString();
        return out;
    }

    @Override
    public int toArabic(String val) {
        int out = 0;
        char currC;
        String currS;
        if (val.equals(""))
            return 0;

        currC = val.charAt(0);
        while(Character.compare(currC,'/') == 0){
            out ++;
            if (val.equals("/"))
                break;
            val = val.substring(1);
            currC = val.charAt(0);
        }
        while(Character.compare(currC,'\\') == 0){
            out += 5;
            if (val.equals("\\"))
                break;
            val = val.substring(1);
            currC = val.charAt(0);
        }
        if (Character.compare(currC,'\\') != 0 && Character.compare(currC,'/') != 0){
            System.out.print("Wrong symbol: " + currC + "\n");
                return 0;
        }
        return out;
    }
}
