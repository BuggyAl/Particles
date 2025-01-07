package me.buggyal.particles.particle;

import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.bukkit.Color;

public class ParticleEntityEffect extends AbstractParticle {

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
    public ParticleEntityEffect() {
        super("entity_effect");
        ParticleType<ColorParticleOption> option = (ParticleType<ColorParticleOption>) BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.fromNamespaceAndPath("minecraft", "entity_effect")).get().value();
        particleOptions = ColorParticleOption.create(option, Color.BLACK.asRGB());
    }

    public ParticleEntityEffect color(Color color) {
        ParticleType<ColorParticleOption> option = (ParticleType<ColorParticleOption>) BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.fromNamespaceAndPath("minecraft", "entity_effect")).get().value();
        particleOptions = ColorParticleOption.create(option, color.asRGB());
        return this;
    }

}
