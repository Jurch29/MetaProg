package metaprogrammation;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CarnetHandler extends DefaultHandler{
	
	   private String node = null;
	   private String data = null;
	   
	   private Contact contact = null;
	   private Carnet carnet = new Carnet();

	   public void startDocument() throws SAXException {
	      //début parsing
	   }
	   
	   public void startElement(String namespaceURI, String lname,
			      String qname, Attributes attrs) throws SAXException {
		   
		   node = qname;
		   
		   if (node.equals("contact")) {
			   this.contact = new Contact();
			   carnet.addContact(this.contact);
		   }
		   
		   //liste des attributs du nœud
		     if (attrs != null) {
		        for (int i = 0; i < attrs.getLength(); i++) {
		         //nom de l'attribut
		         String aname = attrs.getLocalName(i);
		         //sa valeur
//		         System.out.println("Attribut " + aname + " valeur : " + attrs.getValue(i));
		         
		          if (aname.equals("name"))
					  contact.setName(attrs.getValue(i));
				  if (aname.equals("nickname"))
					  contact.setNickname(attrs.getValue(i));
				  if (aname.equals("num"))
					  contact.setNum(attrs.getValue(i));
			    }
			 }
		}
	   
	   public void characters(char[] data, int start, int end){   
		   this.data = new String(data, start, end);
	   }
	   
	   public void endElement(String uri, String localName, String qName)
		      throws SAXException{
		  
		  if (qName.equals("name"))
			  contact.setName(data);
		  if (qName.equals("nickname"))
			  contact.setNickname(data);
		  if (qName.equals("num"))
			  contact.setNum(data);
	   }
	   
	   public void endDocument() throws SAXException {
	      //fin parsing
	   }
	   
	   public Carnet getCarnet(){
		   return this.carnet;
	   }
}
