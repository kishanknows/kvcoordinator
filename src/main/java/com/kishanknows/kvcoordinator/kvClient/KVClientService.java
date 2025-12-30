package com.kishanknows.kvcoordinator.kvClient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KVClientService {
    private final RestTemplate restTemplate;

    public KVClientService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public KVClientResponse fetchKeyValue(KVClientPostRequest request){
        return restTemplate.postForObject(
                "http://kvstore:8082/kv",
                request,
                KVClientResponse.class
        );
    }

    public KVClientResponse storeKeyValue(KVClientPutRequest request){
        ResponseEntity<KVClientResponse> response = restTemplate.exchange(
                "http://kvstore:8082/kv",
                HttpMethod.PUT,
                new HttpEntity<>(request),
                KVClientResponse.class
        );
        return response.getBody();
    }
}
