package me.buggyal.particles.particle;

import me.buggyal.particles.particle.struct.AbstractParticle;
import me.buggyal.particles.particle.struct.SizeableParticle;

public class ParticleExplosionEmitter extends AbstractParticle implements SizeableParticle {

    private float size = 0;

    /**
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_0%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_1%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_2%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_3%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_4%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_5%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_6%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_7%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_8%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_9%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_10%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_11%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_12%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_13%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_14%29_JE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Explosion_%28texture_15%29_JE1.png" width="50" height="50">
     */

    public ParticleExplosionEmitter() {
        super("explosion_emitter");
    }

    @Override
    public AbstractParticle size(float size) {
        this.size = size;
        return this;
    }

    @Override
    public float getTrueSpeed() {
        return size;
    }

}
