package ex2.domain;

/**
 * Domain Enum - Supported social media services
 */
public enum SocialMediaService {
    TWITTER("Twitter"),
    FACEBOOK("Facebook");
    
    private final String displayName;
    
    SocialMediaService(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
