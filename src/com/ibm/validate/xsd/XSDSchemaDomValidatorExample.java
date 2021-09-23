package com.ibm.validate.xsd;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;


public class XSDSchemaDomValidatorExample {
	private static final String XSD_PATH = "D:/XML/XSD/class.xsd";
	private static final String XML_PATH = "D:/XML/XSD/class.xml";

 public static void main(String[] args) {
  
  Schema schema = loadSchema(XSD_PATH);
  Document document = parseXmlDom(XML_PATH);

  validateXml(schema, document);
 }

 public static void validateXml(Schema schema, Document document) {
  try {
   // 3. Get a validator from the schema.
   Validator validator = schema.newValidator();
   System.out.println("Validator Class: " + validator.getClass().getName());

   // validating the document against the schema
   validator.validate(new DOMSource(document));
   System.out.println("Validation passed.");

  } catch (Exception e) {
   // catching all validation exceptions
   System.out.println(e.toString());
  }
 }

 public static Schema loadSchema(String schemaFileName) {
  Schema schema = null;
  try {
   //// 1. Lookup a factory for the W3C XML Schema language
   String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
   SchemaFactory factory = SchemaFactory.newInstance(language);

   /*
    * 2. Compile the schema. Here the schema is loaded from a java.io.File, but
    * you could use a java.net.URL or a javax.xml.transform.Source instead.
    */
   schema = factory.newSchema(new File(schemaFileName));
  } catch (Exception e) {
   System.out.println(e.toString());
  }
  return schema;
 }

 public static Document parseXmlDom(String xmlName) {
  Document document = null;
  try {
   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
   DocumentBuilder builder = factory.newDocumentBuilder();
   document = builder.parse(new File(xmlName));
  } catch (Exception e) {
   System.out.println(e.toString());
  }
  return document;
 }

}