package pattern.observer;

public interface Subject<T> {

    // core method of observer design pattern, register or add an observer to the subject
    void subscribe(Observer obj);

    // core method of observer design pattern, unregister or remove an observer from the subject
    void unsubscribe(Observer obj);

    // core method of observer design pattern, notify the subject when changed happens.
    // notify will call corresponding observers method
    void notifyObservers();

    // optional method (user for just example). used for publishing data to all observer
    T getPublishedData();
}
