package com.bandwidth.V2.controllers;

//Bandwidth V2 packages
import com.bandwidth.V2.models.SendMessageRequestBody;
import com.bandwidth.V2.BandwidthClient;

//Packages for http requests
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

//Exceptions
import java.net.MalformedURLException;
import java.io.IOException;

/**
 * Class to handle requests on Bandwidth's Messaging URLs
 */
public class MessageController {

    protected static String BASE_URL = "https://api.catapult.inetwork.com/v2/users/{userId}/messages";
    protected static String SEND_MESSAGE_URL = "";

    private BandwidthClient client;
    private String url;

    /**
     * Constructor for MessageController
     *
     * @param client The BandwidthClient object to make requests
     */
    public MessageController(BandwidthClient client) {
        this.client = client;
        this.url = BASE_URL.replace("{userId}", client.getUserId());
    }

    /**
     * Takes a SendMessageRequestBody object and calls the client function makeRequestMessageControllerPost()
     *
     * @param requestBody The SendMessageRequestBody object representing the request body parameters
     *
     * @return String: The response of the request
     *
     * @throws IOException IOException
     * @throws MalformedURLException MalformedURLException
     */
    public String sendMessage(SendMessageRequestBody requestBody) throws MalformedURLException, IOException {
        String body = requestBody.toJSON();
        StringEntity entity = this.client.getStringEntity(body);
        String fullUrl = this.url + SEND_MESSAGE_URL;
        HttpClient client = this.client.getClient();
        HttpPost post = this.client.getHttpPost(fullUrl);
        HttpResponse response = this.client.makeRequestMessageControllerPost(entity, client, post);
        return this.client.parseResponse(response);
    }
}
