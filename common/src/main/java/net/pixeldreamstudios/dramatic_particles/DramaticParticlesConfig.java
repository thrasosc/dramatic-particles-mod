package net.pixeldreamstudios.dramatic_particles;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = DramaticParticles.MOD_ID)
public class DramaticParticlesConfig implements ConfigData {
    @Comment("Choose which particles you want to have enabled")
    public final boolean beaconActivateEffect = true;
    public final boolean criticalHitEffect = true;
    public final boolean playerLevelUpEffect = true;
}
