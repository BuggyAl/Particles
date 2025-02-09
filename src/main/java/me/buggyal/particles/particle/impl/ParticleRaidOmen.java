package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleRaidOmen extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Raid_Omen_particle_JE1.png" width="50" height="50">
     */

    public ParticleRaidOmen() {
        this.particleOptions = ParticleTypes.RAID_OMEN;
    }

}
