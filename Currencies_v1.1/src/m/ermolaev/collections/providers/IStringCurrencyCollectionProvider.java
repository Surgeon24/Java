package m.ermolaev.collections.providers;

import m.ermolaev.collections.IDataCollection;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface IStringCurrencyCollectionProvider {
    public void provide(String input, IDataCollection output) throws IOException, SAXException, ParserConfigurationException;
}
