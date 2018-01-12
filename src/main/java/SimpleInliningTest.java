

import java.util.logging.Logger;

/**
 * This test is supposed to show the performance impact of 2 different code patterns.
 * {@link #wrongLog(long)} is supposed to be too big (its bytecode size) to be inlined and that's could be seen:
 * - inspecting the compilation log by running the application with -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining
 * - copying the source (that's why it is in the base package :P) into https://github.com/AdoptOpenJDK/jitwatch Sandbox and having fun with it
 * <p>
 * notes:
 * it uses an ancient and unsafe technique to avoid dead code removal, JMH would be better, but JitWatch's Sandbox is the main consumer of this.
 */
public class SimpleInliningTest {

    /**
     * Inlining rules:
     * http://hg.openjdk.java.net/jdk8u/jdk8u/hotspot/file/448a5dcf414f/src/share/vm/opto/bytecodeInfo.cpp#l311
     */
    public static void main(String[] args) {
        long l = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_0000; i++) {
            l = wrongLog(l);
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("wrong tooks " + elapsed);
        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_0000; i++) {
            l = rightLog(l);
        }
        elapsed = System.currentTimeMillis() - start;
        System.out.println("right tooks " + elapsed);
        //do not try this @ home and use JMH instead ;)
        System.out.println(l);
    }

    public static final boolean LOG = false;

    public static boolean isLogEnabled() {
        return LOG;
    }

    private static final Logger logger = Logger.getLogger(SimpleInliningTest.class.getSimpleName());

    public static long rightLog(final long b) {
        if (isLogEnabled()) {
            log(b);
        }
        return b + 1;
    }

    public static long wrongLog(final long b) {
        if (isLogEnabled()) {
            //long logic to create the String used for logging
            final StringBuilder builder = new StringBuilder();
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            builder.append(b);
            logger.info(builder.toString());
        }
        return b + 1;
    }

    private static void log(final long b) {
        //long logic to create the String used for logging
        final StringBuilder builder = new StringBuilder();
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        builder.append(b);
        logger.info(builder.toString());
    }

}