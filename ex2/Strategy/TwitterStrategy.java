package ex2.Strategy;

public class TwitterStrategy implements MessagePostingStrategy {
    @Override
    public void postMessage(String message) {
        System.out.println("Posting message to Twitter: " + message);
    }
}