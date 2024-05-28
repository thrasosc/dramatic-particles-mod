package net.pixeldreamstudios.dramatic_particles.mixin;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.pixeldreamstudios.dramatic_particles.DramaticParticles;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeaconBlockEntity.class)
public class BeaconBlockEntityMixin {
    private static final ParticleEmitterInfo BEACON_ACTIVATE = new ParticleEmitterInfo(new ResourceLocation(DramaticParticles.MOD_ID, "level_up"));

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/world/level/block/entity/BeaconBlockEntity;playSound(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;)V")
    private static void renderBeaconActivateParticles(Level level, BlockPos blockPos, SoundEvent soundEvent, CallbackInfo ci) {
        DramaticParticles.LOGGER.info("ACTIVATED BEACON");
        AAALevel.addParticle(level, false, BEACON_ACTIVATE.clone().scale(1.0f).position(blockPos.getX() + 0.5d, blockPos.getY(), blockPos.getZ() + 0.5d));
    }
}
