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

    // don't ask why i'm using this, if any PhD in math sees this, please actually make it resemble standard distribution :)
    private static final double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2;

    public static double exponential(double bound) {
        double value = Math.pow(rng.nextDouble(), GOLDEN_RATIO) * bound;
        return rng.nextBoolean() ? -value : value;
    }

}
