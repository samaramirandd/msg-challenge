package ex2.infrastructure.strategy;

import ex2.domain.*;

/**
 * Infrastructure Layer - Facebook Posting Strategy
 * Implements the concrete strategy for posting messages to Facebook.
 * This layer handles the integration details with Facebook API.
 */
public class FacebookStrategy implements MessagePostingStrategy {
    
    @Override
    public void postMessage(Message message, Credentials credentials) throws PostingException {
        try {
            // Authenticate with Facebook
            authenticate(credentials);
            
            // Post the message
            System.out.println("[Facebook] Posting message from " + 
                             message.getAuthor().getUsername() + ": " + 
                             message.getContent());
            
            // In a real scenario, this would call Facebook API/Graph
            simulateFacebookAPI(message.getContent());
            
        } catch (Exception e) {
            throw new PostingException("Failed to post to Facebook: " + e.getMessage(), e);
        }
    }
    
    @Override
    public SocialMediaService getServiceType() {
        return SocialMediaService.FACEBOOK;
    }
    
    private void authenticate(Credentials credentials) throws PostingException {
        System.out.println("[Facebook] Authenticating user: " + credentials.getUsername());
        // Simulate Facebook authentication
        if (credentials.getPassword().isEmpty()) {
            throw new PostingException("Invalid Facebook credentials");
        }
    }
    
    private void simulateFacebookAPI(String message) {
        System.out.println("[Facebook] ✓ Message posted successfully: " + message);
    }
}
