package metaprogrammation;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

public interface ExportableXML {

	public void exportToXmlNode(String file) throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException;
	public void exportToXmlattr(String file) throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException;

}
