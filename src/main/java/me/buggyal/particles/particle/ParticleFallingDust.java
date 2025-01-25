package me.buggyal.particles.particle;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.bukkit.Material;
import org.bukkit.craftbukkit.util.CraftMagicNumbers;

public class ParticleFallingDust extends AbstractParticle {

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
    public ParticleFallingDust() {
        super("falling_dust");
        material(Material.GRASS_BLOCK);
    }

    public ParticleFallingDust material(Material material) {
        ParticleType<BlockParticleOption> option = (ParticleType<BlockParticleOption>) BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.fromNamespaceAndPath("minecraft", "falling_dust")).get().value();
        particleOptions = new BlockParticleOption(option, CraftMagicNumbers.getBlock(material).defaultBlockState());
        return this;
    }

}
