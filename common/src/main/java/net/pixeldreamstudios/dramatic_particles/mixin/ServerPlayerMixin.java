package net.pixeldreamstudios.dramatic_particles.mixin;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.pixeldreamstudios.dramatic_particles.DramaticParticles;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin {
    private static final ParticleEmitterInfo CRITICAL_HIT = new ParticleEmitterInfo(new ResourceLocation(DramaticParticles.MOD_ID, "critical_hit"));

    private ServerPlayer thisServerPlayer = (ServerPlayer) (Object) this;
    private Level level = thisServerPlayer.level();

    @Inject(at = @At("HEAD"), method = "crit")
    private void renderCriticalHitParticles(Entity entity, CallbackInfo ci) {
        if (DramaticParticles.config.criticalHitEffect) {
            DramaticParticles.LOGGER.info("CRITICAL HIT");
            AAALevel.addParticle(level, false, CRITICAL_HIT.clone().scale(1.0f).position(entity.getX(), entity.getBlockY() + 1.0d, entity.getZ()));
        }
    }
}
