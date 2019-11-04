package junit;

import static org.junit.jupiter.api.Assertions.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metaprogrammation.Carnet;
import metaprogrammation.CarnetHandler;

class Exo3 {

	boolean b = true;
	
	@BeforeEach
	public void setUp() throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		CarnetHandler ch = new CarnetHandler();
		parser.parse("carnetNode.xml", ch);
		Carnet cn1 = ch.getCarnet();
		cn1.showAll();
	}
	
	@Test
	void test1() {
		assertFalse(b);
		b = true;
	}
	
	@Test
	void test2() {
		assertFalse(b);
	}
}