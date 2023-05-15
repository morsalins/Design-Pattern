package pattern.observer.email;

import pattern.observer.Observer;
import pattern.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class EmailPublisher<T> implements Subject<T> {

    private final List<Observer> observers;
    private final String topicName;
    private T msg;

    public EmailPublisher(String topicName) {
        this.observers = new ArrayList<>();
        this.topicName = topicName;
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
        System.out.println("new observer added to EmailPublisher, topicName: " + this.topicName + ", total observer: " + this.observers.size());
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
        System.out.println("new observer removed from EmailPublisher, topicName: " + this.topicName + ", total subscriber: " + this.observers.size());
    }

    @Override
    public void notifyObservers() {
        System.out.println("notifying all " + this.observers.size() +  " observers of EmailPublisher, topicName: " + this.topicName);
        for (Observer observer : this.observers) {
            observer.performAction();
        }
    }

    @Override
    public T getPublishedData() {
        return this.msg;
    }

    public void postMessage(T msg) {
        this.setMsg(msg);
        System.out.println("Posting email from EmailPublisher, topic name: "+ this.topicName + ", message: " + this.getMsg());
        notifyObservers();
    }

    public String getTopicName() {
        return topicName;
    }

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }
}
