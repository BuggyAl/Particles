package me.buggyal.particles.misc;

import java.util.concurrent.ThreadLocalRandom;

public class Distribution {

    private Distribution() {
        throw new IllegalStateException("Utility class");
    }

    private static final ThreadLocalRandom rng = ThreadLocalRandom.current();

    public static double uniform(double bound) {
        return rng.nextDouble(-bound, bound);
    }

    public static double gaussian(double bound) {
        return rng.nextGaussian() * bound;
    }

    public static double exponential(double bound) {
        double value = rng.nextDouble() * Math.E * bound;
        return rng.nextBoolean() ? -value : value;
    }

}
