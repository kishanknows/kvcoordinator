package com.kishanknows.kvcoordinator.kvClient;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KVClientController {
    final private KVClientService service;

    public KVClientController(KVClientService service){
        this.service = service;
    }

    @PostMapping("/kv")
    public KVClientResponse getKeyValue(@RequestBody KVClientPostRequest request) {
        return service.fetchKeyValue(request);
    }

    @PutMapping("/kv")
    public KVClientResponse putKeyValue(@RequestBody KVClientPutRequest request) {
        return service.storeKeyValue(request);
    }
}
