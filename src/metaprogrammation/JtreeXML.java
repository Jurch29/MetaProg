package metaprogrammation;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class JtreeXML extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree tree;

	public void draw(String carnet) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		CarnetHandler ch = new CarnetHandler();
		parser.parse(carnet, ch);
		Carnet cn1 = ch.getCarnet();
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Carnet");
		for (int i = 0 ; i < cn1.getContacts().size() ; i++) {
			DefaultMutableTreeNode contactNode = new DefaultMutableTreeNode("Contact");
			contactNode.add(new DefaultMutableTreeNode(cn1.getContacts().get(i).getName()));
			contactNode.add(new DefaultMutableTreeNode(cn1.getContacts().get(i).getNickname()));
			contactNode.add(new DefaultMutableTreeNode(cn1.getContacts().get(i).getNum()));
			root.add(contactNode);
		}

        tree = new JTree(root);
        add(tree);
         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");       
        this.pack();
        this.setVisible(true);
	}
}
