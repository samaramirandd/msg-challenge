package ex2.infrastructure.strategy;

import ex2.domain.*;

/**
 * Infrastructure Layer - Twitter Posting Strategy
 * Implements the concrete strategy for posting messages to Twitter.
 * This layer handles the integration details with Twitter API.
 */
public class TwitterStrategy implements MessagePostingStrategy {
    
    @Override
    public void postMessage(Message message, Credentials credentials) throws PostingException {
        try {
            // Authenticate with Twitter
            authenticate(credentials);
            
            // Post the message
            String twitterMessage = formatMessageForTwitter(message.getContent());
            System.out.println("[Twitter] Posting message from @" + 
                             message.getAuthor().getUsername() + ": " + twitterMessage);
            
            // In a real scenario, this would call Twitter API
            simulateTwitterAPI(twitterMessage);
            
        } catch (Exception e) {
            throw new PostingException("Failed to post to Twitter: " + e.getMessage(), e);
        }
    }
    
    @Override
    public SocialMediaService getServiceType() {
        return SocialMediaService.TWITTER;
    }
    
    private void authenticate(Credentials credentials) throws PostingException {
        System.out.println("[Twitter] Authenticating user: " + credentials.getUsername());
        // Simulate Twitter authentication
        if (credentials.getPassword().isEmpty()) {
            throw new PostingException("Invalid Twitter credentials");
        }
    }
    
    private String formatMessageForTwitter(String content) {
        // Twitter has 280 character limit
        return content.length() > 280 ? content.substring(0, 280) : content;
    }
    
    private void simulateTwitterAPI(String message) {
        System.out.println("[Twitter] ✓ Message posted successfully: " + message);
    }
}
