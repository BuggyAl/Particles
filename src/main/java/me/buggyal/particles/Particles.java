package me.buggyal.particles;

import org.bukkit.plugin.Plugin;

public class Particles {

    private static Plugin plugin = null;

    private Particles() {
        throw new IllegalStateException("Utility class");
    }

    public static void setPlugin(Plugin plugin) {
        Particles.plugin = plugin;
    }

    public static Plugin getPlugin() {
        return plugin;
    }

}
