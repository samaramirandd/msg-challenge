package ex2.application;

import ex2.domain.MessagePostingStrategy;
import ex2.domain.SocialMediaService;
import ex2.infrastructure.strategy.FacebookStrategy;
import ex2.infrastructure.strategy.TwitterStrategy;

/**
 * Application Factory - Creates appropriate strategy instances
 * Acts as a bridge between Application and Infrastructure layers.
 */
public class MessageStrategyFactory {
    
    /**
     * Creates a strategy for the given social media service.
     *
     * @param service the social media service
     * @return the appropriate strategy implementation
     * @throws IllegalArgumentException if service is not supported
     */
    public MessagePostingStrategy createStrategy(SocialMediaService service) {
        return switch (service) {
            case TWITTER -> new TwitterStrategy();
            case FACEBOOK -> new FacebookStrategy();
        };
    }
}
