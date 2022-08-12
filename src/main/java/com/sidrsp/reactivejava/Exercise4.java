package com.sidrsp.reactivejava;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(integer -> System.out.println(integer));

        // Get the value from the Mono into an integer variable
        Integer integer = ReactiveSources.intNumberMono().blockOptional().orElse(-1);
        System.out.println(integer);

        User user = ReactiveSources.userMono().block();
        assert user != null;
        System.out.println(user.getFirstName());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
