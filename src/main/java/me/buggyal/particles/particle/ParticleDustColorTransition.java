package me.buggyal.particles.particle;

import net.minecraft.core.particles.DustColorTransitionOptions;
import net.minecraft.core.particles.DustParticleOptions;
import org.bukkit.Color;

public class ParticleDustColorTransition extends AbstractParticle {

    private Color fromColor = Color.fromRGB(0, 0, 0);
    private Color toColor = Color.fromRGB(255, 255, 255);
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
    public ParticleDustColorTransition() {
        super("dust_color_transition");
    }

    public ParticleDustColorTransition colors(Color fromColor, Color toColor) {
        this.fromColor = fromColor;
        this.toColor = toColor;
        particleOptions = new DustColorTransitionOptions(fromColor.asRGB(), toColor.asRGB(), scale);
        return this;
    }

    public ParticleDustColorTransition fromColor(Color fromColor) {
        this.fromColor = fromColor;
        particleOptions = new DustColorTransitionOptions(fromColor.asRGB(), toColor.asRGB(), scale);
        return this;
    }

    public ParticleDustColorTransition toColor(Color toColor) {
        this.toColor = toColor;
        particleOptions = new DustColorTransitionOptions(fromColor.asRGB(), toColor.asRGB(), scale);
        return this;
    }

    public ParticleDustColorTransition scale(float scale) {
        this.scale = scale;
        particleOptions = new DustColorTransitionOptions(fromColor.asRGB(), toColor.asRGB(), scale);
        return this;
    }

}
