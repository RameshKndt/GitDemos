package com.ibm.validate.xsd;
import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XSDSAXValidator {
   private static final String XSD_PATH = "D:/XML/XSD/class.xsd";
   private static final String XML_PATH = "D:/XML/XSD/class.xml";

public static void main(String[] args) {
      
         boolean isValid = validateXMLSchema(XSD_PATH,XML_PATH);
         
         if(isValid){
            System.out.println(XML_PATH + " is valid against " + XSD_PATH);
         } else {
            System.out.println(XML_PATH + " is not valid against " + XSD_PATH);
         }
   }
   
   public static boolean validateXMLSchema(String xsdPath, String xmlPath){
      try {
         SchemaFactory factory =
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
      } catch (IOException e){
         System.out.println("Exception: "+e.getMessage());
         return false;
      }catch(SAXException e1){
         System.out.println("SAX Exception: "+e1.getMessage());
         return false;
      }
		
      return true;
	
   }
}