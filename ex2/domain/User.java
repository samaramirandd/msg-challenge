package ex2.domain;

/**
 * Domain Model - User entity
 * Represents an authenticated user in the system.
 */
public class User {
    private final String id;
    private final String username;
    
    public User(String id, String username) {
        this.id = id;
        this.username = username;
    }
    
    public String getId() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }
}
