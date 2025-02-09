package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import me.buggyal.particles.particle.struct.ColorableParticle;
import me.buggyal.particles.particle.struct.SizeableParticle;
import net.minecraft.core.particles.DustParticleOptions;
import org.bukkit.Color;

public class ParticleDust extends AbstractParticle implements ColorableParticle, SizeableParticle {

    private Color color = Color.fromRGB(0, 0, 0);
    private float size = 1;

    /**
     * <img src="https://minecraft.wiki/images/Smoke_%28texture_7%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Smoke_%28texture_6%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Smoke_%28texture_5%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Smoke_%28texture_4%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Smoke_%28texture_3%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Smoke_%28texture_2%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Smoke_%28texture_1%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Totem_Particle_%28texture_0%29_JE1_BE1.png" width="50" height="50">
     */
    public ParticleDust() {
        particleOptions = new DustParticleOptions(color.asRGB(), size);
    }

    @Override
    public ParticleDust color(Color color) {
        this.color = color;
        particleOptions = new DustParticleOptions(color.asRGB(), size);
        return this;
    }

    @Override
    public ParticleDust size(float scale) {
        this.size = scale;
        particleOptions = new DustParticleOptions(color.asRGB(), scale);
        return this;
    }

}
