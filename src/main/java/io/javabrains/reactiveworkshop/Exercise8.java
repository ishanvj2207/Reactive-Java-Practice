package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        // TODO: Write code here
        /**
         ReactiveSources.intNumbersFluxWithException()
         .doOnError(err -> System.out.println("Error Happened !!" + err.getMessage())) // do a side-effect and pass to flux
         .subscribe(num -> System.out.println(num)
         //                        err -> System.out.println("Error Happened!!") // used when we need to swallow error and not pass to downstream flux
         );
         **/

        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((err, num) -> System.out.println("Error Happened for " + num))
//                .subscribe(num -> System.out.println(num));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(num -> System.out.println(num));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
