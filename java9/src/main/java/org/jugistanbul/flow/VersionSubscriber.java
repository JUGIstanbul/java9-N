package org.jugistanbul.flow;

import static org.jugistanbul.constant.Constants.versionsAndFutures;

import java.util.Optional;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 31.03.2020
 **/

public class VersionSubscriber<T> implements Subscriber<T>
{

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
        System.out.println("Subscription started!");
    }

    @Override
    public void onNext(T item) {
        System.out.println("Got feature: " + item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Emission is completed!");
    }
}

class VersionPublisher
{

    public static void main(String[] args) throws InterruptedException {

        final SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        final VersionSubscriber<String> subscriber = new VersionSubscriber<>();
        publisher.subscribe(subscriber);

        versionsAndFutures.entrySet().stream().forEach(version ->
                Optional.ofNullable(version.getValue()).ifPresent(v -> v.forEach(publisher::submit))
        );

        TimeUnit.MILLISECONDS.sleep(100);
        publisher.close();

    }
}