package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleDamageIndicator extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Damage_Indicator_%28texture%29_JE1.png" width="50" height="50">
     */
    public ParticleDamageIndicator() {
        this.particleOptions = ParticleTypes.DAMAGE_INDICATOR;
    }

}
