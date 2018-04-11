package com.gojek.test.helpers;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.ParserConfigurationException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

public class XmlParser {

  private static SAXReader reader = new SAXReader();

  public static Document parseXML(String body)
      throws ParserConfigurationException, SAXException, UnsupportedEncodingException, DocumentException {
    return reader.read(new ByteArrayInputStream(body.getBytes("UTF-8")));
  }

}
