package jakarta.tutorial.concurrency.jobs.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.ConcurrencyManagement;
import jakarta.ejb.ConcurrencyManagementType;
import jakarta.ejb.Lock;
import jakarta.ejb.LockType;
import jakarta.ejb.Singleton;


@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER) @Singleton public class TokenStore
        implements Serializable {

    private final List<String> store;

    public TokenStore() {
        this.store = new ArrayList<>();
    }

    @Lock(LockType.WRITE) public void put(String key) {
        store.add(key);
    }

    @Lock(LockType.READ) public boolean isValid(String key) {
        return store.contains(key);
    }
}
