package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleSoulFireFlame extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Soul_Flame_%28texture%29_JE1_BE1.png" width="50" height="50">
     */

    public ParticleSoulFireFlame() {
        this.particleOptions = ParticleTypes.SOUL_FIRE_FLAME;
    }

}
