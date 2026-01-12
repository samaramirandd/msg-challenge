package ex2.domain;

/**
 * Domain Model - Message entity
 * Represents a message to be posted.
 */
public class Message {
    private final String id;
    private final String content;
    private final User author;
    
    public Message(String id, String content, User author) {
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Message content cannot be empty");
        }
        this.id = id;
        this.content = content;
        this.author = author;
    }
    
    public String getId() {
        return id;
    }
    
    public String getContent() {
        return content;
    }
    
    public User getAuthor() {
        return author;
    }
}
