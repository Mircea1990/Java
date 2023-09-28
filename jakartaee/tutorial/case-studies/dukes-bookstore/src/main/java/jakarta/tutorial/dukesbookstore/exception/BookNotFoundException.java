package jakarta.tutorial.dukesbookstore.exception;

/**
 * <p>This application exception indicates that a book has not been found.</p>
 */
public class BookNotFoundException extends Exception {

    private static final long serialVersionUID = 8712363279947073702L;

    public BookNotFoundException() {
    }

    public BookNotFoundException(String msg) {
        super(msg);
    }
}
