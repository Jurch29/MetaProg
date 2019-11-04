package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metaprogrammation.Carnet;
import metaprogrammation.Contact;

class Exo2 {

	@BeforeEach
	void setUp() throws Exception {
		Contact c2 = new Contact("floc", "Julien", "0642114696");
		Contact c3 = new Contact("flic", "Julien", "0642114695");
		Contact c4 = new Contact("poule", "Julien", "0642114694");
		Carnet carnet = new Carnet();
		carnet.addContact(c2);
		carnet.addContact(c3);
		carnet.addContact(c4);
		carnet.exportToXmlNode("carnetNode.xml");
		carnet.exportToXmlattr("carnetAttr.xml");
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
