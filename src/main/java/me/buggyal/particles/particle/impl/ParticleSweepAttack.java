package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleSweepAttack extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Sweep_%28texture_0%29_JE2.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sweep_%28texture_1%29_JE2.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sweep_%28texture_2%29_JE2.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sweep_%28texture_3%29_JE2.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sweep_%28texture_4%29_JE2.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sweep_%28texture_5%29_JE2.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sweep_%28texture_6%29_JE2.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sweep_%28texture_7%29_JE2.png" width="50" height="50">
     */

    public ParticleSweepAttack() {
        this.particleOptions = ParticleTypes.SWEEP_ATTACK;
    }

}
