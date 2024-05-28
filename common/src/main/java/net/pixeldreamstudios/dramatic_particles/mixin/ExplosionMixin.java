package net.pixeldreamstudios.dramatic_particles.mixin;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.pixeldreamstudios.dramatic_particles.DramaticParticles;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Explosion.class)
public class ExplosionMixin {
    private static final ParticleEmitterInfo EXPLOSION = new ParticleEmitterInfo(new ResourceLocation(DramaticParticles.MOD_ID, "level_up"));

    @Shadow @Final
    private Level level;
    @Shadow @Final
    private double x;
    @Shadow @Final
    private double y;
    @Shadow @Final
    private double z;

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/world/level/Explosion;finalizeExplosion(Z)V")
    private void renderExplosionParticles(boolean bl, CallbackInfo ci) {
        if (DramaticParticles.config.explosionEffect) {
            DramaticParticles.LOGGER.info("EXPLOSION");
            AAALevel.addParticle(level, false, EXPLOSION.clone().scale(1.0f).position(x + 0.5d, y, z + 0.5d));
        }
    }
}
