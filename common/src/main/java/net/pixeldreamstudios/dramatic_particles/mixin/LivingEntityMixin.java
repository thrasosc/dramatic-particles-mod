package net.pixeldreamstudios.dramatic_particles.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z")
    private void renderHurtParticles(DamageSource arg, float g, CallbackInfoReturnable<Boolean> ci) {
        LivingEntity thisLivingEntity = (LivingEntity) (Object) this;
        Level level = thisLivingEntity.level();
//        DramaticParticles.LOGGER.info("Arrow: " + arg.is(DamageTypeTags.BYPASSES_RESISTANCE);

//        if (arg.is(Damage)) {
//            AAALevel.addParticle(level, false, CRITICAL_HIT.clone().scale(0.3f).position(thisLivingEntity.getX(), thisLivingEntity.getBlockY() + 1.0d, thisLivingEntity.getZ()));
//        }
    }
}
