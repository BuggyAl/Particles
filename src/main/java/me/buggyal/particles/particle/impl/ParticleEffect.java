package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleEffect extends AbstractParticle {

    // add "‎" invisible space to separate the images in the editor

    /**
     * <img src="https://minecraft.wiki/images/Effect_%28texture_7%29_JE1_BE1.png?" width="50" height="50">‎
     * <img src="https://minecraft.wiki/images/Effect_%28texture_6%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Effect_%28texture_5%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Effect_%28texture_4%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Effect_%28texture_3%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Effect_%28texture_2%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Effect_%28texture_1%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Effect_%28texture_0%29_JE1_BE1.png" width="50" height="50">
     */
    public ParticleEffect() {
        this.particleOptions = ParticleTypes.EFFECT;
    }

}
