package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleCrit extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Crit_%28texture%29_JE2.png" width="50" height="50">
     */
    public ParticleCrit() {
        this.particleOptions = ParticleTypes.CRIT;
    }

}
