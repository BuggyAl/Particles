package me.buggyal.particles.particle.impl;

import me.buggyal.particles.particle.struct.AbstractParticle;
import net.minecraft.core.particles.ParticleTypes;

public class ParticleVaultConnection extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Vault_connection_JE1_BE1.png" width="50" height="50">
     */

    public ParticleVaultConnection() {
        this.particleOptions = ParticleTypes.VAULT_CONNECTION;
    }

}
