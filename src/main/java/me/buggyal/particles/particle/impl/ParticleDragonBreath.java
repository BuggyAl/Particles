package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleDragonBreath extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Smoke_%28texture_7%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Smoke_%28texture_6%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Smoke_%28texture_5%29_JE1_BE1.png" width="50" height="50">
     */

    public ParticleDragonBreath() {
        this.particleOptions = ParticleTypes.DRAGON_BREATH;
    }

}
