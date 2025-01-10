package me.buggyal.particles.util;

import java.util.concurrent.ThreadLocalRandom;

public class Distribution {

    private Distribution() {
        throw new IllegalStateException("Utility class");
    }

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static double boundedGaussian(double bound) {
        if (Math.abs(bound) == 0) return 0;
        return Math.tanh(random.nextGaussian()) * Math.abs(bound);
    }

    public static double gaussian(double bound) {
        return random.nextGaussian() * bound;
    }

    public static ThreadLocalRandom getRandom() {
        return random;
    }

}
