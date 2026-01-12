package ex2.domain;

/**
 * Domain Model - Credentials for social media services
 * Encapsulates authentication data.
 */
public class Credentials {
    private final String username;
    private final String password;
    
    public Credentials(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}
