package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleLava extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Lava_%28particle_texture%29_JE1_BE1.png" width="50" height="50">
     */

    public ParticleLava() {
        this.particleOptions = ParticleTypes.LAVA;
    }

}
