package me.buggyal.particles.particle;

import me.buggyal.particles.misc.Distribution;
import me.buggyal.particles.misc.OffsetType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;

public abstract class AbstractParticle {

    protected ParticleOptions particleOptions;
    protected boolean overrideParticleLimit = false;
    protected boolean alwaysShowParticle = true;
    protected Vector offsets = new Vector();
    protected float speed = 0;
    protected int count = 0;
    protected OffsetType offsetType = OffsetType.GAUSSIAN_TRUNCATED;

    protected AbstractParticle(String particleID) {
        this.particleOptions = (ParticleOptions) BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.fromNamespaceAndPath("minecraft", particleID)).orElseThrow(() -> new IllegalArgumentException("Invalid particle ID: " + particleID)).value();
    }

    public AbstractParticle overrideParticleLimit(boolean overrideParticleLimit) {
        this.overrideParticleLimit = overrideParticleLimit;
        return this;
    }

    public AbstractParticle alwaysShowParticle(boolean alwaysShowParticle) {
        this.alwaysShowParticle = alwaysShowParticle;
        return this;
    }

    public AbstractParticle offset(float offsetX, float offsetY, float offsetZ) {
        offsets.setX(offsetX);
        offsets.setY(offsetY);
        offsets.setZ(offsetZ);
        return this;
    }

    public AbstractParticle modifyOffset(float modX, float modY, float modZ) {
        offsets.setX(offsets.getX() + modX);
        offsets.setY(offsets.getY() + modY);
        offsets.setZ(offsets.getZ() + modZ);
        return this;
    }

    public AbstractParticle speed(float speed) {
        this.speed = speed;
        return this;
    }

    public AbstractParticle count(int count) {
        this.count = count;
        return this;
    }

    public AbstractParticle offsetType(OffsetType offsetType) {
        this.offsetType = offsetType;
        return this;
    }

    public Vector getTrueOffsets() {
        return new Vector();
    }

    protected Vector generateFakeOffsets() {
        Vector fakeOffsets = new Vector();

        switch (offsetType) {
            case GAUSSIAN -> {
                fakeOffsets.setX((float) Distribution.gaussian(offsets.getX()));
                fakeOffsets.setY((float) Distribution.gaussian(offsets.getY()));
                fakeOffsets.setZ((float) Distribution.gaussian(offsets.getZ()));
            }
            case UNIFORM -> {
                fakeOffsets.setX((float) Distribution.uniform(offsets.getX()) * 2 - offsets.getX());
                fakeOffsets.setY((float) Distribution.uniform(offsets.getY()) * 2 - offsets.getY());
                fakeOffsets.setZ((float) Distribution.uniform(offsets.getZ()) * 2 - offsets.getZ());
            }
            default -> {
                fakeOffsets.setX((float) Distribution.gaussianTruncated(offsets.getX()));
                fakeOffsets.setY((float) Distribution.gaussianTruncated(offsets.getY()));
                fakeOffsets.setZ((float) Distribution.gaussianTruncated(offsets.getZ()));
            }
        }
        return fakeOffsets;
    }

    public void display(Location location, List<Player> players) {

        List<CraftPlayer> craftPlayers = players.stream()
                .map(CraftPlayer.class::cast)
                .toList();

        Validate.notNull(location, "Location cannot be null!");
        Validate.notNull(location.getWorld(), "World cannot be null!");

        int loopCount = count;
        if (loopCount == 0) loopCount = 1;

        for (int i = 0; i < loopCount; i++) {
            for (CraftPlayer craftPlayer : craftPlayers) {
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
