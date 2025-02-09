package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleInfested extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Infested_Particle_JE1.png" width="50" height="50">
     */
    public ParticleInfested() {
        this.particleOptions = ParticleTypes.INFESTED;
    }

}
