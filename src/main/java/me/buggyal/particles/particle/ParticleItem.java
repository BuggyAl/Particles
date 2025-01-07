package me.buggyal.particles.particle;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.bukkit.Material;

public class ParticleItem extends AbstractParticle {

    public ParticleItem() {
        super("item");
        material(Material.GRASS_BLOCK);
    }

    public ParticleItem material(Material material) {
        ParticleType<ItemParticleOption> option = (ParticleType<ItemParticleOption>) BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.fromNamespaceAndPath("minecraft", "item")).get().value();
        particleOptions = new ItemParticleOption(option, ItemStack.fromBukkitCopy(new org.bukkit.inventory.ItemStack(material)));
        return this;
    }

}
