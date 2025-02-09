package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleTrailOmen extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Trial_Omen_Particle_JE1.png" width="50" height="50">
     */

    public ParticleTrailOmen() {
        this.particleOptions = ParticleTypes.TRIAL_OMEN;
    }

}
