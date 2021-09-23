package com.ibm.parsers.stax;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class StaxXMLStreamWriter {

    public static void main(String[] args) {
        String fileName = "D:/XML/employee_stax_create.xml";
        String rootElement = "Employees";
        StaxXMLStreamWriter xmlStreamWriter = new StaxXMLStreamWriter();
        Map<String,String> elementsMap = new HashMap<String, String>();
        elementsMap.put("id", "1");
        elementsMap.put("name", "Ramesh");
        elementsMap.put("age", "29");
        elementsMap.put("role", "Java Developer");
        elementsMap.put("gender", "Male");
        Map<String,String> elementsMap2 = new HashMap<String, String>();
        elementsMap2.put("id", "2");
        elementsMap2.put("name", "Ravi");
        elementsMap2.put("age", "35");
        elementsMap2.put("role", "Java Developer");
        elementsMap2.put("gender", "Male");
        List<Map<String,String>> aList = new ArrayList<>();
        aList.add(elementsMap);
        aList.add(elementsMap2);
        xmlStreamWriter.writeXML(fileName, rootElement, aList);
    }

    private void writeXML(String fileName, String rootElement, 
    		List<Map<String, String>> aList) {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        try{
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            //start writing xml file
            xmlStreamWriter.writeStartDocument("UTF-8", "1.0");
            xmlStreamWriter.writeCharacters("");
            xmlStreamWriter.writeStartElement(rootElement);
            for(Map<String,String> elementsMap: aList ) {
            //write id as attribute
            xmlStreamWriter.writeStartElement("Employee");	
            xmlStreamWriter.writeAttribute("id", elementsMap.get("id"));
            
            //write other elements
            
            xmlStreamWriter.writeStartElement("name");
            xmlStreamWriter.writeCharacters(""+elementsMap.get("name"));
            xmlStreamWriter.writeCharacters("");
            xmlStreamWriter.writeEndElement();
            
            
            xmlStreamWriter.writeStartElement("age");
            xmlStreamWriter.writeCharacters(""+elementsMap.get("age"));
            xmlStreamWriter.writeCharacters("");
            xmlStreamWriter.writeEndElement();
            
            
            xmlStreamWriter.writeStartElement("gender");
            xmlStreamWriter.writeCharacters(""+elementsMap.get("gender"));
            xmlStreamWriter.writeCharacters("");
            xmlStreamWriter.writeEndElement();
            
            
            xmlStreamWriter.writeStartElement("role");
            xmlStreamWriter.writeCharacters(""+elementsMap.get("role"));
            xmlStreamWriter.writeCharacters("");
            xmlStreamWriter.writeEndElement();
            //write end tag of Employee element
            
            xmlStreamWriter.writeEndElement();

            }
            xmlStreamWriter.writeEndElement();
            //write end document
            xmlStreamWriter.writeEndDocument();
            
            //flush data to file and close writer
            xmlStreamWriter.flush();
            xmlStreamWriter.close();
            
        }catch(XMLStreamException | FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
