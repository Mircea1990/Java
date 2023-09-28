package jakarta.tutorial.clientsessionmdb.sb;

import jakarta.ejb.Remote;

/**
 * Remote interface for Publisher enterprise bean. Declares one business method.
 */
@Remote public interface PublisherRemote {
    public void publishNews();
}
