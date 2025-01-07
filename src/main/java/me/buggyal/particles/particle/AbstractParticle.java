package me.buggyal.particles.particle;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractParticle {

    protected ParticleOptions particleOptions;
    protected boolean overrideParticleLimit = false;
    protected boolean alwaysShowParticle = true;
    protected float offsetX = 0;
    protected float offsetY = 0;
    protected float offsetZ = 0;
    protected float speed = 0;
    protected int count = 0;

    protected AbstractParticle(String particleID) {
        this.particleOptions = (ParticleOptions) BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.fromNamespaceAndPath("minecraft", particleID)).orElseThrow(() -> new IllegalArgumentException("Invalid particle ID: " + particleID));
    }

    protected AbstractParticle overrideParticleLimit(boolean overrideParticleLimit) {
        this.overrideParticleLimit = overrideParticleLimit;
        return this;
    }

    protected AbstractParticle alwaysShowParticle(boolean alwaysShowParticle) {
        this.alwaysShowParticle = alwaysShowParticle;
        return this;
    }

    protected AbstractParticle offset(float offsetX, float offsetY, float offsetZ) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        return this;
    }

    protected AbstractParticle modifyOffset(float modX, float modY, float modZ) {
        this.offsetX += modX;
        this.offsetY += modY;
        this.offsetZ += modZ;
        return this;
    }

    protected Vector getTrueOffsets() {
        return new Vector();
    }

    protected final ThreadLocalRandom rng = ThreadLocalRandom.current();
    protected Vector generateFakeOffsets() {
        Vector fakeOffsets = new Vector();
        fakeOffsets.setX(rng.nextGaussian() * offsetX);
        fakeOffsets.setY(rng.nextGaussian() * offsetY);
        fakeOffsets.setZ(rng.nextGaussian() * offsetZ);
        return fakeOffsets;
    }

    public void display(Location location, List<CraftPlayer> players) {
        Validate.notNull(location, "Location cannot be null!");
        Validate.notNull(location.getWorld(), "World cannot be null!");
        for (int i = 0; i < count; i++) {
            for (CraftPlayer craftPlayer : players) {
                ServerPlayer player = craftPlayer.getHandle();
                Vector fakeOffsets = generateFakeOffsets();
                Vector trueOffsets = getTrueOffsets();
                player.connection.send(new ClientboundLevelParticlesPacket(
                        particleOptions,
                        overrideParticleLimit,
                        alwaysShowParticle,
                        location.x() + fakeOffsets.getX(),
                        location.y() + fakeOffsets.getY(),
                        location.z() + fakeOffsets.getZ(),
                        (float) trueOffsets.getX(),
                        (float) trueOffsets.getY(),
                        (float) trueOffsets.getZ(),
                        speed,
                        0
                ));
            }
        }
    }

}
