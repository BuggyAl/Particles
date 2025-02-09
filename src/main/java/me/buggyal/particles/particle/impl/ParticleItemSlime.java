package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleItemSlime extends AbstractParticle {

    public ParticleItemSlime() {
        this.particleOptions = ParticleTypes.ITEM_SLIME;
    }

}
