package me.buggyal.particles.particle;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.bukkit.Material;
import org.bukkit.craftbukkit.util.CraftMagicNumbers;

public class ParticleBlockCrumble extends AbstractParticle {

    public ParticleBlockCrumble() {
        super("block_crumble");
        setMaterial(Material.GRASS_BLOCK);
    }

    public ParticleBlockCrumble setMaterial(Material material) {
        ParticleType<BlockParticleOption> option = (ParticleType<BlockParticleOption>) BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.fromNamespaceAndPath("minecraft", "block_crumble")).get().value();
        particleOptions = new BlockParticleOption(option, CraftMagicNumbers.getBlock(material).defaultBlockState());
        return this;
    }

}
