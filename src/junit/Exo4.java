package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metaprogrammation.JtreeXML;

class Exo4 {

	@BeforeEach
	void setUp() throws Exception {
		JtreeXML j3 = new JtreeXML();
		j3.draw("carnetNode.xml");
	}

	@Test
	void test() {
		
	}

}