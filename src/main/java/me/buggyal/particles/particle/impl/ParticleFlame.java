package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleFlame extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Flame_%28texture%29_JE1_BE1.png" width="50" height="50">
     */

    public ParticleFlame() {
        this.particleOptions = ParticleTypes.FLAME;
    }

}
