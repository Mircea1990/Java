package jakarta.tutorial.dukesbookstore.exception;

/**
 * <p>This application exception indicates that books have not been found.</p>
 */
public class BooksNotFoundException extends Exception {

    private static final long serialVersionUID = 4156679691884326238L;

    public BooksNotFoundException() {
    }

    public BooksNotFoundException(String msg) {
        super(msg);
    }
}
