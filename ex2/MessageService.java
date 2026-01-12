package ex2;

import ex2.Strategy.MessagePostingStrategy;

public class MessageService {
    private MessagePostingStrategy strategy;

    public void setStrategy(MessagePostingStrategy strategy){
        this.strategy = strategy;
    }

    public void post(String message){
        strategy.postMessage(message);
    }
}
