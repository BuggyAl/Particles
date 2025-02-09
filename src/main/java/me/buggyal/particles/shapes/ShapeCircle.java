package me.buggyal.particles.shapes;

import me.buggyal.particles.shapes.struct.AbstractShape;
import me.buggyal.particles.shapes.struct.ShapeDistribution;
import me.buggyal.particles.util.RotationUtil;
import org.apache.commons.lang3.Validate;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class ShapeCircle extends AbstractShape {

    private final World world;
    private Vector centerPos;
    private double radius;

    public ShapeCircle(@NotNull Location centerPos, double radius) {
        this.world = centerPos.getWorld();
        this.centerPos = centerPos.toVector();
        this.radius = radius;
    }

    @Override
    public void tick() {
        // Calculate number of points based on spacing

        Vector loc = centerPos.clone();

        int pointCount = (int) distributionValue;
        if (distribution == ShapeDistribution.SPREAD) {
            Validate.isTrue(distributionValue > 0, "Particle spread must be greater than 0!");
            double circumference = 2 * Math.PI * radius;
            pointCount = (int) Math.round(circumference / distributionValue);
        }

        pointsToDisplay.clear();
        double angleIncrementRadians = 2 * Math.PI / pointCount;

        // Calculate points on the circle
        for (int i = 0; i < pointCount; i++) {
            double angle = i * angleIncrementRadians;
            double x = radius * Math.cos(angle) + loc.getX();
            double z = radius * Math.sin(angle) + loc.getZ();
            Vector point = new Vector(x, loc.getY(), z);
            pointsToDisplay.add(point);
        }

        // Display particles at calculated positions
        for (Vector point : pointsToDisplay) {
            particle.display(RotationUtil.convertToLocation(point, world), players);
        }
    }

    public ShapeCircle centerPos(Location centerPos) {
        this.centerPos = centerPos.toVector();
        return this;
    }

    public ShapeCircle radius(double radius) {
        this.radius = radius;
        return this;
    }

}
