package me.buggyal.particles;

import org.bukkit.plugin.Plugin;

import java.util.concurrent.ThreadLocalRandom;

public class Particles {

    private static Plugin plugin = null;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    private Particles() {
        throw new IllegalStateException("Utility class");
    }

    public static void setPlugin(Plugin plugin) {
        Particles.plugin = plugin;
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static ThreadLocalRandom getRandom() {
        return random;
    }

}
