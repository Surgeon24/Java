package m.ermolaev;

import m.ermolaev.collections.CurrencyDataCollection;
import m.ermolaev.collections.IDataCollection;
import m.ermolaev.data.RemoteDataProvider;
import m.ermolaev.exchange.Exchange;
import m.ermolaev.exchange.IExchange;
import m.ermolaev.view.ICurrencyView;
import org.xml.sax.SAXException;
import m.ermolaev.collections.providers.IStringCurrencyCollectionProvider;
import m.ermolaev.collections.providers.XMLCurrencyCollectionProvider;
import m.ermolaev.data.IRemoteDataProvider;
import m.ermolaev.view.StandardView;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class Main {

    static IRemoteDataProvider provider;
    static IDataCollection LastA;
    static IStringCurrencyCollectionProvider xmlProvider;
    static IExchange exchange;
    static ICurrencyView view;
    public static void main(String[] args) {
        provider = new RemoteDataProvider();
        xmlProvider = new XMLCurrencyCollectionProvider();

        LastA = new CurrencyDataCollection();
        exchange = new Exchange();
        view = new StandardView();
        try {
            String result = provider.acquireRemoteData("https://www.nbp.pl/kursy/xml/LastA.xml");
            xmlProvider.provide(result,LastA);

            view.setDataCollection(LastA);
            view.setExchange(exchange);
            view.menu();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}
