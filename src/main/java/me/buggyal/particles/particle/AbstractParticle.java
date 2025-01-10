package me.buggyal.particles.particle;

import me.buggyal.particles.util.Distribution;
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
    protected boolean enhanceOffsets = true;

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

    public AbstractParticle enhanceOffsets(boolean enhanceOffsets) {
        this.enhanceOffsets = enhanceOffsets;
        return this;
    }

    public Vector getTrueOffsets() {
        return new Vector();
    }

    protected Vector generateFakeOffsets() {
        Vector fakeOffsets = new Vector();
        if (enhanceOffsets) {
            fakeOffsets.setX(Distribution.boundedGaussian(offsets.getX()));
            fakeOffsets.setY(Distribution.boundedGaussian(offsets.getY()));
            fakeOffsets.setZ(Distribution.boundedGaussian(offsets.getY()));
        } else {
            fakeOffsets.setX(Distribution.gaussian(offsets.getX()));
            fakeOffsets.setY(Distribution.gaussian(offsets.getY()));
            fakeOffsets.setZ(Distribution.gaussian(offsets.getZ()));
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
