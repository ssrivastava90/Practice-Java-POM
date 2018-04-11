package com.gojek.test.helpers;

import com.gojek.test.WebResponse;
import com.sun.deploy.net.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import org.apache.http.util.EntityUtils;

// Why is it called builder. Its just an http utility.
public class HttpMethodUtils {

    //rather return string response or based on response header, content-type.
    public static WebResponse get(String url){
        HttpGet request = new HttpGet(url);
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse httpResponse = null;
        WebResponse webResponse  = null;
        try {
            httpResponse = client.execute(request);
            webResponse = handleResponse(httpResponse);
        }catch (IOException e){
            System.out.println(e);
        } finally {
            try {
                client.close();
                if (null != httpResponse){
                    httpResponse.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return webResponse;
    }

    private static  WebResponse handleResponse(CloseableHttpResponse httpresponse) throws IOException {
        WebResponse webResponse = new WebResponse();

        webResponse.setResponseCode(httpresponse.getStatusLine().getStatusCode());

        ContentType contentType1 = ContentType.getOrDefault(httpresponse.getEntity());
        webResponse.setResponseType(contentType1.getMimeType());


        String body = EntityUtils.toString(httpresponse.getEntity());
        webResponse.setCurrentBody(body);

        return webResponse;
    }
}
