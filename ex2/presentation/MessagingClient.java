package ex2.presentation;

import ex2.application.*;
import ex2.domain.*;

/**
 * Presentation Layer - Client demonstrating the messaging use case
 * Shows how users interact with the messaging system.
 * In a real mobile app, this would be the UI layer.
 */
public class MessagingClient {
    
    public static void main(String[] args) {
        try {
            // Setup: Create dependencies
            MessageStrategyFactory factory = new MessageStrategyFactory();
            PostMessageUseCase postMessageUseCase = new PostMessageUseCase(factory);
            
            // Scenario: Authenticated user posts a message to Twitter
            User user = new User("user123", "samara_miranda");
            String messageText = "Hello from Clean Architecture! #design";
            Credentials twitterCredentials = new Credentials("samara_miranda", "twitter_password");
            
            System.out.println("=== Post Message to Twitter ===");
            postMessageUseCase.execute(user, messageText, SocialMediaService.TWITTER, twitterCredentials);
            
            System.out.println("\n=== Post Message to Facebook ===");
            Credentials facebookCredentials = new Credentials("samara.miranda", "facebook_password");
            postMessageUseCase.execute(user, messageText, SocialMediaService.FACEBOOK, facebookCredentials);
            
            // Example: Attempting to post to multiple platforms
            System.out.println("\n=== Post to Multiple Platforms ===");
            String[] platforms = {"Twitter", "Facebook"};
            for (String platform : platforms) {
                SocialMediaService service = SocialMediaService.valueOf(platform.toUpperCase());
                Credentials creds = new Credentials("user_" + platform.toLowerCase(), "password");
                postMessageUseCase.execute(user, "Check this out! 🚀", service, creds);
            }
            
        } catch (PostingException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
