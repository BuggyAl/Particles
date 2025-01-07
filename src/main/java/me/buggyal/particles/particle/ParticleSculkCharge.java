package me.buggyal.particles.particle;

import net.minecraft.core.particles.SculkChargeParticleOptions;

public class ParticleSculkCharge extends AbstractParticle {

    /**
     * <img src="https://minecraft.wiki/images/Sculk_Charge_%28texture_0%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sculk_Charge_%28texture_1%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sculk_Charge_%28texture_2%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sculk_Charge_%28texture_3%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sculk_Charge_%28texture_4%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sculk_Charge_%28texture_5%29_JE1_BE1.png" width="50" height="50">
     * <img src="https://minecraft.wiki/images/Sculk_Charge_%28texture_6%29_JE1_BE1.png" width="50" height="50">
     */

    public ParticleSculkCharge() {
        super("sculk_charge");
        roll(0);
    }

    public ParticleSculkCharge roll(float roll) {
        particleOptions = new SculkChargeParticleOptions(roll);
        return this;
    }

}
