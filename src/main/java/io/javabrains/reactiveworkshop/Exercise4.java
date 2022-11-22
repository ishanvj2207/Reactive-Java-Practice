package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(num -> System.out.println(num));

        // Get the value from the Mono into an integer variable
        // TODO: Write code here
        Integer num = ReactiveSources.intNumberMono().block();
        System.out.println(num);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
