package me.buggyal.particles.particle;

import me.buggyal.particles.particle.struct.AbstractParticle;
import me.buggyal.particles.particle.struct.MaterialParticle;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.bukkit.Material;
import org.bukkit.craftbukkit.util.CraftMagicNumbers;

public class ParticleBlockMarker extends AbstractParticle implements MaterialParticle {

    public ParticleBlockMarker() {
        super("block_marker");
        material(Material.GRASS_BLOCK);
    }

    public ParticleBlockMarker material(Material material) {
        ParticleType<BlockParticleOption> option = (ParticleType<BlockParticleOption>) BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.fromNamespaceAndPath("minecraft", "block_marker")).get().value();
        particleOptions = new BlockParticleOption(option, CraftMagicNumbers.getBlock(material).defaultBlockState());
        return this;
    }

}
