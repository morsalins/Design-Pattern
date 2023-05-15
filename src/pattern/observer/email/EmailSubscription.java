package pattern.observer.email;

import pattern.observer.Observer;
import pattern.observer.Subject;

public class EmailSubscription implements Observer {

    private final Subject<String> subject;
    private final String name;
    private final String email;

    public EmailSubscription(Subject<String> subject, String name, String email) {
        this.name = name;
        this.subject = subject;
        this.email = email;
    }

    @Override
    public void performAction() {
        System.out.println("notifying email subscriber: " +  this.name);
        System.out.println("Sending email to: " + this.email);
        System.out.println("Message: " + this.subject.getPublishedData() + "\n");
    }

    public Subject<String> getSubject() {
        return subject;
    }

    public String getName() {
        return name;
    }
}
