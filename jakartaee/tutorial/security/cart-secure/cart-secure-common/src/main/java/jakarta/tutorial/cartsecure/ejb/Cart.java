package jakarta.tutorial.cartsecure.ejb;


import java.util.List;

import jakarta.ejb.Remote;
import jakarta.tutorial.cartsecure.util.BookException;


@Remote public interface Cart {
    public void initialize(String person) throws BookException;

    public void initialize(String person, String id) throws BookException;

    public void addBook(String title);

    public void removeBook(String title) throws BookException;

    public List<String> getContents();

    public void remove();
}
