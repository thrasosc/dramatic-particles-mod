package net.pixeldreamstudios.dramatic_particles.mixin;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.pixeldreamstudios.dramatic_particles.DramaticParticles;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixin {
    private static final ParticleEmitterInfo LEVEL_UP = new ParticleEmitterInfo(new ResourceLocation(DramaticParticles.MOD_ID, "level_up"));

    private Player thisPlayer = (Player) (Object) this;
    private Level level = thisPlayer.level();

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/world/entity/player/Player;giveExperienceLevels(I)V")
    private void renderLevelUpParticles(int i, CallbackInfo ci) {
        DramaticParticles.LOGGER.info("LEVEL UP");
        AAALevel.addParticle(level, false, LEVEL_UP.clone().scale(1.0f).position(thisPlayer.getX(), thisPlayer.getBlockY(), thisPlayer.getZ()));
    }
}