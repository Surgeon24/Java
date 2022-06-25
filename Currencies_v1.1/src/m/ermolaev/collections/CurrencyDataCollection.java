package m.ermolaev.collections;
import m.ermolaev.currency.Currency;
import m.ermolaev.currency.ICurrency;

import java.util.ArrayList;
import java.util.List;

//implementacja interfejsu IDataCollection

public class CurrencyDataCollection implements IDataCollection{
    List<ICurrency> list = new ArrayList();
    Currency currency;

    public CurrencyDataCollection() {
        list = new ArrayList<>();
    }

    public String ToString(){
        System.out.print("Test\n");
        String out = "";
        ICurrency tmp;
        for(int i=0;i<list.size();i++){
            tmp=list.get(i);
            int length = tmp.getName().length();
            String space = " ";
            for (int j = 0; j < 40 - length; j++){
                space += " ";
            }
            out = out + tmp.getName() + space + "(" + tmp.getCode() + ")  " + tmp.getFactor() + " \t\t" + tmp.getRate() + "\n";
        }
        return out;
    }


    public List<ICurrency> getCurrencyList(){
        return this.list;
    }
    public ICurrency getCurrencyByCode(ICurrency currency){
        return this.list.get(this.list.indexOf(currency));
    }
}
