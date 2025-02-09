package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleOminousSpawning extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Ominous_Spawning_JE1.png" width="50" height="50">
     */

    public ParticleOminousSpawning() {
        this.particleOptions = ParticleTypes.OMINOUS_SPAWNING;
    }

}
