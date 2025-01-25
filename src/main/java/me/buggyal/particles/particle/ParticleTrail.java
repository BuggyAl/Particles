package me.buggyal.particles.particle;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.TrailParticleOption;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Color;
import org.bukkit.Location;

public class ParticleTrail extends AbstractParticle {

    private Vec3 target = new Vec3(0, 0, 0);
    private int color = Color.BLACK.asRGB();
    private int durationTicks = 20;


    public ParticleTrail() {
        super("trail");
        particleOptions = new TrailParticleOption(target, color, durationTicks);
    }

    public ParticleTrail target(Vec3 target) {
        this.target = target;
        particleOptions = new TrailParticleOption(target, color, durationTicks);
        return this;
    }

    public ParticleTrail target(Location target) {
        this.target = new Vec3(target.getX(), target.getY(), target.getZ());
        particleOptions = new TrailParticleOption(this.target, color, durationTicks);
        return this;
    }

    public ParticleTrail color(Color color) {
        this.color = color.asRGB();
        particleOptions = new TrailParticleOption(target, color.asRGB(), durationTicks);
        return this;
    }

    public ParticleTrail duration(int durationTicks) {
        this.durationTicks = durationTicks;
        particleOptions = new TrailParticleOption(target, color, durationTicks);
        return this;
    }

}
