package API_Tasks.task1;

import java.io.IOException;
import java.io.StringReader;
import java.net.http.HttpClient;
import java.util.HashMap;
import io.restassured.internal.http.URIBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class SOAP_Calculator {


    public static SOAPMessage getSOAPMessagefromDataXML(String saopBodyXML) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setNamespaceAware(true);
        dbFactory.setIgnoringComments(true);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource ips = new org.xml.sax.InputSource(new StringReader(saopBodyXML));
        Document docBody = dBuilder.parse(ips);
        System.out.println("Data Document: "+docBody.getDocumentElement());

        MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage soapMsg = messageFactory.createMessage();

        SOAPBody soapBody = soapMsg.getSOAPPart().getEnvelope().getBody();
        soapBody.addDocument(docBody);

        return soapMsg;
    }
    public static void accessResource_AppachePOST(SOAPMessage soapMsg) throws Exception {
        System.out.println("===== HttpClientBuilder =====");
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder( serverDetails.get("SoapServerURI") );
        HttpPost methodPost = new HttpPost(builder.build());
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(5 * 1000)
                .setConnectionRequestTimeout(5 * 1000)
                .setSocketTimeout(5 * 1000)
                .build();
        methodPost.setConfig(config);
        HttpEntity xmlEntity = new StringEntity(getSOAPXMLasString(soapMsg), "utf-8");
        methodPost.setEntity(xmlEntity);

        methodPost.setHeader("Content-Type", serverDetails.get("Content-Type"));
        methodPost.setHeader("SoapBinding", serverDetails.get("SoapBinding") );
        methodPost.setHeader("MethodName", serverDetails.get("MethodName") );
        methodPost.setHeader("SOAPAction", serverDetails.get("SOAPAction") );
        methodPost.setHeader("Accept-Encoding", serverDetails.get("Accept-Encoding"));

        // Create a custom response handler
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse( final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status <= 500) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                }
                return "";
            }
        };
        String execute = httpClient.execute( methodPost, responseHandler );
        System.out.println("AppachePOST : "+execute);
    }

    public static void getHttpConnection(SOAPMessage soapMsg) throws SOAPException, IOException {
        System.out.println("===== HttpClient =====");
        HttpClient httpClient = new HttpClient();
        HttpConnectionManagerParams params = httpClient.getHttpConnectionManager().getParams();
        params.setConnectionTimeout(3 * 1000); // Connection timed out
        params.setSoTimeout(3 * 1000);         // Request timed out
        params.setParameter("http.useragent", "Web Service Test Client");

        PostMethod methodPost = new PostMethod( serverDetails.get("SoapServerURI") );
        methodPost.setRequestBody( getSOAPXMLasString(soapMsg) );
        methodPost.setRequestHeader("Content-Type", serverDetails.get("Content-Type") );
        methodPost.setRequestHeader("SoapBinding",  serverDetails.get("SoapBinding") );
        methodPost.setRequestHeader("MethodName",   serverDetails.get("MethodName") );
        methodPost.setRequestHeader("SOAPAction",   serverDetails.get("SOAPAction") );

        methodPost.setRequestHeader("Accept-Encoding", serverDetails.get("Accept-Encoding"));

        try {
            int returnCode = httpClient.executeMethod(methodPost);
            if (returnCode == HttpStatus.SC_NOT_IMPLEMENTED) {
                System.out.println("The Post method is not implemented by this URI");
                methodPost.getResponseBodyAsString();
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(methodPost.getResponseBodyAsStream()));
                String readLine;
                while (((readLine = br.readLine()) != null)) {
                    System.out.println(readLine);
                }
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            methodPost.releaseConnection();
        }
    }
    public static void getSOAPConnection(SOAPMessage soapMsg) throws Exception {
        System.out.println("===== SOAPConnection =====");
        MimeHeaders headers = soapMsg.getMimeHeaders(); // new MimeHeaders();
        headers.addHeader("SoapBinding",   serverDetails.get("SoapBinding") );
        headers.addHeader("MethodName",    serverDetails.get("MethodName") );
        headers.addHeader("SOAPAction",    serverDetails.get("SOAPAction") );
        headers.addHeader("Content-Type",  serverDetails.get("Content-Type"));
        headers.addHeader("Accept-Encoding", serverDetails.get("Accept-Encoding"));
        if (soapMsg.saveRequired()) {
            soapMsg.saveChanges();
        }

        SOAPConnectionFactory newInstance = SOAPConnectionFactory.newInstance();
        javax.xml.soap.SOAPConnection connection = newInstance.createConnection();
        SOAPMessage soapMsgResponse = connection.call(soapMsg, getURL( serverDetails.get("SoapServerURI"), 5*1000 ));

        getSOAPXMLasString(soapMsgResponse);
    }

    static HashMap<String, String> serverDetails = new HashMap<>();
    static {
        // Calculator
        serverDetails.put("SoapServerURI", "http://www.dneonline.com/calculator.asmx");
        serverDetails.put("SoapWSDL", "http://www.dneonline.com/calculator.asmx?wsdl");
        serverDetails.put("SoapBinding", "CalculatorSoap");        // <wsdl:binding name="CalculatorSoap12" type="tns:CalculatorSoap">
        serverDetails.put("MethodName", "Add");                    // <wsdl:operation name="Add">
        serverDetails.put("SOAPAction", "http://tempuri.org/Add"); // <soap12:operation soapAction="http://tempuri.org/Add" style="document"/>
        serverDetails.put("SoapXML", "<tem:Add xmlns:tem=\"http://tempuri.org/\"><tem:intA>2</tem:intA><tem:intB>4</tem:intB></tem:Add>");

        serverDetails.put("Accept-Encoding", "gzip,deflate");
        serverDetails.put("Content-Type", "");
    }
    public static void callSoapService( ) throws Exception {
        String xmlData = serverDetails.get("SoapXML");

        SOAPMessage soapMsg = getSOAPMessagefromDataXML(xmlData);
        System.out.println("Requesting SOAP Message:\n"+ getSOAPXMLasString(soapMsg) +"\n");

        SOAPEnvelope envelope = soapMsg.getSOAPPart().getEnvelope();
        if (envelope.getElementQName().getNamespaceURI().equals("http://schemas.xmlsoap.org/soap/envelope/")) {
            System.out.println("SOAP 1.1 NamespaceURI: http://schemas.xmlsoap.org/soap/envelope/");
            serverDetails.put("Content-Type", "text/xml; charset=utf-8");
        } else {
            System.out.println("SOAP 1.2 NamespaceURI: http://www.w3.org/2003/05/soap-envelope");
            serverDetails.put("Content-Type", "application/soap+xml; charset=utf-8");
        }

        getHttpConnection(soapMsg);
        getSOAPConnection(soapMsg);
        accessResource_AppachePOST(soapMsg);
    }
    public static void main(String[] args) throws Exception {
        callSoapService();
    }

    private static URL getURL(String endPointUrl, final int timeOutinSeconds) throws MalformedURLException {
        URL endpoint = new URL(null, endPointUrl, new URLStreamHandler() {
            protected URLConnection openConnection(URL url) throws IOException {
                URL clone = new URL(url.toString());
                URLConnection connection = clone.openConnection();
                connection.setConnectTimeout(timeOutinSeconds);
                connection.setReadTimeout(timeOutinSeconds);
                //connection.addRequestProperty("Developer-Mood", "Happy"); // Custom header
                return connection;
            }
        });
        return endpoint;
    }
    public static String getSOAPXMLasString(SOAPMessage soapMsg) throws SOAPException, IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        soapMsg.writeTo(out);
        // soapMsg.writeTo(System.out);
        String strMsg = new String(out.toByteArray());
        System.out.println("Soap XML: "+ strMsg);
        return strMsg;
    }
}
