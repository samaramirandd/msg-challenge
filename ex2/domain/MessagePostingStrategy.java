package ex2.domain;

/**
 * Domain Abstraction - Strategy for posting messages to social media
 * This interface defines the contract for different social media posting strategies.
 * Each implementation handles authentication and posting for a specific platform.
 */
public interface MessagePostingStrategy {
    /**
     * Authenticates and posts a message to the social media service.
     *
     * @param message the message to post
     * @param credentials the authentication credentials for the service
     * @throws PostingException if authentication or posting fails
     */
    void postMessage(Message message, Credentials credentials) throws PostingException;
    
    /**
     * Gets the service type this strategy handles.
     */
    SocialMediaService getServiceType();
}
