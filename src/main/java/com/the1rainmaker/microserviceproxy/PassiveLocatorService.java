package com.the1rainmaker.microserviceproxy;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//import com.adobe.cq.sightly.WCMUse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Dictionary;

/**
 * Created by the1rainmaker on 8/26/2015.
 */
public class PassiveLocatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PassiveLocatorService.class);

    private String targetUrlPrefix;
    private String serviceSuffix = "/ws/store/locator/VA/22015";

    public PassiveLocatorService(String _targetUrlPrefix) {
        targetUrlPrefix = _targetUrlPrefix;
    }

    public String getData()
    {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("getData()");
        }
        String myJSON = "NONE!";
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(targetUrlPrefix + serviceSuffix);
        //getRequest.addHeader("accept", "application/json");
        HttpResponse response = null;
        try {
            response = httpClient.execute(getRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response.getStatusLine().getStatusCode() != 200)
            throw new RuntimeException((new StringBuilder()).append("Failed : HTTP error code : ").append(response.getStatusLine().getStatusCode()).toString());
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String output;
        try {
            for(myJSON = ""; (output = br.readLine()) != null; myJSON = (new StringBuilder()).append(myJSON).append(output).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpClient.getConnectionManager().shutdown();

        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("getData()::out -> " + myJSON);
        }
        return myJSON;
    }

    public String doSuffixCall(String suffix)
    {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("doSuffixCall: " +  suffix);
        }

        String myJSON = "NONE!";
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(targetUrlPrefix + suffix);
        //getRequest.addHeader("accept", "application/json");
        HttpResponse response = null;
        try {
            response = httpClient.execute(getRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response.getStatusLine().getStatusCode() != 200)
            throw new RuntimeException((new StringBuilder()).append("Failed : HTTP error code : ").append(response.getStatusLine().getStatusCode()).toString());
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String output;
        try {
            for(myJSON = ""; (output = br.readLine()) != null; myJSON = (new StringBuilder()).append(myJSON).append(output).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpClient.getConnectionManager().shutdown();
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("doSuffixCall()::out -> " + myJSON);
        }
        return myJSON;
    }

}
