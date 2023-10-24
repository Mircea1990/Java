package com.example.customscope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.lang.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// This class implements the Scope interface and represents a TenantScope.
public class TenantScope implements Scope {
    // A thread-safe map to store scoped objects.
    private final Map<String, Object> scopedObjects = Collections.synchronizedMap(
            new HashMap<String, Object>());
    // A thread-safe map to store destruction callbacks.
    private final Map<String, Runnable> destructionCallbacks = Collections.synchronizedMap(
            new HashMap<String, Runnable>());

    // This method retrieves an object from the scopedObjects map. If the object does not exist,
    // it creates a new one using the provided objectFactory.
    @Override public @NonNull Object get(@NonNull String name,
                                         @NonNull ObjectFactory<?> objectFactory) {
        if (!scopedObjects.containsKey(name)) {
            scopedObjects.put(name, objectFactory.getObject());
        }
        return scopedObjects.get(name);
    }

    // This method removes an object from the scopedObjects map and its associated destruction
    // callback.
    @Override public Object remove(@NonNull String name) {
        destructionCallbacks.remove(name);
        return scopedObjects.remove(name);
    }

    // This method registers a destruction callback for a specific object in the scope.
    @Override public void registerDestructionCallback(@NonNull String name,
                                                      @NonNull Runnable callback) {
        destructionCallbacks.put(name, callback);
    }

    // This method is used to resolve contextual objects. In this case, it always returns null.
    @Override public Object resolveContextualObject(@NonNull String key) {
        return null;
    }

    // This method returns the conversation ID. In this case, it always returns "tenant".
    @Override public String getConversationId() {
        return "tenant";
    }
}
