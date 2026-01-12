package ex2.domain;

/**
 * Domain Exception - Raised when posting to social media fails
 */
public class PostingException extends Exception {
    public PostingException(String message) {
        super(message);
    }
    
    public PostingException(String message, Throwable cause) {
        super(message, cause);
    }
}
