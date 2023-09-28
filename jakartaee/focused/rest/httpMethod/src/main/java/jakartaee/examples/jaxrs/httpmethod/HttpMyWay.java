package jakartaee.examples.jaxrs.httpmethod;

import java.net.URI;

import org.apache.http.client.methods.HttpRequestBase;

/**
 * The custom MYWAY HTTP method.
 */
public class HttpMyWay extends HttpRequestBase {

    /**
     * Constructor.
     */
    public HttpMyWay() {
        super();
    }

    /**
     * Constructor.
     *
     * @param uri the URI.
     */
    public HttpMyWay(final URI uri) {
        super();
        setURI(uri);
    }

    /**
     * Constructor.
     *
     * @param uri the URI.
     */
    public HttpMyWay(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    /**
     * Get the method.
     *
     * @return the method.
     */
    @Override public String getMethod() {
        return "MYWAY";
    }
}
