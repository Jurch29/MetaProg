package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metaprogrammation.Contact;

class Exo1 {

	@BeforeEach
	void setUp() throws Exception {
//		Contact c1 = new Contact("Rochard", "Julien", "0642114697");
//		Contact c2 = new Contact("floc", "Julien", "0642114696");
//		Contact c3 = new Contact("flic", "Julien", "0642114695");
//		Contact c4 = new Contact("poule", "Julien", "0642114694");
//		Contact c5 = new Contact("coq", "Julien", "0642114693");
//		Contact c6 = new Contact("chien", "Julien", "0642114692");
		Contact c7 = new Contact("chat", "Julien", "0642114691");
		c7.exportToXmlattr("contactAttr.xml");
		c7.exportToXmlNode("contactNode.xml");
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
