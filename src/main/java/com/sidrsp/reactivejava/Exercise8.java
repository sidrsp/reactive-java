package com.sidrsp.reactivejava;

import java.io.IOException;
import reactor.core.publisher.SignalType;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

      // Use ReactiveSources.intNumbersFluxWithException()

      // Print values from intNumbersFluxWithException and print a message when error happens
      // TODO: Write code here
        /*ReactiveSources.intNumbersFluxWithException()
            .subscribe(
                integer -> System.out.println(integer),
                err -> System.out.println("error happened")
                );*/

        /*ReactiveSources.intNumbersFluxWithException()
            .doOnError(err -> System.out.println("error happened"))
            .subscribe(integer -> System.out.println(integer));*/

      // Print values from intNumbersFluxWithException and continue on errors
      // TODO: Write code here
        /*ReactiveSources.intNumbersFluxWithException()
            .onErrorContinue((err, item )-> System.out.println("error happened - " + item))
            .subscribe(integer -> System.out.println(integer));*/

      // Print values from intNumbersFluxWithException and when errors
      // happen, replace with a fallback sequence of -1 and -2
      // TODO: Write code here
        /*ReactiveSources.intNumbersFluxWithException()
            .onErrorResume(err -> Flux.just(-1, -2))
            .subscribe(integer -> System.out.println(integer));*/

      ReactiveSources.intNumbersFluxWithException()
          .doFinally(signalType -> {
            if (signalType == SignalType.ON_COMPLETE) {
              System.out.println("Done!!");
            } else if (signalType == SignalType.ON_ERROR) {
              System.out.println("Error!!");
            }
          })
          .subscribe(integer -> System.out.println(integer));

      System.out.println("Press a key to end");
      System.in.read();
    }

}
