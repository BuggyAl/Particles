package me.buggyal.particles.misc;

import java.util.concurrent.ThreadLocalRandom;

public class Distribution {

    private Distribution() {
        throw new IllegalStateException("Utility class");
    }

    private static final ThreadLocalRandom rng = ThreadLocalRandom.current();

    public static double uniform(double bound) {
        return rng.nextDouble(bound);
    }

    public static double gaussian(double bound) {
        return rng.nextGaussian() * bound;
    }

    public static double gaussianTruncated(double bound) {
        double u1 = rng.nextDouble();
        double u2 = rng.nextDouble();
        return 2 * Math.sqrt(-2 * Math.log(u1)) * Math.cos(2 * Math.PI * u2) * bound - bound;
    }

}
