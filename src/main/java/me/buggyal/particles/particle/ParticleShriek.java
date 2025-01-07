package me.buggyal.particles.particle;

import net.minecraft.core.particles.ShriekParticleOption;

public class ParticleShriek extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Shriek_BE1.png" width="50" height="50">
     */

    public ParticleShriek() {
        super("shriek");
        delay(0);
    }

    public ParticleShriek delay(int delay) {
        particleOptions = new ShriekParticleOption(delay);
        return this;
    }

}
