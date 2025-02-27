package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;
import org.bukkit.util.Vector;

public class ParticleNote extends AbstractParticle {

    private double color = 0;

    /**
     * <img src="https://minecraft.wiki/images/Note_%28texture%29_JE1_BE1.png" width="50" height="50"><br>
     * The note particle uses the <b>X offset</b> to determine the color of the particle.
     * Because of this, the color must be inputted as a decimal number.
     * The color cycle goes from <b>0 to 1</b>, repeating itself at higher or lower values.
     * A color chart is provided for convenience below, courtesy of GamerGeeks.<br>
     * <img src="https://i.imgur.com/OIbARR5.png">
     */

    public ParticleNote() {
        this.particleOptions = ParticleTypes.NOTE;
    }

    public ParticleNote color(double color) {
        this.color = color;
        return this;
    }

    @Override
    public Vector getTrueOffsets() {
        return new Vector(color, 0, 0);
    }

}
