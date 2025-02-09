package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleAngryVillager extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Angry_Villager_%28texture%29_JE1_BE1.png" width="50" height="50">
     */
    public ParticleAngryVillager() {
        this.particleOptions = ParticleTypes.ANGRY_VILLAGER;
    }

}
