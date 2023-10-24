package com.example.applicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

// This annotation indicates that an annotated class is a "component". Such classes are
// considered as candidates for auto-detection when using annotation-based configuration and
// classpath scanning.
@Component public class AccountService {
    // The @Getter annotation is a Lombok annotation to auto-generate the getter method for this
    // field.
    // The @Autowired annotation is used to auto-wire the Spring Bean automatically.
    // Here it's injecting an instance of AccountRepository into this service.
    @lombok.Getter @Autowired private AccountRepository accountRepository;
    // Here it's injecting an instance of MessageSource into this service.
    @Autowired private MessageSource messageSource;

    // This is a constructor for the AccountService class that initializes the accountRepository
    // field.
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // This is a setter method for the accountRepository field.
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // This method retrieves a message from the messageSource bean.
    // It's getting the message with the code "account.name" and English locale. If no such
    // message is found, it returns null.
    public String getAccountName() {
        return messageSource.getMessage("account.name", null, Locale.ENGLISH);
    }
}
