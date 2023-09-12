package fh.fep.yield;

import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

public class MyContinuation {
    // --enable-preview --add-exports java.base/jdk.internal.vm=ALL-UNNAMED
    public static void main(String[] args) {
        var sopce = new ContinuationScope("hello");
        var continuation = new Continuation(
                sopce, () -> {
                System.out.println("A");
                Continuation.yield(sopce);
                System.out.println("B");
            }
        );
        continuation.run();
        System.out.println("C");
        continuation.run();
        System.out.println("D");
    }
}
