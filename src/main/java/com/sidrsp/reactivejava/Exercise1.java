package com.sidrsp.reactivejava;

public class Exercise1 {

  public static void main(String[] args) {

    // Use StreamSources.intNumbersStream() and StreamSources.userStream()

    // Print all numbers in the intNumbersStream stream
    StreamSources.intNumbersStream()
        .forEach(System.out::println);

    System.out.println("----------");

    // Print numbers from intNumbersStream that are less than 5
    StreamSources.intNumbersStream()
        .filter(integer -> integer < 5)
        .forEach(System.out::println);

    System.out.println("----------");

    // Print the second and third numbers in intNumbersStream that's greater than 5

    StreamSources.intNumbersStream()
        .filter(integer -> integer > 5)
        .skip(1)
        .limit(2)
        .forEach(System.out::println);

    System.out.println("----------");

    //  Print the first number in intNumbersStream that's greater than 5.
    //  If nothing is found, print -1
    Integer first = StreamSources.intNumbersStream()
        .filter(integer -> integer > 5)
        .findFirst()
        .orElse(-1);
    System.out.println(first);

    System.out.println("----------");

    // Print first names of all users in userStream
    StreamSources.userStream()
        .forEach(user -> System.out.println(user.getFirstName()));

    System.out.println("----------");

    // Print first names in userStream for users that have IDs from number stream
    StreamSources.userStream()
        .filter(
            user -> StreamSources.intNumbersStream().anyMatch(integer -> user.getId() == integer))
        .forEach(user -> System.out.println(user.getFirstName()));

    System.out.println("----------");

    StreamSources.intNumbersStream()
        .flatMap(integer -> StreamSources.userStream().filter(user -> user.getId() == integer))
        .map(user -> user.getFirstName())
        .forEach(System.out::println);

    var value = StreamSources.intNumbersStream();

  }
}
