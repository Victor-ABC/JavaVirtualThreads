package fh.fep.yield;


import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

public class MyContinuation {
    // --enable-preview --add-exports java.base/jdk.internal.vm=ALL-UNNAMED
    public static void main(String[] args) {
        var scope = new ContinuationScope("hello");
        var continuation = new Continuation(
                scope, () -> {
                System.out.println("A");
                Continuation.yield(scope); // Pointer ist bis hier her gekommen
                System.out.println("B");
            }
        );
        continuation.run();
        System.out.println("C");
        continuation.run();
        System.out.println("D");
    }
}