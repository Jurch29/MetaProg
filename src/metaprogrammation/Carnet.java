package metaprogrammation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Carnet implements ExportableXML {
	
	private ArrayList<Contact> contacts =  new ArrayList<Contact>() ;
	
	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}

	public void addContact(Contact c) {
		this.contacts.add(c);
	}

	@Override
	public void exportToXmlNode(String file) throws IOException, ParserConfigurationException, TransformerException {

	    DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("carnet");
        document.appendChild(root);
        
        for (int i = 0 ; i < this.contacts.size() ; i++) {
        	Element contact = document.createElement("contact");
            root.appendChild(contact);
            
            Element name = document.createElement("name");
            name.setTextContent(this.contacts.get(i).getName());
            contact.appendChild(name);
            
            Element nickname = document.createElement("nickname");
            nickname.setTextContent(this.contacts.get(i).getNickname());
            contact.appendChild(nickname);
            
            Element num = document.createElement("num");
            num.setTextContent(this.contacts.get(i).getNum());
            contact.appendChild(num);
		}
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(file));
        transformer.transform(domSource, streamResult);
	}

	@Override
	public void exportToXmlattr(String file)
			throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("carnet");
        document.appendChild(root);
        
        for (int i = 0 ; i < this.contacts.size() ; i++) {
        	Element contact = document.createElement("contact");
            root.appendChild(contact);
            
            Attr name = document.createAttribute("name");
            name.setValue(this.contacts.get(i).getName());
            contact.setAttributeNode(name);
            
            Attr nickname = document.createAttribute("nickname");
            nickname.setValue(this.contacts.get(i).getNickname());
            contact.setAttributeNode(nickname);
            
            Attr num = document.createAttribute("num");
            num.setValue(this.contacts.get(i).getNum());
            contact.setAttributeNode(num);
		}
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(file));
        transformer.transform(domSource, streamResult);
	}
	
	public void showAll() {
		for (int i=0 ; i < this.contacts.size() ; i++) {
			System.out.println("Name : "+this.contacts.get(i).getName());
			System.out.println("Nickame : "+this.contacts.get(i).getNickname());
			System.out.println("Num : "+this.contacts.get(i).getNum());
		}
	}
}
