package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleFirework extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Spark_%28texture_0%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Spark_%28texture_1%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Spark_%28texture_2%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Spark_%28texture_3%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Spark_%28texture_4%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Spark_%28texture_5%29_JE1_BE1.png" width="50" height="50">
     */

    public ParticleFirework() {
        this.particleOptions = ParticleTypes.FIREWORK;
    }

}
