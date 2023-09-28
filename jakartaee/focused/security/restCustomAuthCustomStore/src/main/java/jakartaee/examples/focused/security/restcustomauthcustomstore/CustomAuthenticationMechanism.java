package jakartaee.examples.focused.security.restcustomauthcustomstore;


import static jakarta.security.enterprise.identitystore.CredentialValidationResult.Status.VALID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.AuthenticationException;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import jakarta.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.IdentityStoreHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ApplicationScoped public class CustomAuthenticationMechanism
        implements HttpAuthenticationMechanism {

    @Inject private IdentityStoreHandler identityStoreHandler;

    @Override public AuthenticationStatus validateRequest(HttpServletRequest request,
                                                          HttpServletResponse response,
                                                          HttpMessageContext httpMessageContext)
            throws AuthenticationException {

        var callerName = request.getHeader("callername");
        var password = request.getHeader("callerpassword");

        if (callerName == null || password == null) {
            return httpMessageContext.doNothing();
        }

        var result = identityStoreHandler.validate(
                new UsernamePasswordCredential(callerName, password));

        if (result.getStatus() != VALID) {
            return httpMessageContext.responseUnauthorized();
        }

        return httpMessageContext.notifyContainerAboutLogin(result.getCallerPrincipal(),
                                                            result.getCallerGroups());
    }

}
