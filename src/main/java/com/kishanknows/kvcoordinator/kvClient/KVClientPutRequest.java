package com.kishanknows.kvcoordinator.kvClient;

public record KVClientPutRequest(
        String key,
        String value
) {
}
