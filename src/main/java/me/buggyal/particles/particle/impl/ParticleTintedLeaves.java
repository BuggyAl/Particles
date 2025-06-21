package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import me.buggyal.particles.particle.struct.ColorableParticle;
import me.buggyal.particles.particle.struct.SizeableParticle;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.bukkit.Color;

public class ParticleTintedLeaves extends AbstractParticle implements ColorableParticle {

    /**
     * <img src="https://minecraft.wiki/images/Tinted_Leaf_%28texture_0%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Tinted_Leaf_%28texture_1%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Tinted_Leaf_%28texture_2%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Tinted_Leaf_%28texture_3%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Tinted_Leaf_%28texture_4%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Tinted_Leaf_%28texture_5%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Tinted_Leaf_%28texture_6%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Tinted_Leaf_%28texture_7%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Tinted_Leaf_%28texture_8%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Tinted_Leaf_%28texture_9%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Tinted_Leaf_%28texture_10%29.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Tinted_Leaf_%28texture_11%29.png" width="50" height="50">
     */
    public ParticleTintedLeaves() {
        color(Color.BLACK);
    }

    @Override
    public ParticleTintedLeaves color(Color color) {
        ParticleType<ColorParticleOption> option = (ParticleType<ColorParticleOption>) BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.fromNamespaceAndPath("minecraft", "tinted_leaves")).get().value();
        particleOptions = ColorParticleOption.create(option, color.asARGB());
        return this;
    }

}
