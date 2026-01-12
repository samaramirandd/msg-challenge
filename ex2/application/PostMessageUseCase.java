package ex2.application;

import ex2.domain.*;

/**
 * Application Layer - Use Case for posting messages
 * Orchestrates the posting of a message to a selected social media service.
 * This implements the business logic for the "Post Message" use case.
 */
public class PostMessageUseCase {
    private final MessageStrategyFactory strategyFactory;
    
    public PostMessageUseCase(MessageStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }
    
    /**
     * Executes the "Post Message" use case.
     * 
     * @param user the authenticated user posting the message
     * @param messageContent the content of the message
     * @param service the social media service to post to
     * @param credentials the credentials for the service
     * @throws PostingException if the posting fails
     */
    public void execute(User user, String messageContent, 
                       SocialMediaService service, Credentials credentials) 
            throws PostingException {
        
        // Validate inputs (business rules)
        validateMessageContent(messageContent);
        validateCredentials(credentials);
        
        // Create message entity
        Message message = new Message(generateMessageId(), messageContent, user);
        
        // Get appropriate strategy for the service
        MessagePostingStrategy strategy = strategyFactory.createStrategy(service);
        
        // Execute posting
        strategy.postMessage(message, credentials);
    }
    
    private void validateMessageContent(String content) throws PostingException {
        if (content == null || content.trim().isEmpty()) {
            throw new PostingException("Message content cannot be empty");
        }
        if (content.length() > 500) {
            throw new PostingException("Message exceeds maximum length of 500 characters");
        }
    }
    
    private void validateCredentials(Credentials credentials) throws PostingException {
        if (credentials == null) {
            throw new PostingException("Credentials are required");
        }
    }
    
    private String generateMessageId() {
        return "MSG_" + System.currentTimeMillis();
    }
}
