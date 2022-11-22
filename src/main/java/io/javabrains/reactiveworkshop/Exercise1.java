package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .forEach(num -> System.out.println(num));
        System.out.println("----");

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .filter(num -> num < 5)
                .forEach(num -> System.out.println(num));
        System.out.println("----");

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .filter(num -> num > 5)
                .skip(1)
                .limit(2)
                .forEach(num -> System.out.println(num));
        System.out.println("----");

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .filter(num -> num > 5)
                .findFirst()
                .ifPresentOrElse(num -> System.out.println(num), () -> System.out.println(-1));
        System.out.println("----");

        // Print first names of all users in userStream
        // TODO: Write code here
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(name -> System.out.println(name));
        System.out.println("----");

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream()
                        .anyMatch(num -> num == user.getId()))
                .forEach(user -> System.out.println(user.getFirstName()));

        // Using Flatmap
        StreamSources.intNumbersStream()
                .flatMap(num -> StreamSources.userStream().filter(user -> user.getId() == num))
                .forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("----");
    }
}
