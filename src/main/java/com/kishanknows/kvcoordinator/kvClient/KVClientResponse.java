package com.kishanknows.kvcoordinator.kvClient;

public record KVClientResponse(
        String key,
        String value
) {
}
