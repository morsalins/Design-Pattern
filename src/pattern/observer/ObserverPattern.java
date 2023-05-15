package pattern.observer;

import pattern.observer.email.EmailPublisher;
import pattern.observer.email.EmailSubscription;

public class ObserverPattern {

    public static void execute() {
        executeEmailPublisher();
    }

    private static void executeEmailPublisher() {
        EmailPublisher<String> emailPublisher = new EmailPublisher<>("topic-mail-publisher-1");

        Observer mailObserver1 = new EmailSubscription(emailPublisher, "mailObserver1", "observer1@abc.com");
        Observer mailObserver2 = new EmailSubscription(emailPublisher, "mailObserver2", "observer2@abc.com");
        Observer mailObserver3 = new EmailSubscription(emailPublisher, "mailObserver3", "observer3@abc.com");
        Observer mailObserver4 = new EmailSubscription(emailPublisher, "mailObserver4", "observer4@abc.com");

        emailPublisher.subscribe(mailObserver1);
        emailPublisher.subscribe(mailObserver2);
        emailPublisher.subscribe(mailObserver3);
        emailPublisher.subscribe(mailObserver4);
        emailPublisher.postMessage("New Announcement from emailPublisher .........");

        emailPublisher.unsubscribe(mailObserver2);
        emailPublisher.unsubscribe(mailObserver3);
        emailPublisher.postMessage("New Announcement from emailPublisher after unsubscribing.........");
    }
}
