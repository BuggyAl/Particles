package me.buggyal.particles.util;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.joml.Quaterniond;
import org.joml.Vector3d;

import java.util.ArrayList;
import java.util.List;

public class RotationUtil {

    private RotationUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Vector> rotateAroundPoint(List<Vector> points, Quaterniond rotation, Vector center) {
        List<Vector> rotatedPoints = new ArrayList<>();
        for (Vector point : points) {
            Vector3d translated = point.subtract(center).toVector3d();
            translated.rotate(rotation);
            rotatedPoints.add(new Vector(translated.x, translated.y, translated.z).add(center));
        }
        return rotatedPoints;
    }

    public static Vector convertToVector(Location location) {
        return new Vector(location.getX(), location.getY(), location.getZ());
    }

    public static List<Vector> convertToVectorList(List<Location> locations) {
        List<Vector> vectors = new ArrayList<>();
        for (Location location : locations) {
            vectors.add(new Vector(location.getX(), location.getY(), location.getZ()));
        }
        return vectors;
    }

    public static Location convertToLocation(Vector vector, World world) {
        return new Location(world, vector.getX(), vector.getY(), vector.getZ());
    }

    public static List<Location> convertToLocationList(List<Vector> vectors) {
        List<Location> locations = new ArrayList<>();
        for (Vector vector : vectors) {
            locations.add(new Location(null, vector.getX(), vector.getY(), vector.getZ()));
        }
        return locations;
    }

    public static double toRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    public static double toDegrees(double radians) {
        return radians * 180 / Math.PI;
    }

}
