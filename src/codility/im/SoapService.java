package codility.im;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SoapService {
	public static void main(String[] args) throws Exception {
		String response ="<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
				+ "   <soap:Body>\n"
				+ "      <tns:getTransactionResponse xmlns:tns=\"http://www.talend.org/service/\">\n"
				+ "         <error_code>200</error_code>\n"
				+ "         <error_message>Transaction OK.</error_message>\n"
				+ "         <reference>NSSF8261125436</reference>\n"
				+ "         <upl_datetime>2021-03-25 00:00:00</upl_datetime>\n"
				+ "         <employer_no>1474</employer_no>\n"
				+ "         <employer>1474</employer>\n"
				+ "         <type>Standard Contribution</type>\n"
				+ "         <payment_method>Bank Transfer</payment_method>\n"
				+ "         <period>2021-03-01-2021-03-31</period>\n"
				+ "         <total>3750.00</total>\n"
				+ "         <allchqs>3750</allchqs>\n"
				+ "         <signature>83fa62f1f027b0e944c56447327d3bb7eb70ad16</signature>\n"
				+ "         <timestamp>1626435344</timestamp>\n"
				+ "      </tns:getTransactionResponse>\n"
				+ "   </soap:Body>\n"
				+ "</soap:Envelope>";
		System.out.println(getSOAPResponseInfo(response));
	}

	public static Document loadXMLString(String response) throws Exception
	{
	    DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
	    dbf.setNamespaceAware(true);
		Document responseDoc = dbf.newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(response.getBytes())));

		System.out.println("responseDoc="+responseDoc);
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    InputSource is = new InputSource(new StringReader(response));

	    return db.parse(is);
	}

public static List<String> getFullNameFromXml(String response) throws Exception {
    Document xmlDoc = loadXMLString(response);
    
    System.out.println("XMLDOC="+xmlDoc);
    NodeList nodeList = (NodeList) xmlDoc.getElementsByTagNameNS("*","Body");
    
    System.out.println("nodeList="+nodeList.getLength());
    List<String> ids = new ArrayList<String>(nodeList.getLength());
    for(int i=0;i<nodeList.getLength(); i++) {
        Node x = nodeList.item(i);
        ids.add(x.getFirstChild().getNodeValue());             
        System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
    }
    return ids;
}
	
	
	public static Object[] getSOAPResponseInfo(String responseMessage)
			throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		Document responseDoc = factory.newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(responseMessage.getBytes())));
		NodeList bodyElement = (NodeList) responseDoc.getElementsByTagNameNS("*", "Body");
		System.out.println("BODY ELEMENT="+bodyElement.item(0));
		
		
		Object[] reponseInfo = new Object[2];
		NodeList faultList = null;//bodyElement.getElementsByTagNameNS("*", "Fault");
		if (faultList.getLength() > 0) {
			reponseInfo[0] = Boolean.valueOf(false);
			reponseInfo[1] = faultList.item(0);
		} else {
			reponseInfo[0] = Boolean.valueOf(true);
			reponseInfo[1] = bodyElement;
		}
		return reponseInfo;
	}

}
