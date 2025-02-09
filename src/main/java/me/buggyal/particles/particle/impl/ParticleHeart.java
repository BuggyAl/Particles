package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleHeart extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Heart_%28texture%29_JE1_BE1.png" width="50" height="50">
     */
    public ParticleHeart() {
        this.particleOptions = ParticleTypes.HEART;
    }

}
