package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleDrippingLava extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Drip_Hang_%28texture%29_JE1_BE1.png" width="50" height="50">
     */

    public ParticleDrippingLava() {
        this.particleOptions = ParticleTypes.DRIPPING_LAVA;
    }

}
