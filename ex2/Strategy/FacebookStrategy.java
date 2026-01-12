package ex2.Strategy;

public class FacebookStrategy implements MessagePostingStrategy{
    @Override
    public void postMessage(String message){
        System.out.println("Posting message to Facebook: " + message);
    }
}
