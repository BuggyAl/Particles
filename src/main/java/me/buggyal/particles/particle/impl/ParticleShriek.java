package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ShriekParticleOption;

public class ParticleShriek extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Shriek_BE1.png" width="50" height="50">
     */

    public ParticleShriek() {
        delay(0);
    }

    public ParticleShriek delay(int delay) {
        particleOptions = new ShriekParticleOption(delay);
        return this;
    }

}
