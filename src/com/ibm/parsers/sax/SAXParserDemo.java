package com.ibm.parsers.sax;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class SAXParserDemo {
   private static final String PATH = "D:/XML/Parsing/class.xml";
   public static void main(String[] args) {

      try {
         File inputFile = new File(PATH);
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         UserHandler userhandler = new UserHandler();
         saxParser.parse(inputFile, userhandler);     
      } catch (Exception e) {
         e.printStackTrace();
      }
   }   
}

