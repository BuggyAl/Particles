package me.buggyal.particles.shapes;

import me.buggyal.particles.shapes.struct.AbstractShape;
import me.buggyal.particles.shapes.struct.ShapeDistribution;
import me.buggyal.particles.util.RotationUtil;
import org.apache.commons.lang3.Validate;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class ShapeLine extends AbstractShape {

    private final World world;
    private Vector pos1;
    private Vector pos2;

    public ShapeLine(@NotNull Location pos1, @NotNull Location pos2) {
        this.world = pos1.getWorld();
        this.pos1 = pos1.toVector();
        this.pos2 = pos2.toVector();
    }

    @Override
    public void tick() {
        Vector vec1 = pos1.clone();
        Vector vec2 = pos2.clone();
        Vector activePos = vec1.clone();
        double distance = vec1.distance(vec2);
        int pointCount = (int) distributionValue;
        if (distribution == ShapeDistribution.SPREAD) {
            Validate.isTrue(distributionValue > 0, "Particle spread must be greater than 0!");
            pointCount = (int) Math.round(pos1.distance(pos2) / distributionValue);
        }

        pointsToDisplay.clear();
        Vector step = vec2.subtract(vec1).normalize().multiply(distance / (pointCount - 1));
        for (int i = 0; i < pointCount; i++) {
            pointsToDisplay.add(activePos.clone());
            activePos.add(step);
        }

        for (Vector point : pointsToDisplay) {
            Location location = RotationUtil.convertToLocation(point, world);
            particle.display(location, players);
        }
    }

    public ShapeLine pos1(Location pos1) {
        this.pos1 = pos1.toVector();
        return this;
    }

    public ShapeLine pos2(Location pos2) {
        this.pos2 = pos2.toVector();
        return this;
    }

}
