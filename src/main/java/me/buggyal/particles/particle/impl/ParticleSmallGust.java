package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleSmallGust extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Small_Gust_%28Texture_0%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Small_Gust_%28Texture_1%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Small_Gust_%28Texture_2%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Small_Gust_%28Texture_3%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Small_Gust_%28Texture_4%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Small_Gust_%28Texture_5%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Small_Gust_%28Texture_6%29.png" width="50" height="50">
     */

    public ParticleSmallGust() {
        this.particleOptions = ParticleTypes.SMALL_GUST;
    }

}
