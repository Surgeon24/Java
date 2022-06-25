package m.ermolaev.exchange;


import m.ermolaev.currency.ICurrency;

//interfejs exchenge
public class Exchange implements IExchange{
    @Override
    public double exchange(ICurrency src, ICurrency tgt, double amt){
        double src_r = src.getRate();
        double tgt_r = tgt.getRate();
        return amt * src_r / tgt_r;
    }
}
