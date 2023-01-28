package com.sidrsp.reactivejava;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumbersFlux()

    // Get all numbers in the ReactiveSources.intNumbersFlux stream
    // into a List and print the list and its size
    List<Integer> integers = ReactiveSources.intNumbersFlux()
        .log()
        .toStream()  // this is blocking operation and waits till all elements is published
        .toList();
    System.out.println(integers.size());
    System.out.println(integers);

//        System.out.println("Press a key to end");
//        System.in.read();
  }

}
