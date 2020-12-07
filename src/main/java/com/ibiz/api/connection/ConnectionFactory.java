package com.ibiz.api.connection;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("connectionFactory")
public class ConnectionFactory {
    private RestTemplate restTemplate;

    public ConnectionFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

        factory.setReadTimeout(300000);
        factory.setConnectTimeout(300000);

        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(50)
                .setMaxConnPerRoute(50).build();

        factory.setHttpClient(httpClient);

        this.restTemplate = new RestTemplate(factory);
    }

    public RestTemplate getRestTemplate() {
        return this.restTemplate;
    }
}
