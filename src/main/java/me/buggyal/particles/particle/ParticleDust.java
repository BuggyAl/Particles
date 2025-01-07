package me.buggyal.particles.particle;

import net.minecraft.core.particles.DustParticleOptions;
import org.bukkit.Color;

public class ParticleDust extends AbstractParticle {

    private Color color = Color.fromRGB(0, 0, 0);
    private float scale = 1;

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
        super("dust");
    }

    public ParticleDust color(Color color) {
        this.color = color;
        particleOptions = new DustParticleOptions(color.asRGB(), scale);
        return this;
    }

    public ParticleDust scale(float scale) {
        this.scale = scale;
        particleOptions = new DustParticleOptions(color.asRGB(), scale);
        return this;
    }

}
