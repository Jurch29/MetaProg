package metaprogrammation;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException {
		// TODO Auto-generated method stub
		exo5();
	}

	private static void exo5() throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		JtreeXML j3 = new JtreeXML();
		j3.draw("carnetNode.xml");
	}
}