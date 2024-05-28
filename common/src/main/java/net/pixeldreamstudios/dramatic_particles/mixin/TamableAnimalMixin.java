package net.pixeldreamstudios.dramatic_particles.mixin;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.pixeldreamstudios.dramatic_particles.DramaticParticles;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TamableAnimal.class)
public class TamableAnimalMixin {
    private static final ParticleEmitterInfo TAME = new ParticleEmitterInfo(new ResourceLocation(DramaticParticles.MOD_ID, "level_up"));

    private TamableAnimal thisTamableAnimal = (TamableAnimal) (Object) this;
    private Level level = thisTamableAnimal.level();

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/world/entity/TamableAnimal;spawnTamingParticles(Z)V")
    private void renderTamingParticles(boolean bl, CallbackInfo ci) {
        if (DramaticParticles.config.tamingEffect && bl) {
            DramaticParticles.LOGGER.info("TAMED");
            AAALevel.addParticle(level, false, TAME.clone().scale(1.0f).position(thisTamableAnimal.getX() + 0.5d, thisTamableAnimal.getBlockY(), thisTamableAnimal.getZ() + 0.5d));
        }
    }
}