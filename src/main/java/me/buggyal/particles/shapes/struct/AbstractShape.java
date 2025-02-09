package me.buggyal.particles.shapes.struct;

import me.buggyal.particles.Particles;
import me.buggyal.particles.particle.struct.AbstractParticle;
import org.apache.commons.lang3.Validate;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShape {

    protected BukkitTask runnable = null;
    protected AbstractParticle particle;

    protected boolean async = true;
    protected int delayTicks = 0;
    protected int periodTicks = 1;

    protected List<Player> players = null;

    protected ShapeDistribution distribution = ShapeDistribution.COUNT;
    protected double distributionValue = 100;

    protected List<Vector> pointsToDisplay = new ArrayList<>();

    public AbstractShape particle(AbstractParticle particle) {
        this.particle = particle;
        return this;
    }

    public AbstractShape display() {
        return display(1);
    }

    public AbstractShape display(int ticks) {
        if (runnable != null) return this;
        if (Particles.getPlugin() == null)
            throw new IllegalStateException("Particles is not linked to a plugin! Please execute Particles.setPlugin(this) in your onEnable() method!");
        if (particle == null) throw new IllegalStateException("Particle must be set before displaying!");
        BukkitRunnable runnableTask = new BukkitRunnable() {
            int ticksLeft = ticks;

            @Override
            public void run() {
                boolean defaultPlayers = false;
                if (players == null) {
                    defaultPlayers = true;
                    players = new ArrayList<>(Particles.getPlugin().getServer().getOnlinePlayers());
                }
                // add second check in case the particle is set to null mid-display
                if (particle == null) throw new IllegalStateException("Particle must be set before displaying!");
                tick();
                if (defaultPlayers) players = null;
                if (--ticksLeft <= 0) {
                    cancel();
                    runnable = null;
                }
            }
        };
        if (async) runnable = runnableTask.runTaskTimerAsynchronously(Particles.getPlugin(), delayTicks, periodTicks);
        else runnable = runnableTask.runTaskTimer(Particles.getPlugin(), delayTicks, periodTicks);
        return this;
    }

    public AbstractShape cancel() {
        if (runnable == null) return this;
        runnable.cancel();
        runnable = null;
        return this;
    }

    public abstract void tick();

    public AbstractShape delay(int delayTicks) {
        this.delayTicks = delayTicks;
        return this;
    }

    public AbstractShape period(int periodTicks) {
        this.periodTicks = periodTicks;
        return this;
    }

    public AbstractShape distribution(ShapeDistribution distribution) {
        this.distribution = distribution;
        return this;
    }

    public AbstractShape distributionValue(double distributionValue) {
        Validate.isTrue(distributionValue > 0, "Distribution value must not be negative!");
        this.distributionValue = distributionValue;
        return this;
    }

    public AbstractShape count(int count) {
        Validate.isTrue(distributionValue >= 0, "Particle count must not be negative!");
        this.distribution = ShapeDistribution.COUNT;
        this.distributionValue = count;
        return this;
    }

    public AbstractShape spread(double spread) {
        Validate.isTrue(distributionValue > 0, "Spread must be greater than 0!");
        this.distribution = ShapeDistribution.SPREAD;
        this.distributionValue = spread;
        return this;
    }

    public AbstractShape players(@Nullable List<Player> players) {
        this.players = players;
        return this;
    }

    public AbstractShape addPlayer(@NotNull Player player) {
        if (players == null) players = new ArrayList<>();
        players.add(player);
        return this;
    }

    public AbstractShape removePlayer(@NotNull Player player) {
        if (players == null) return this;
        players.remove(player);
        return this;
    }

    @Nullable
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Note, this will not apply to the current running task.
     * You will need to cancel the current display and start a new one.
     *
     * @param async Whether the task should be run asynchronously or not.
     * @return The new value of async.
     */
    public boolean async(boolean async) {
        this.async = async;
        return async;
    }

    public boolean isAsync() {
        return async;
    }

}
