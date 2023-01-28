package com.sidrsp.reactivejava;

import java.io.IOException;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

    // Subscribe to a flux using the error and completion hooks
        /*ReactiveSources.intNumbersFlux()
            .subscribe(
                num -> System.out.println(num),
                errThrowable -> System.out.println(errThrowable.getMessage()),
                () -> System.out.println("Complete")
            );*/


    // Subscribe to a flux using an implementation of BaseSubscriber
    ReactiveSources.userFlux()
        .subscribe(new MySubscriber<>());

    System.out.println("Press a key to end");
    System.in.read();
  }

}

class MySubscriber<T> extends BaseSubscriber<T> {

  @Override
  protected void hookOnSubscribe(Subscription subscription) {
    System.out.println("Subscribed");
    request(1); // backpressure
  }

  @Override
  protected void hookOnNext(T value) {
    System.out.println("Received : " + value);
    request(1); // backpressure
  }

  @Override
  protected void hookOnComplete() {
    System.out.println("Complete");
  }

  @Override
  protected void hookOnError(Throwable throwable) {
    System.out.println(throwable.getMessage());
  }
}
