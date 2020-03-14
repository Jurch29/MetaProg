package metaprogrammation;

import java.io.File;
import java.io.IOException;
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

public class Contact implements ExportableXML {

	
	private String name;
	private String nickname;
	private String num;
	
	public Contact() {

	}
	
	public Contact(String name, String nickname, String num) {
		this.name = name;
		this.nickname = nickname;
		this.num = num;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public void exportToXmlNode(String file) throws IOException, ParserConfigurationException, TransformerException {

		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("carnet");
        document.appendChild(root);
        
    	Element contact = document.createElement("contact");
        root.appendChild(contact);
        
        Element name = document.createElement("name");
        name.setTextContent(this.getName());
        contact.appendChild(name);
        
        Element nickname = document.createElement("nickname");
        nickname.setTextContent(this.getNickname());
        contact.appendChild(nickname);
        
        Element num = document.createElement("num");
        num.setTextContent(this.getNum());
        contact.appendChild(num);
		
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamoutput = new StreamResult(new File(file));
        transformer.transform(domSource, streamoutput);
	}

	@Override
	public void exportToXmlattr(String file)
			throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException {
		 
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("carnet");
        document.appendChild(root);
        
    	Element contact = document.createElement("contact");
        root.appendChild(contact);
        
        Attr name = document.createAttribute("name");
        name.setValue(this.getName());
        contact.setAttributeNode(name);
        
        Attr nickname = document.createAttribute("nickname");
        nickname.setValue(this.getNickname());
        contact.setAttributeNode(nickname);
        
        Attr num = document.createAttribute("num");
        num.setValue(this.getNum());
        contact.setAttributeNode(num);
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamoutput = new StreamResult(new File(file));
        transformer.transform(domSource, streamoutput);
		
	}
}
