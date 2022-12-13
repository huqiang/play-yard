package qiang.hu.functions;

import java.util.function.BiConsumer;

public class Functions {
    public void fibWithConsumer() {
        int[] fib = new int[2];
        final BiConsumer<Integer, Integer> fibConsumer = (a, b) -> {
            fib[0] = b;
            fib[1] = a + b;
        };

    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Hello world!"));
        Thread.interrupted();
        System.out.println("Hello world!");
    }



}
