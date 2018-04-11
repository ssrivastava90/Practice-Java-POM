package com.gojek.test.helpers;

import com.gojek.test.WebResponse;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class WebResponseHelper {

  public static void checkJson(WebResponse webResponse1,WebResponse webResponse2,String url1,String url2)
      throws IOException {

    JsonNode node1 = JsonParser.parseJson(webResponse1.getCurrentBody());
    JsonNode node2 = JsonParser.parseJson(webResponse2.getCurrentBody());

    if (node1.equals(node2)){
      System.out.println("[Thread]" + Thread.currentThread().getName() + ", " + url1 + " equals " + url2);
    }else{
      System.out.println("[Thread]" + Thread.currentThread().getName() + ", " + url1 + " not equals " + url2);
    }

  }

  public static void checkXml(WebResponse webResponse1,WebResponse webResponse2,String url1,String url2)
      throws ParserConfigurationException, SAXException, DocumentException, UnsupportedEncodingException {


    Document node1 = XmlParser.parseXML(webResponse1.getCurrentBody());
    Document  node2 = XmlParser.parseXML(webResponse2.getCurrentBody());


    if((null!=node1)&&(null!=node2)) {
      if (node1.asXML().equalsIgnoreCase(node2.asXML())) {
        System.out.println("[Thread]" + Thread.currentThread().getName() + ", " + url1 + " equals " + url2);
      } else {
        System.out.println("[Thread]" + Thread.currentThread().getName() + ", " + url1 + " not equals " + url2);
      }
    }else{
      System.out.println("[Thread]" + Thread.currentThread().getName() + ", " + url1 + " not equals " + url2 + " null");
    }
  }

}
