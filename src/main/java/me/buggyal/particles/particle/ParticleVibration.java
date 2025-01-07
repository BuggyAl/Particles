package me.buggyal.particles.particle;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.VibrationParticleOption;
import net.minecraft.world.level.gameevent.BlockPositionSource;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Location;

public class ParticleVibration extends AbstractParticle {

    private PositionSource destination = toBlockPositionSource(new Vec3(0, 0, 0));
    private int durationTicks = 20;

    public ParticleVibration() {
        super("vibration");
        particleOptions = new VibrationParticleOption(destination, durationTicks);
    }

    public ParticleVibration destination(Location destination) {
        this.destination = toBlockPositionSource(destination);
        particleOptions = new VibrationParticleOption(toBlockPositionSource(destination), durationTicks);
        return this;
    }

    public ParticleVibration durationTicks(int durationTicks) {
        this.durationTicks = durationTicks;
        particleOptions = new VibrationParticleOption(destination, durationTicks);
        return this;
    }

    private BlockPositionSource toBlockPositionSource(Vec3 location) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos(location.x(), location.y(), location.z());
        return new BlockPositionSource(mutableBlockPos);
    }

    private BlockPositionSource toBlockPositionSource(Location location) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        return new BlockPositionSource(mutableBlockPos);
    }

}
