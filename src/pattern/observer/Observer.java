package pattern.observer;

public interface Observer {

    // core method of Observer, which will be called from subject after any change
    void performAction();
}
